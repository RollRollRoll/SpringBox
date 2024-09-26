package com.demo.controllerlayer.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author cj
 * @created on 9/26/24
 */
@Getter
@AllArgsConstructor
public enum ResultEnum implements IResult {
    SUCCESS(2001, "接口调用成功"),
    VALIDATE_FAILED(2002, "参数校验失败"),
    COMMON_FAILED(2003, "接口调用失败"),
    FORBIDDEN(2004, "没有权限访问资源");

    private Integer code;
    private String message;
}
