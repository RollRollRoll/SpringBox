package com.demo.controllerlayer.exception;

/**
 * @author cj
 * @created on 9/26/24
 */
//自定义异常
public class BusinessException extends RuntimeException {
    public BusinessException(String message) {
        super(message);
    }
}