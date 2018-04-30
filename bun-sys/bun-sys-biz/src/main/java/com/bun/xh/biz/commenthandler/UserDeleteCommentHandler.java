package com.bun.xh.biz.commenthandler;

import com.bun.xh.enums.ResultCodeEnum;
import com.bun.xh.repository.dto.CommentDTO;
import com.bun.xh.vo.UserDeleteCommentRequest;
import com.bun.xh.vo.UserDeleteCommentResponse;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class UserDeleteCommentHandler extends AbstractCommentHandler {

    public UserDeleteCommentResponse userDeleteComment(UserDeleteCommentRequest request){
        UserDeleteCommentResponse response = new UserDeleteCommentResponse();

        CommentDTO commentDTO = selectCommByUserIdAndCommId(request.getUserId(),request.getCommentId());

        if(StringUtils.isEmpty(commentDTO)){
            response = (UserDeleteCommentResponse) buildAbstractResponse(response, ResultCodeEnum.COMMENT_NULL_ERROR);
            return response;
        }

        String commentId = commentDTO.getCommentId();

        deleteCommByCommId(commentId);

        response = (UserDeleteCommentResponse) buildAbstractResponse(response, ResultCodeEnum.SUCCESS);
        return response;
    }
}