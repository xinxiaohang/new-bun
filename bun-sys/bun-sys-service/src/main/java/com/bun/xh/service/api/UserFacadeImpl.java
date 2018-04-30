package com.bun.xh.service.api;

import com.alibaba.fastjson.JSON;
import com.bun.xh.api.UserFacade;
import com.bun.xh.biz.userhandler.BeCheckHandler;
import com.bun.xh.biz.userhandler.LoginHandler;
import com.bun.xh.biz.userhandler.RegisterHandler;
import com.bun.xh.exception.BunServerException;
import com.bun.xh.exception.BunServiceException;
import com.bun.xh.service.convert.ExceptionConvert;
import com.bun.xh.vo.BeCheckRequest;
import com.bun.xh.vo.BeCheckResponse;
import com.bun.xh.vo.LoginRequest;
import com.bun.xh.vo.LoginResponse;
import com.bun.xh.vo.RegisterRequest;
import com.bun.xh.vo.RegisterResponse;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by xin on 2018/4/6.
 */
@Service
public class UserFacadeImpl implements UserFacade {

    private static Logger LOG = Logger.getLogger(UserFacadeImpl.class);

    @Autowired
    private RegisterHandler registerHandler;

    @Autowired
    private LoginHandler loginHandler;

    @Autowired
    private BeCheckHandler beCheckHandler;

    public RegisterResponse register(RegisterRequest request) throws BunServerException,BunServiceException{

        RegisterResponse response = new RegisterResponse();

        try {
            LOG.info("用户注册开始|请求报文" + JSON.toJSONString(request));
            response = registerHandler.register(request);
            LOG.info("用户注册结束|返回报文" + JSON.toJSONString(response));
            ExceptionConvert.CreateException(response);
        }catch (Exception e){
            LOG.error("用户注册异常",e);
            ExceptionConvert.throwException(e);
        }
        return response;
    }

    public LoginResponse login(LoginRequest request) throws BunServerException,BunServiceException {
        LoginResponse response = new LoginResponse();

        try {
            LOG.info("用户登录开始|请求报文" + JSON.toJSONString(request));
            response = loginHandler.login(request);
            LOG.info("用户登录结束|返回报文" + JSON.toJSONString(response));
            ExceptionConvert.CreateException(response);
        }catch (Exception e){
            LOG.error("用户登录异常",e);
            ExceptionConvert.throwException(e);
        }
        return response;
    }

    public BeCheckResponse beCheck(BeCheckRequest request) throws BunServiceException, BunServerException {
        BeCheckResponse response = new BeCheckResponse();

        try {
            LOG.info("成为新闻审核人开始开始|请求报文" + JSON.toJSONString(request));
            response = beCheckHandler.beCheck(request);
            LOG.info("成为新闻审核人开始结束|返回报文" + JSON.toJSONString(response));
            ExceptionConvert.CreateException(response);
        }catch (Exception e){
            LOG.error("成为新闻审核人开始异常",e);
            ExceptionConvert.throwException(e);
        }
        return response;
    }
}
