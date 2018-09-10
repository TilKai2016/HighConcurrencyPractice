package com.tilkai.highconcurrency.redis;

/**
 * Note: 秒杀用户Redis key前缀
 *
 * @author tilkai
 * @date 2018-09-08 下午8:13
 */
public class MiaoshaUserKey extends BaseKeyPrefix {

    public MiaoshaUserKey(String prefix) {
        super(prefix);
    }

    /**
     * note
     * @param expireSeconds 到期时间(单位 秒)
     * @param prefix key前缀
     * @return
     * @author tilkai
     * @date 2018/9/10
     */
    public MiaoshaUserKey(int expireSeconds, String prefix) {
        super(expireSeconds, prefix);
    }

    /**
     * session到期时间
     */
    public static final int TOKEN_EXPIRE = 3600 * 24;

    /**
     * Redis 保存秒杀用户token的key
     */
    public static MiaoshaUserKey token = new MiaoshaUserKey(TOKEN_EXPIRE, "tk");
}
