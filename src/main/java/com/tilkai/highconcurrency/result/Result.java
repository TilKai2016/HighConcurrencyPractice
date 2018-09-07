package com.tilkai.highconcurrency.result;

import lombok.Getter;

/**
 * Note: Controller返回结果集的封装类
 *
 * @author tilkai
 * @date 2018-09-05 下午9:59
 */
@Getter
public class Result<T> {

    private Result(CodeMsg cm) {
        if (cm == null) {
            return;
        }
        this.code = cm.getCode();
        this.msg = cm.getMsg();
    }

    /**
     * 状态码
     */
    private int code;

    /**
     * 消息内容
     * <p>一般发生错误时使用它, 用于在前台展示错误信息提醒</p>
     */
    private String msg;

    /**
     * 数据体
     */
    private T data;

    public static <T> Result<T> success(T data) {

        Result result = new Result(CodeMsg.SUCCESS);
        result.data = data;

        return result;
    }

    public static <T> Result<T> error(CodeMsg cm) {
        return new Result<>(cm);
    }
}
