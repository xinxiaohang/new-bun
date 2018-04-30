package com.bun.xh.service.convert;

import com.bun.xh.enums.ResultCodeEnum;
import com.bun.xh.exception.BunServerException;
import com.bun.xh.exception.BunServiceException;
import com.bun.xh.vo.AbstractResponse;

/**
 * Created by xin on 2018/4/7.
 */
public class ExceptionConvert {

    public static void CreateException(AbstractResponse response) throws BunServiceException,BunServerException{
        if(!response.getResultCode().equals(ResultCodeEnum.SUCCESS.getCode())){
            if(1 == ResultCodeEnum.getEFlagByCode(response.getResultCode())){
                throw new BunServiceException(response.getResultCode(),response.getResultMessage());
            }else if(2 == ResultCodeEnum.getEFlagByCode(response.getResultCode())){
                throw new BunServerException(response.getResultCode(),response.getResultMessage());
            }
        }
    }

    public static void throwException(Exception e)throws BunServerException,BunServiceException{
        if(e instanceof BunServerException){
            throw (BunServerException) e;
        }else if(e instanceof BunServiceException){
            throw (BunServiceException)e;
        }else {
            throw new BunServerException("系统异常");
        }
    }
}
