package com.bun.xh.biz.commenthandler;

import com.alibaba.fastjson.JSON;
import com.bun.xh.enums.ResultCodeEnum;
import com.bun.xh.repository.dto.CommentDTO;
import com.bun.xh.vo.ReportCommentRequest;
import com.bun.xh.vo.ReportCommentResponse;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

@Service
public class ReportCommentHandler extends AbstractCommentHandler{

    public ReportCommentResponse reportComment(ReportCommentRequest request){
        ReportCommentResponse response = new ReportCommentResponse();

        CommentDTO commentDTO = selectCommByCommId(request.getCommentId());

        if(StringUtils.isEmpty(commentDTO)){
            response = (ReportCommentResponse) buildAbstractResponse(response, ResultCodeEnum.COMMENT_NULL_ERROR);
            return response;
        }

        Integer commReportTime = commentDTO.getCommReportTime();

        String commReportReason = commentDTO.getCommReportReason();

        if(StringUtils.isEmpty(commReportReason)){
            Map map = new HashMap();
            map.put(request.getReportUserId(),request.getReportReason());
            commReportReason = JSON.toJSONString(map);

        }else {
            Map map = JSON.parseObject(commReportReason);
            map.put(request.getReportUserId(),request.getReportReason());
            commReportReason = JSON.toJSONString(map);
        }

        commentDTO.setCommReportTime(commReportTime+1);
        commentDTO.setCommReportReason(commReportReason);

        updateCommByCommId(commentDTO);

        response = (ReportCommentResponse) buildAbstractResponse(response,ResultCodeEnum.SUCCESS);

        return response;
    }
}