package com.example.mycloudmusicapi.exception;

import com.example.mycloudmusicapi.response.ResponseCode;

/**
 * 自定义异常类
 */
public class MyException extends RuntimeException {

    private ResponseCode responseCode;

    public MyException(ResponseCode responseCode){
        this.responseCode = responseCode;
    }

    public ResponseCode getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(ResponseCode responseCode) {
        this.responseCode = responseCode;
    }
}
