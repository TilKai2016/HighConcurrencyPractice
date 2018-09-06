package com.tilkai.highconcurrency.service;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Note:
 *
 * @author tilkai
 * @date 2018-09-06 下午5:06
 */
@Service
public class RedisService {

    @Autowired
    private JedisPool jedisPool;


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

    private void returnToPool(Jedis jedis) {
       if (jedis != null) {
           jedis.close();
       }
    }

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

}
