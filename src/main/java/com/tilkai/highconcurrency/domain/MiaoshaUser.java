package com.tilkai.highconcurrency.domain;

import lombok.Data;

import java.util.Date;

/**
 * Note: 秒杀用户
 *
 * @author tilkai
 * @date 2018-09-07 下午12:12
 */
@Data
public class MiaoshaUser {

    /**
     * 用户id, 手机号码
     */
    private Long id;

    /**
     * 用户昵称
     */
    private String nickname;

    /**
     * 两次MD5加密后的密文密码
     */
    private String password;

    /**
     * 密码盐
     */
    private String salt;

    /**
     * 头像, 云存储的id
     */
    private String head;

    /**
     *注册时间
     */
    private Date registerDate;

    /**
     * 上次登录时间
     */
    private Date lastLoginDate;

    /**
     * 登录次数
     */
    private Integer loginCount;
}
