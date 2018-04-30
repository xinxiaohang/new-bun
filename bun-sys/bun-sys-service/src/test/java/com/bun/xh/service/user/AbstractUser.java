package com.bun.xh.service.user;

import com.bun.xh.api.UserFacade;
import com.bun.xh.vo.BeCheckRequest;
import com.bun.xh.vo.LoginRequest;
import com.bun.xh.vo.RegisterRequest;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:config/spring/applicationContext-boot.xml")
public class AbstractUser {

    @Autowired
    protected UserFacade userFacade;

    protected RegisterRequest buildRegisterRequest(String userId,String password){
        RegisterRequest request = new RegisterRequest();
        request.setUserPic("测试图片");
        request.setUserId(userId);
        request.setUserName("测试用户名");
        request.setPassword(password);
        return request;
    }

    protected LoginRequest buildLoginRequest(String userId,String password){
        LoginRequest request = new LoginRequest();
        request.setPassword(password);
        request.setUserId(userId);
        return request;
    }

    protected BeCheckRequest buildBeCheckRequest(String userId){
        BeCheckRequest request = new BeCheckRequest();
        request.setUserId(userId);
        return request;
    }
}