package com.bun.xh.biz;

import com.bun.xh.enums.ResultCodeEnum;
import com.bun.xh.vo.AbstractResponse;

public class AbstractHandler {
    public AbstractResponse buildAbstractResponse(AbstractResponse response, ResultCodeEnum resultCodeEnum){
        response.setResultCode(resultCodeEnum.getCode());
        response.setResultMessage(resultCodeEnum.getMessage());
        return response;
    }
}