package com.bun.xh.biz.userhandler;

import com.bun.xh.comm.enums.UserStatusEnum;
import com.bun.xh.enums.ResultCodeEnum;
import com.bun.xh.repository.dto.UserDTO;
import com.bun.xh.vo.BeCheckRequest;
import com.bun.xh.vo.BeCheckResponse;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class BeCheckHandler extends AbstractUserHandler {

    public BeCheckResponse beCheck(BeCheckRequest request){
        BeCheckResponse response = new BeCheckResponse();

        UserDTO userDTO = selectUserByUserId(request.getUserId());

        if(StringUtils.isEmpty(userDTO)){
            response = (BeCheckResponse) buildAbstractResponse(response, ResultCodeEnum.NEWS_NULL_ERROR);
        }

        userDTO.setUserStatus(UserStatusEnum.CHECK_USER.getStatus());

        changeUserStatus(userDTO);

        response = (BeCheckResponse) buildAbstractResponse(response,ResultCodeEnum.SUCCESS);

        return response;
    }
}