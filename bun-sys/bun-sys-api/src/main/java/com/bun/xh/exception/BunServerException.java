package com.bun.xh.exception;


import java.rmi.ServerException;

/**
 * Created by xin on 2018/4/7.
 */
public class BunServerException extends Exception {

    private String code;

    public BunServerException(String message) {
        super(message);
    }

    public BunServerException(String code, String message) {
        super(message);
        setCode(code);
    }

    public void setCode(String code){
        this.code = code;
    }

    public String getCode(){
        return code;
    }
}
