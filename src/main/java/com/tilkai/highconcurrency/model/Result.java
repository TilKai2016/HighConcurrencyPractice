package com.tilkai.highconcurrency.model;

import lombok.Getter;

/**
 * Note:
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

    private int code;

    private String msg;

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
