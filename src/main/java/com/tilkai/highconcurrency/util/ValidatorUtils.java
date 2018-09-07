package com.tilkai.highconcurrency.util;

import org.springframework.util.StringUtils;

import java.util.regex.Pattern;

/**
 * Note: 校验工具
 *
 * @author tilkai
 * @date 2018-09-07 下午4:12
 */
public class ValidatorUtils {

    // 手机号表达式
    private static final Pattern mobile_pattern = Pattern.compile("^(13|15|18)\\d{9}$");

    public static boolean isMobile(String src) {
        if (StringUtils.isEmpty(src)) {
            return false;
        }
        return mobile_pattern.matcher(src).matches();
    }
}
