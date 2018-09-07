package com.tilkai.highconcurrency.exception;

import com.tilkai.highconcurrency.result.CodeMsg;
import lombok.Getter;

/**
 * Note:
 *
 * @author tilkai
 * @date 2018-09-07 下午11:01
 */
@Getter
public class GlobalException extends RuntimeException {

    static final long serialVersionUID = 1L;

    private CodeMsg codeMsg;

    public GlobalException(CodeMsg codeMsg) {
        super(codeMsg.toString());

        this.codeMsg = codeMsg;
    }
}
