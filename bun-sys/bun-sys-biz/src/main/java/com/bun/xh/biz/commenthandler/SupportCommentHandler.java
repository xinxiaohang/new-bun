package com.bun.xh.biz.commenthandler;

import com.bun.xh.enums.ResultCodeEnum;
import com.bun.xh.repository.dto.CommentDTO;
import com.bun.xh.vo.SupportCommentRequest;
import com.bun.xh.vo.SupportCommentResponse;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class SupportCommentHandler  extends AbstractCommentHandler{

    public SupportCommentResponse supportComment(SupportCommentRequest request){
        SupportCommentResponse response = new SupportCommentResponse();

        CommentDTO commentDTO = selectCommByCommId(request.getCommentId());

        if(StringUtils.isEmpty(commentDTO)){
            response = (SupportCommentResponse) buildAbstractResponse(response, ResultCodeEnum.COMMENT_NULL_ERROR);
            return response;
        }

        Integer supportCommentTime = commentDTO.getCommSupportTime();

        commentDTO.setCommSupportTime(supportCommentTime+1);

        updateCommByCommId(commentDTO);

        response = (SupportCommentResponse) buildAbstractResponse(response, ResultCodeEnum.SUCCESS);

        return response;
    }
}