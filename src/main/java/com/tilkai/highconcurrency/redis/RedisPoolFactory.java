package com.tilkai.highconcurrency.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Note:
 *
 * @author tilkai
 * @date 2018-09-06 下午10:20
 */
@Configuration
public class RedisPoolFactory {

    @Autowired
    private RedisPropertiesConfig redisPropertiesConfig;

    @Bean
    public JedisPool jedisFactory() {
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxIdle(redisPropertiesConfig.getPoolMaxIdle());
        poolConfig.setMaxTotal(redisPropertiesConfig.getPoolMaxTotal());
        poolConfig.setMaxWaitMillis(redisPropertiesConfig.getPoolMaxWait() * 1000);

        JedisPool jedisPool = new JedisPool(poolConfig, redisPropertiesConfig.getHost(), redisPropertiesConfig.getPort(),
                redisPropertiesConfig.getTimeout() * 1000, redisPropertiesConfig.getPassword());

        return jedisPool;
    }
}
