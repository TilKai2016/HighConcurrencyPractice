package com.tilkai.highconcurrency.vo;

import com.tilkai.highconcurrency.Validator.IsMobile;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * Note: 接收登录请求参数
 *
 * @author tilkai
 * @date 2018-09-07 下午3:49
 */
@Data
public class LoginVo {

    @NotNull
    @IsMobile
    private String  mobile;

    @NotNull
    @Length(min = 32)
    private String password;
}
