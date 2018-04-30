package com.bun.xh.biz.newshandler;

import com.alibaba.fastjson.JSON;
import com.bun.xh.comm.enums.NewsStatusEnum;
import com.bun.xh.enums.ResultCodeEnum;
import com.bun.xh.repository.dto.NewsDTO;
import com.bun.xh.vo.ReportNewsRequest;
import com.bun.xh.vo.ReportNewsResponse;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportNewsHandler extends AbstractNewsHandler{

    public ReportNewsResponse reportNews(ReportNewsRequest request){
        ReportNewsResponse response = new ReportNewsResponse();

        NewsDTO newsDTO = selectNewsByNewsId(request.getNewsId());

        if(StringUtils.isEmpty(newsDTO)){
            response = (ReportNewsResponse)buildAbstractResponse(response, ResultCodeEnum.NEWS_NULL_ERROR);
            return response;
        }

        if(NewsStatusEnum.APPROVE.getStatus() != newsDTO.getNewsStatus()){
            response = (ReportNewsResponse)buildAbstractResponse(response, ResultCodeEnum.NEWS_STATUS_ERROR);
            return response;
        }

        Integer newsReportTime = newsDTO.getNewsReportTime();

        String newsReportReason = newsDTO.getNewsReportReason();

        if(StringUtils.isEmpty(newsReportReason)){
            Map map = new HashMap();
            map.put(request.getReportUserId(),request.getReportReason());
            newsReportReason = JSON.toJSONString(map);

        }else {
            Map map = JSON.parseObject(newsReportReason);
            map.put(request.getReportUserId(),request.getReportReason());
            newsReportReason = JSON.toJSONString(map);
        }

        newsDTO.setNewsTreadTime(newsReportTime+1);
        newsDTO.setNewsReportReason(newsReportReason);

        updateByNewsId(newsDTO);

        response = (ReportNewsResponse) buildAbstractResponse(response,ResultCodeEnum.SUCCESS);

        return response;
    }

}