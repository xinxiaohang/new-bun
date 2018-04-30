package com.bun.xh.repository.db.service;

import com.bun.xh.repository.db.dao.UserMapper;
import com.bun.xh.repository.db.model.User;
import com.bun.xh.repository.dto.UserDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * Created by xin on 2018/4/7.
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public UserDTO selectUserByUserId(String userId){
        User user = userMapper.selectUserByUserId(userId);
        if(StringUtils.isEmpty(user)){
            return null;
        }
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(user,userDTO);
        return userDTO;
    }

    public void insert(UserDTO userDTO){
        if(StringUtils.isEmpty(userDTO)){
            return;
        }
        User user = new User();

        BeanUtils.copyProperties(userDTO,user);

        userMapper.insert(user);
    }

    public void updateByUserId (UserDTO userDTO){
        if(StringUtils.isEmpty(userDTO)){
            return;
        }

        User user = new User();
        BeanUtils.copyProperties(userDTO,user);
        userMapper.updateByUserId(user);
    }
}
