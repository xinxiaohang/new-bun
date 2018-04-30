package com.bun.xh.service.user;

import com.bun.xh.enums.ResultCodeEnum;
import com.bun.xh.exception.BunServerException;
import com.bun.xh.exception.BunServiceException;
import com.bun.xh.vo.BeCheckRequest;
import com.bun.xh.vo.BeCheckResponse;
import com.bun.xh.vo.LoginRequest;
import com.bun.xh.vo.LoginResponse;
import com.bun.xh.vo.RegisterRequest;
import com.bun.xh.vo.RegisterResponse;
import org.junit.Assert;
import org.junit.Test;

public class BeCheck extends AbstractUser {

    @Test
    public void test() throws BunServiceException, BunServerException {
        String userId = String.valueOf(System.currentTimeMillis());
        String password = "MTIzYWJjJSMuPyU=";
        RegisterRequest registerRequest = buildRegisterRequest(userId,password);
        RegisterResponse registerResponse = userFacade.register(registerRequest);

        LoginRequest loginRequest = buildLoginRequest(userId,password);
        LoginResponse loginResponse = userFacade.login(loginRequest);

        BeCheckRequest beCheckRequest = buildBeCheckRequest(userId);
        BeCheckResponse beCheckResponse = userFacade.beCheck(beCheckRequest);
        Assert.assertEquals(ResultCodeEnum.SUCCESS.getCode(),beCheckResponse.getResultCode());
    }
}