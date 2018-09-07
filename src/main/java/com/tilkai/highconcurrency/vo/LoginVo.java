package com.tilkai.highconcurrency.vo;

import lombok.Data;

/**
 * Note: 接收登录请求参数
 *
 * @author tilkai
 * @date 2018-09-07 下午3:49
 */
@Data
public class LoginVo {

    private String  mobile;
    private String password;
}
