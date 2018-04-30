package com.bun.xh.biz.commenthandler;

import com.bun.xh.enums.ResultCodeEnum;
import com.bun.xh.repository.dto.CommentDTO;
import com.bun.xh.vo.SupportCommentResponse;
import com.bun.xh.vo.TreadCommentRequest;
import com.bun.xh.vo.TreadCommentResponse;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class TreadCommentHandler extends AbstractCommentHandler {

    public TreadCommentResponse treadComment(TreadCommentRequest request){
        TreadCommentResponse response = new TreadCommentResponse();

        CommentDTO commentDTO = selectCommByCommId(request.getCommentId());

        if(StringUtils.isEmpty(commentDTO)){
            response = (TreadCommentResponse) buildAbstractResponse(response, ResultCodeEnum.COMMENT_NULL_ERROR);
            return response;
        }

        Integer supportTreadTime = commentDTO.getCommTreadTime();

        commentDTO.setCommTreadTime(supportTreadTime+1);

        updateCommByCommId(commentDTO);

        response = (TreadCommentResponse) buildAbstractResponse(response, ResultCodeEnum.SUCCESS);

        return response;
    }

}