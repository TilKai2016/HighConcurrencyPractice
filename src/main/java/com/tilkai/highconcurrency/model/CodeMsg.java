package com.tilkai.highconcurrency.model;

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

    public static CodeMsg SERVER_ERROR = new CodeMsg(1, "server error");

    // 登录模块 5002XX

    // 商品模块 5003XX

    // 订单模块 5004XX

    // 秒杀模块 5005XX

}
