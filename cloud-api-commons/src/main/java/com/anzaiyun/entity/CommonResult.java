package com.anzaiyun.entity;

/**
 * 测试RestTemplate未成功
 * @param <T>
 */
public class CommonResult<T> {

    private Integer code;
    private String message;
    private T      data;

    public CommonResult(Integer code,String message){
        this.code = code;
        this.message = message;
    }
}
