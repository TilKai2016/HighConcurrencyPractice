package com.tilkai.highconcurrency.util;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * Note:
 *
 * @author tilkai
 * @date 2018-09-07 下午12:25
 */
public class MD5Utils {

    public static String md5(String src) {

        return DigestUtils.md5Hex(src);
    }

    private static final String salt = "1a2b3c4d";

    /**
     * note 将用户输入密码转换成form表单密码
     * @param
     * @return
     * @author tilkai
     * @date 2018/9/7
     */
    public static String inputPassToFromPass(String inputPass) {
        String str = "" + salt.charAt(0) + salt.charAt(2) + inputPass + salt.charAt(5) + salt.charAt(4);

        return md5(str);
    }

    /**
     * note 将form表单密码转换成DB密码
     * @param
     * @return
     * @author tilkai
     * @date 2018/9/7
     */
    public static String formPassToDbPass(String formPass, String dbSalt) {
        String str = "" + dbSalt.charAt(0) + dbSalt.charAt(2) + formPass + dbSalt.charAt(5) + dbSalt.charAt(4);

        return md5(str);
    }

    /**
     * note 将用户输入密码转换成DB密码
     * @param
     * @return
     * @author tilkai
     * @date 2018/9/7
     */
    public static String inputPassToDbPass(String inputPass, String dbSalt) {
        return formPassToDbPass(inputPassToFromPass(inputPass), dbSalt);
    }

    public static void main(String[] args) {
//        System.out.println(inputPassToFromPass("123456"));
        System.out.println(inputPassToDbPass("123456", "1a2b3c4d"));
    }
}
