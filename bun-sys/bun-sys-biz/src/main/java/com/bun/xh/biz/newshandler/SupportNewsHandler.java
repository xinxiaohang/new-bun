package com.bun.xh.biz.newshandler;

import com.bun.xh.comm.enums.NewsStatusEnum;
import com.bun.xh.enums.ResultCodeEnum;
import com.bun.xh.repository.dto.NewsDTO;
import com.bun.xh.vo.SupportNewsRequest;
import com.bun.xh.vo.SupportNewsResponse;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class SupportNewsHandler extends AbstractNewsHandler{

    public SupportNewsResponse supportNews(SupportNewsRequest request){
        SupportNewsResponse response = new SupportNewsResponse();

        NewsDTO newsDTO = selectNewsByNewsId(request.getNewsId());

        if(StringUtils.isEmpty(newsDTO)){
            response = (SupportNewsResponse)buildAbstractResponse(response, ResultCodeEnum.NEWS_NULL_ERROR);
            return response;
        }

        if(NewsStatusEnum.APPROVE.getStatus() != newsDTO.getNewsStatus()){
            response = (SupportNewsResponse)buildAbstractResponse(response, ResultCodeEnum.NEWS_STATUS_ERROR);
            return response;
        }

        Integer newsSupportTime = newsDTO.getNewsSupportTime();

        newsDTO.setNewsSupportTime(newsSupportTime+1);

        updateByNewsId(newsDTO);

        response = (SupportNewsResponse)buildAbstractResponse(response, ResultCodeEnum.SUCCESS);

        return response;
    }
}