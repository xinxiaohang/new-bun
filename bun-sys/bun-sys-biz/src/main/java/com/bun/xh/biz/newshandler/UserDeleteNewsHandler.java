package com.bun.xh.biz.newshandler;

import com.bun.xh.comm.enums.NewsStatusEnum;
import com.bun.xh.enums.ResultCodeEnum;
import com.bun.xh.repository.dto.NewsDTO;
import com.bun.xh.vo.UserDeleteNewsRequest;
import com.bun.xh.vo.UserDeleteNewsResponse;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class UserDeleteNewsHandler extends AbstractNewsHandler{

    public UserDeleteNewsResponse userDeleteNews(UserDeleteNewsRequest request){
        UserDeleteNewsResponse response = new UserDeleteNewsResponse();

        NewsDTO newsDTO = selectNewsByUserIdAndNewId(request.getUserId(),request.getNewsId());

        if(StringUtils.isEmpty(newsDTO)){
            response = (UserDeleteNewsResponse) buildAbstractResponse(response, ResultCodeEnum.NEWS_NULL_ERROR);
            return response;
        }

        if(NewsStatusEnum.SUBMIT.getStatus() != newsDTO.getNewsStatus() ){
            response = (UserDeleteNewsResponse) buildAbstractResponse(response, ResultCodeEnum.NEWS_STATUS_ERROR);
            return response;
        }

        newsDTO.setNewsStatus(NewsStatusEnum.DELETE.getStatus());

        updateByNewsId(newsDTO);

        response = (UserDeleteNewsResponse) buildAbstractResponse(response, ResultCodeEnum.SUCCESS);

        return response;
    }
}