package com.bun.xh.biz.userhandler;

import com.bun.xh.comm.enums.UserStatusEnum;
import com.bun.xh.comm.tools.PasswordUtil;
import com.bun.xh.enums.ResultCodeEnum;
import com.bun.xh.repository.dto.UserDTO;
import com.bun.xh.vo.RegisterRequest;
import com.bun.xh.vo.RegisterResponse;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;

@Service
public class RegisterHandler extends AbstractUserHandler{

    public RegisterResponse register(RegisterRequest request){
        RegisterResponse response = new RegisterResponse();

        UserDTO userDTO = selectUserByUserId(request.getUserId());

        if(!StringUtils.isEmpty(userDTO)){
            response = (RegisterResponse)buildAbstractResponse(response, ResultCodeEnum.SUCCESS);
            return response;
        }

        UserDTO registerUserDTO = new UserDTO();
        registerUserDTO.setUserId(request.getUserId());
        registerUserDTO.setPassword("P_"+PasswordUtil.getPassword(request.getPassword()));
        registerUserDTO.setRegistTime(new Date());
        registerUserDTO.setUserName(request.getUserName());
        registerUserDTO.setUserPic(request.getUserPic());
        registerUserDTO.setUserStatus(UserStatusEnum.NEWS_USER.getStatus());
        registerUserDTO.setVersion(0);

        insert(registerUserDTO);

        response = (RegisterResponse)buildAbstractResponse(response, ResultCodeEnum.SUCCESS);

        return response;
    }
}