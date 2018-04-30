package com.bun.xh.biz.commenthandler;

import com.bun.xh.enums.ResultCodeEnum;
import com.bun.xh.repository.dto.CommentDTO;
import com.bun.xh.vo.SubmitCommentRequest;
import com.bun.xh.vo.SubmitCommentResponse;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;

@Service
public class SubmitCommentHandler extends AbstractCommentHandler {

    public SubmitCommentResponse submitComment(SubmitCommentRequest request){
        SubmitCommentResponse response = new SubmitCommentResponse();

        CommentDTO commentDTO = selectCommByCommId(request.getCommentId());

        if(!StringUtils.isEmpty(commentDTO)){
            response = (SubmitCommentResponse) buildAbstractResponse(response, ResultCodeEnum.SUCCESS);
        }

        insert(request);

        response = (SubmitCommentResponse) buildAbstractResponse(response, ResultCodeEnum.SUCCESS);

        return response;
    }

    private void insert(SubmitCommentRequest request){
        CommentDTO commentDTO = new CommentDTO();

        commentDTO.setNewsId(request.getNewsId());
        commentDTO.setUserId(request.getUserId());
        commentDTO.setCommentId(request.getCommentId());
        commentDTO.setUserName(request.getUserName());
        commentDTO.setCommentDesc(request.getCommentDesc());
        commentDTO.setCommentTime(new Date());
        commentDTO.setRespCommentId(request.getRespCommentId());
        commentDTO.setCommReportTime(0);
        commentDTO.setCommSupportTime(0);
        commentDTO.setCommTreadTime(0);
        String respComment = request.getRespCommentId();
        if(StringUtils.isEmpty(respComment)){
            commentDTO.setRespCommentId("0");
        }else {
            commentDTO.setRespCommentId(respComment);
        }
        commentDTO.setVersion(0);
        insertComm(commentDTO);
    }
}