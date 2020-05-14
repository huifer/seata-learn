package org.huifer.seata.product.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity exceptionHandle(Exception e) { // 处理方法参数的异常类型
        return null;//自己需要实现的异常处理
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public ResponseEntity handle(Throwable e) {
        return null; //自己需要实现的异常处理
    }
}