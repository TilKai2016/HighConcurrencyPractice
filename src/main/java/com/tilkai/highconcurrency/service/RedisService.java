package com.tilkai.highconcurrency.service;

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
     * note 获取主键对应的clazz.class类型的value
     * @param key
     * @param clazz
     * @return
     * @author tilkai
     * @date 2018/9/6
     */
    public <T> T get(String key, Class<T> clazz) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            String beanStr = jedis.get(key);
            T t = stringToBean(beanStr, clazz);
            return t;
        } finally {
            returnToPool(jedis);
        }
    }

    /**
     * note 向Redis缓存中添加数据
     * @param key
     * @param value
     * @return
     * @author tilkai
     * @date 2018/9/6
     */
    public <T> boolean set(String key, T value) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            String beanStr = beanToString(value);
            if (beanStr == null || beanStr.length() <= 0) {
                return false;
            } else {
                jedis.set(key, beanStr);
                return true;
            }
        } finally {
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