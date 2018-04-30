package com.bun.xh.biz.newshandler;

import com.bun.xh.comm.enums.NewsStatusEnum;
import com.bun.xh.enums.ResultCodeEnum;
import com.bun.xh.repository.db.model.News;
import com.bun.xh.repository.dto.NewsDTO;
import com.bun.xh.repository.dto.NewsLogDTO;
import com.bun.xh.vo.PublishNewsRequest;
import com.bun.xh.vo.PublishNewsResponse;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;

@Service
public class PublishNewsHandler extends AbstractNewsHandler{

    public PublishNewsResponse publishNews(PublishNewsRequest request){
        PublishNewsResponse response = new PublishNewsResponse();

        NewsDTO newsDTO = selectNewsByUserIdAndNewId(request.getUserId(),
                                                     request.getNewsId());
        //判断是否为空
        if(StringUtils.isEmpty(newsDTO)){
            response = (PublishNewsResponse)buildAbstractResponse(
                    response,ResultCodeEnum.NEWS_NULL_ERROR);
            return response;
        }

        if(NewsStatusEnum.SUBMIT.getStatus() != newsDTO.getNewsStatus()){
            response = (PublishNewsResponse)buildAbstractResponse(
                    response,ResultCodeEnum.NEWS_STATUS_ERROR);
            return response;
        }

        //构造结构体，数据库修改和插入
        NewsLogDTO newsLogDTO = null;
        publishCons(newsDTO,newsLogDTO);

        response = (PublishNewsResponse)buildAbstractResponse(
                response,ResultCodeEnum.SUCCESS);
        return response;
    }

    private void publishCons(NewsDTO newsDTO,NewsLogDTO newsLogDTO){

        newsDTO.setNewsStatus(NewsStatusEnum.PUBLISH.getStatus());

        newsLogDTO = new NewsLogDTO();
        newsLogDTO.setNewsId(newsDTO.getNewsId());
        newsLogDTO.setFromStatus(NewsStatusEnum.SUBMIT.getStatus());
        newsLogDTO.setToStatus(NewsStatusEnum.PUBLISH.getStatus());
        newsLogDTO.setOptTime(new Date());
        newsLogDTO.setCheckUserId(null);
        newsLogDTO.setCheckUserName(null);
        newsLogDTO.setOverruleReason(null);
        newsLogDTO.setVersion(0);

        publishChange(newsDTO,newsLogDTO);
    }
}