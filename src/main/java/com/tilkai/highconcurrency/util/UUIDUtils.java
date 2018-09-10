package com.tilkai.highconcurrency.util;

import java.util.UUID;

/**
 * Note: UUID生成工具类
 *
 * @author tilkai
 * @date 2018-09-08 下午5:16
 */
public class UUIDUtils {

    public static String uuid() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
