package com.bun.xh.exception;

/**
 * Created by xin on 2018/4/7.
 */
public class BunServiceException extends Exception{

    private String code;

    public BunServiceException(String message) {
        super(message);
    }

    public BunServiceException(String code, String message) {
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
