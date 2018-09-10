package com.tilkai.highconcurrency.redis;

/**
 * Note:
 *
 * @author tilkai
 * @date 2018-09-07 上午9:28
 */
public abstract class BaseKeyPrefix implements KeyPrefix {

    /**
     * redis到期时间
     */
    private int expireSeconds;

    /**
     * redis-key前缀
     */
    private String prefix;

    /**
     * note
     * @param prefix
     * @return
     * @author tilkai
     * @date 2018/9/7
     */
    public BaseKeyPrefix(String prefix) {
        this(0, prefix);
    }

    /**
     * note
     * @param expireSeconds 0代表永不过期.
     * @param prefix
     * @return
     * @author tilkai
     * @date 2018/9/7
     */
    public BaseKeyPrefix(int expireSeconds, String prefix) {
        this.expireSeconds = expireSeconds;
        this.prefix = prefix;
    }

    @Override
    public int expireSeconds() {
        return expireSeconds;
    }

    @Override
    public String getPrefix() {
        String className = getClass().getSimpleName();
        return className + ":" + prefix;
    }
}
