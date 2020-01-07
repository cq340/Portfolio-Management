package com.citi.response.util;


import com.citi.response.entity.Response;
import com.citi.response.entity.ResponseEnum;

public class ResponseUtil {

    public static <T> Response<T> success(T t) {
        return new Response<>(t);
    }

    public static <T> Response<T> success() {
        return new Response<>(null);
    }

    public static Response error(int code, String msg) {
        return new Response<>(code,msg,null);
    }

    public static Response error(ResponseEnum e) {
        return new Response<>(e, null);
    }
}
