package com.tilkai.highconcurrency.exception;

import com.tilkai.highconcurrency.result.CodeMsg;
import com.tilkai.highconcurrency.result.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Note: 全局异常处理程序
 *
 * @author tilkai
 * @date 2018-09-07 下午10:24
 */
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    public Result exceptionHandler(HttpServletRequest request, Exception e) {

        e.printStackTrace();
        if (e instanceof GlobalException) {
            GlobalException globalException = (GlobalException) e;
            CodeMsg codeMsg = globalException.getCodeMsg();
            return Result.error(codeMsg);
        } else if (e instanceof BindException) {
            BindException bindException = (BindException) e;
            List<ObjectError> allErrors = bindException.getAllErrors();
            ObjectError error = allErrors.get(0);
            return Result.error(CodeMsg.BIND_ERROR.fillArgs(error.getDefaultMessage()));
        } else {
            return Result.error(CodeMsg.SERVER_ERROR);
        }

    }

}
