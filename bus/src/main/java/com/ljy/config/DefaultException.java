package com.ljy.config;

import com.ljy.util.ResultJson;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class DefaultException {
    @ExceptionHandler
    public ResultJson defaultExceptionHandler(Exception ex){
        /**
         * 以动手实践为荣，以只看不练为耻
         * 以日志输出为荣，以出错不报为耻
         * 以枚举常量为荣，以魔法数字为耻
         * 以多态复用为荣，以复制粘贴为耻
         *
         */
        ex.printStackTrace();
        return ResultJson.error(ex.getMessage());
    }
}
