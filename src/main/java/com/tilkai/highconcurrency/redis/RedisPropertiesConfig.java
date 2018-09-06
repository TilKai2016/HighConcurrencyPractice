package com.tilkai.highconcurrency.redis;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Note:
 *
 * @author tilkai
 * @date 2018-09-06 下午4:58
 */
@Data
@Component
@ConfigurationProperties(prefix = RedisPropertiesConfig.REDIS_PREFIX)
public class RedisPropertiesConfig {

    public static final String REDIS_PREFIX = "redis";

    private String host;

    private int port;

    private String password;

    private int timeout;

    private int poolMaxTotal;

    private int poolMaxIdle;

    private int poolMaxWait;
}
