package com.tilkai.highconcurrency.redis;

/**
 * Note:
 *
 * @author tilkai
 * @date 2018-09-07 上午9:36
 */
public class UserKey extends BaseKeyPrefix {

    private UserKey(String prefix) {
        super(prefix);
    }

    public static UserKey getById = new UserKey("id");

    public static UserKey getByName = new UserKey("name");
}
