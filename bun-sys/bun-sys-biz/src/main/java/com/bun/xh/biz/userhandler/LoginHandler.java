package com.bun.xh.biz.userhandler;

import com.bun.xh.comm.tools.PasswordUtil;
import com.bun.xh.enums.ResultCodeEnum;
import com.bun.xh.repository.dto.UserDTO;
import com.bun.xh.vo.LoginRequest;
import com.bun.xh.vo.LoginResponse;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class LoginHandler extends AbstractUserHandler {

    public LoginResponse login(LoginRequest request){
        LoginResponse response = new LoginResponse();

        UserDTO userDTO = selectUserByUserId(request.getUserId());

        if(StringUtils.isEmpty(userDTO)){
            response = (LoginResponse)buildAbstractResponse(response, ResultCodeEnum.USER_NULL_ERROR);
            return response;
        }

        //去掉P_
        String password = userDTO.getPassword().split("_")[1];

        String loginPassword = PasswordUtil.getPassword(request.getPassword());

        if(!password.equals(loginPassword)){
            response = (LoginResponse)buildAbstractResponse(response, ResultCodeEnum.USER_LOGIN_ERROR);
            return response;
        }

        response = (LoginResponse)buildAbstractResponse(response, ResultCodeEnum.SUCCESS);

        return response;
    }
}