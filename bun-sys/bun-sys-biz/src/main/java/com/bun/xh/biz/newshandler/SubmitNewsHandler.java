package com.bun.xh.biz.newshandler;

import com.bun.xh.comm.enums.NewsStatusEnum;
import com.bun.xh.enums.ResultCodeEnum;
import com.bun.xh.repository.dto.NewsDTO;
import com.bun.xh.repository.dto.NewsLogDTO;
import com.bun.xh.vo.SubmitNewsRequest;
import com.bun.xh.vo.SubmitNewsResponse;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;

@Service
public class SubmitNewsHandler extends AbstractNewsHandler{

    public SubmitNewsResponse submitNews(SubmitNewsRequest request){
        SubmitNewsResponse response = new SubmitNewsResponse();

        //幂等
        NewsDTO newsDTO = selectNewsByNewsId(request.getNewsId());

        if(!StringUtils.isEmpty(newsDTO)){
            if(0 == NewsStatusEnum.SUBMIT.getStatus().compareTo(newsDTO.getNewsStatus())){
                response = (SubmitNewsResponse)buildAbstractResponse(
                        response,ResultCodeEnum.NEWS_STATUS_ERROR);
                return response;
            }
            response = (SubmitNewsResponse)buildAbstractResponse(
                    response,ResultCodeEnum.SUCCESS);
            return response;
        }

        //构造结构体,提交新闻
        NewsLogDTO newsLogDTO = null;
        summitCons(request);

        response = (SubmitNewsResponse)buildAbstractResponse(
                response,ResultCodeEnum.SUCCESS);
        return response;
    }

    //构造结构体
    private void summitCons(SubmitNewsRequest request){
        NewsDTO newsDTO = new NewsDTO();
        newsDTO.setNewsId(request.getNewsId());
        newsDTO.setNewsTitle(request.getNewTitle());
        newsDTO.setNewDesc(request.getNewDesc());
        newsDTO.setNewsPic(request.getNewsPic());
        newsDTO.setNewsType(request.getNewsType());
        newsDTO.setNewsStatus(NewsStatusEnum.SUBMIT.getStatus());
        newsDTO.setUserId(request.getUserId());
        newsDTO.setNewsReportTime(0);
        newsDTO.setNewsTreadTime(0);
        newsDTO.setNewsSupportTime(0);
        newsDTO.setVersion(0);

        NewsLogDTO newsLogDTO = new NewsLogDTO();
        newsLogDTO.setNewsId(request.getNewsId());
        newsLogDTO.setFromStatus(NewsStatusEnum.SUBMIT.getStatus());
        newsLogDTO.setToStatus(NewsStatusEnum.SUBMIT.getStatus());
        newsLogDTO.setOptTime(new Date());
        newsLogDTO.setCheckUserId(null);
        newsLogDTO.setCheckUserName(null);
        newsLogDTO.setOverruleReason(null);
        newsLogDTO.setVersion(0);

        summitChange(newsDTO,newsLogDTO);
    };
}