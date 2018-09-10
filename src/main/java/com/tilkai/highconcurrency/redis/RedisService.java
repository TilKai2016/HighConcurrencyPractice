package com.tilkai.highconcurrency.redis;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Note: Redis缓存处理类
 *
 * @author tilkai
 * @date 2018-09-06 下午5:06
 */
@Service
public class RedisService {

    @Autowired
    private JedisPool jedisPool;

    /**
     * note 获取单个缓存对象
     * @param prefix key前缀
     * @param key key后缀
     * @param clazz 缓存数据类型
     * @return
     * @author tilkai
     * @date 2018/9/6
     */
    public <T> T get(KeyPrefix prefix, String key, Class<T> clazz) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            String realKey = prefix.getPrefix() + key;
            String beanStr = jedis.get(realKey);
            return stringToBean(beanStr, clazz);
        } finally {
            returnToPool(jedis);
        }
    }

    /**
     * note 设置对象
     * @param prefix
     * @param key
     * @param value
     * @return
     * @author tilkai
     * @date 2018/9/6
     */
    public <T> boolean set(KeyPrefix prefix, String key, T value) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            String beanStr = beanToString(value);
            if (beanStr == null || beanStr.length() <= 0) {
                return false;
            }
            String realKey = prefix.getPrefix() + key;
            if (prefix.expireSeconds() <= 0) {
                jedis.set(realKey, beanStr);
            } else {
                // 设置带有效期的缓存.
                jedis.setex(realKey, prefix.expireSeconds(), beanStr);
            }
            return true;
        } finally {
            returnToPool(jedis);
        }
    }

    /**
     * note 判断realKey是否存在
     * @param prefix
     * @param key
     * @return
     * @author tilkai
     * @date 2018/9/7
     */
    public <T> boolean isExists(KeyPrefix prefix, String key) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            String realKey = prefix.getPrefix() + key;
            return jedis.exists(realKey);
        } finally {
            returnToPool(jedis);
        }
    }

    /**
     * note 增加值
     * @param prefix
     * @param key
     * @return
     * @author tilkai
     * @date 2018/9/7
     */
    public <T> Long incr(KeyPrefix prefix, String key) {
        Jedis jedis = null;
        try {
            jedis =  jedisPool.getResource();
            //生成真正的key
            String realKey  = prefix.getPrefix() + key;
            return  jedis.incr(realKey);
        }finally {
            returnToPool(jedis);
        }
    }

    /**
     * note 减少值
     * @param prefix
     * @param key
     * @return
     * @author tilkai
     * @date 2018/9/7
     */
    public <T> Long decr(KeyPrefix prefix, String key) {
        Jedis jedis = null;
        try {
            jedis =  jedisPool.getResource();
            //生成真正的key
            String realKey  = prefix.getPrefix() + key;
            return  jedis.decr(realKey);
        }finally {
            returnToPool(jedis);
        }
    }

    /**
     * note 将实体转换为字符串并返回
     * @param value
     * @return 
     * @author tilkai
     * @date 2018/9/6
     */
    private <T> String beanToString(T value) {
        
        if (value == null) {
            return null;
        }
        
        Class<?> clazz = value.getClass();
        if (clazz == int.class || clazz == Integer.class) {
            return "" + value;
        } else if (clazz == String.class) {
            return (String) value;
        } else if (clazz == long.class || clazz == Long.class) {
            return "" + value;
        } else {
            return JSON.toJSONString(value);
        }
        // TODO TilKai :  2018/9/6 根据实际情况完善分支内容. 
    }

    /**
     * note 将字符串转换为实体并返回
     * @param beanStr
     * @param clazz
     * @return
     * @author tilkai
     * @date 2018/9/6
     */
    private <T> T stringToBean(String beanStr, Class<T> clazz) {

        if (beanStr == null || beanStr.length() <= 0 || clazz == null) {
            return null;
        }

        if (clazz == int.class || clazz == Integer.class) {
            return (T) Integer.valueOf(beanStr);
        } else if (clazz == String.class) {
            return (T) beanStr;
        } else if (clazz == long.class || clazz == Long.class) {
            return (T) Long.valueOf(beanStr);
        } else {
            return JSON.toJavaObject(JSON.parseObject(beanStr), clazz);
        }
    }

    /**
     * note 无论是否异常, 使用完毕后将Jedis资源归还给连接池, 防止连接丢失导致超出连接池最大连接数.
     * @param jedis
     * @return
     * @author tilkai
     * @date 2018/9/6
     */
    private void returnToPool(Jedis jedis) {
        if (jedis != null) {
            jedis.close();
        }
    }
}
