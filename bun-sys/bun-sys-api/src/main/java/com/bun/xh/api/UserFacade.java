package com.bun.xh.api;

import com.bun.xh.exception.BunServerException;
import com.bun.xh.exception.BunServiceException;
import com.bun.xh.vo.BeCheckRequest;
import com.bun.xh.vo.BeCheckResponse;
import com.bun.xh.vo.LoginRequest;
import com.bun.xh.vo.LoginResponse;
import com.bun.xh.vo.RegisterRequest;
import com.bun.xh.vo.RegisterResponse;

/**
 * Created by xin on 2018/4/6.
 */
public interface UserFacade {

    RegisterResponse register(RegisterRequest request) throws BunServiceException,BunServerException;

    LoginResponse login(LoginRequest request) throws BunServiceException,BunServerException;

    BeCheckResponse beCheck(BeCheckRequest request) throws BunServiceException,BunServerException;
}
