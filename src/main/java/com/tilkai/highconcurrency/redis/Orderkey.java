package com.tilkai.highconcurrency.redis;

/**
 * Note:
 *
 * @author tilkai
 * @date 2018-09-07 上午9:37
 */
public class Orderkey extends BaseKeyPrefix {

    private Orderkey(int expireSeconds, String prefix) {
        super(expireSeconds, prefix);
    }

}
