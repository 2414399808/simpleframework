package com.zsh.pojo.dto;

import lombok.Data;

@Data
public class Result<T> {
    //本次请求结果的状态码
    private int code;
    //本次请求结果的详情
    private String msg;
    //本次返回结果的结果集
    private T data;
}
