package com.bun.xh.biz.userhandler;

import com.bun.xh.biz.AbstractHandler;
import com.bun.xh.repository.db.service.UserService;
import com.bun.xh.repository.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;

public class AbstractUserHandler extends AbstractHandler{

    @Autowired
    private UserService userService;

    protected UserDTO selectUserByUserId(String userId){
        UserDTO userDTO = userService.selectUserByUserId(userId);
        return userDTO;
    }

    protected void insert(UserDTO userDTO){
        userService.insert(userDTO);
    }

    protected void changeUserStatus(UserDTO userDTO){
        userService.updateByUserId(userDTO);
    }
}