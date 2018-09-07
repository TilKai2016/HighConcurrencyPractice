package com.tilkai.highconcurrency.result;

import lombok.Getter;

/**
 * Note: 状态码和消息内容的封装类
 * <p>为了限制封装, 私有化构造方法, 只保留get方法</p>
 *
 * @author tilkai
 * @date 2018-09-05 下午10:09
 */
@Getter
public class CodeMsg {

    private CodeMsg(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private int code;

    private String msg;

    // 通用异常

    public static CodeMsg SUCCESS = new CodeMsg(0, "success");
    public static CodeMsg SERVER_ERROR = new CodeMsg(500100, "server error");
    public static CodeMsg BIND_ERROR = new CodeMsg(500101, "参数检查异常: %s");

    // 登录模块 5002XX

    public static CodeMsg PASSWORD_EMPTY = new CodeMsg(500211, "密码不能为空");
    public static CodeMsg MOBILE_EMPTY = new CodeMsg(500212, "手机号不能为空");
    public static CodeMsg MOBILE_ERROR = new CodeMsg(500213, "手机号格式错误");
    public static CodeMsg MOBILE_NOT_EXIST = new CodeMsg(500214, "手机号不存在");
    public static CodeMsg PASSWORD_ERROR = new CodeMsg(500215, "密码错误");

    // 商品模块 5003XX

    // 订单模块 5004XX

    // 秒杀模块 5005XX

    public CodeMsg fillArgs(Object... args) {
        int code = this.code;
        String msg = String.format(this.msg, args);
        return new CodeMsg(code, msg);
    }

}
