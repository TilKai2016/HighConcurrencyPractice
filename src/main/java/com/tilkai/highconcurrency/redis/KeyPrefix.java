package com.tilkai.highconcurrency.redis;

/**
 * Note: key前缀规范的接口
 *
 * @author tilkai
 * @date 2018-09-07 上午9:23
 */
public interface KeyPrefix {

    /**
     * note Redis缓存有效期
     * @param
     * @return
     * @author tilkai
     * @date 2018/9/7
     */
    int expireSeconds();

    /**
     * note 获取前缀
     * @param
     * @return
     * @author tilkai
     * @date 2018/9/7
     */
    String getPrefix();
}
