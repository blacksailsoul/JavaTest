package com.whlg.store.utils;

import lombok.Data;


@Data
public class JsonResult<E> {
    //状态码
    private Integer code;
    private String message;
    private E data;


    public JsonResult() {
    }

    public JsonResult(Integer code) {
        this.code = code;
    }

    public JsonResult(Throwable e) {
        //出现异常调用提示信息
        this.message = e.getMessage();
    }

    public JsonResult(Integer code, E data) {
        this.code = code;
        this.data = data;
    }
}
