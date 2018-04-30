package com.bun.xh.biz.newshandler;

import com.bun.xh.comm.enums.NewsStatusEnum;
import com.bun.xh.enums.ResultCodeEnum;
import com.bun.xh.repository.dto.NewsDTO;
import com.bun.xh.vo.TreadNewsRequest;
import com.bun.xh.vo.TreadNewsResponse;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class TreadNewsHandler extends AbstractNewsHandler {

    public TreadNewsResponse treadNews(TreadNewsRequest request){
        TreadNewsResponse response = new TreadNewsResponse();

        NewsDTO newsDTO = selectNewsByNewsId(request.getNewsId());

        if(StringUtils.isEmpty(newsDTO)){
            response = (TreadNewsResponse)buildAbstractResponse(response, ResultCodeEnum.NEWS_NULL_ERROR);
            return response;
        }

        if(NewsStatusEnum.APPROVE.getStatus() != newsDTO.getNewsStatus()){
            response = (TreadNewsResponse)buildAbstractResponse(response, ResultCodeEnum.NEWS_STATUS_ERROR);
            return response;
        }

        Integer newsTreadTime = newsDTO.getNewsTreadTime();

        newsDTO.setNewsSupportTime(newsTreadTime+1);

        updateByNewsId(newsDTO);

        response = (TreadNewsResponse)buildAbstractResponse(response, ResultCodeEnum.SUCCESS);

        return response;
    }
}