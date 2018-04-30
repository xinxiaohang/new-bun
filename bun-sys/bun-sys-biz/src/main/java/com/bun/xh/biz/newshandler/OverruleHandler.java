package com.bun.xh.biz.newshandler;

import com.bun.xh.comm.enums.NewsStatusEnum;
import com.bun.xh.enums.ResultCodeEnum;
import com.bun.xh.repository.dto.NewsDTO;
import com.bun.xh.repository.dto.NewsLogDTO;
import com.bun.xh.vo.ApproveNewsResponse;
import com.bun.xh.vo.OverruleNewsRequest;
import com.bun.xh.vo.OverruleNewsResponse;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OverruleHandler extends AbstractNewsHandler{

    public OverruleNewsResponse overruleNews(OverruleNewsRequest request){
        OverruleNewsResponse response = new OverruleNewsResponse();
        List<NewsDTO> newsDTOs = selectNewsByNewsIds(request.getNewsIds());
        if(CollectionUtils.isEmpty(newsDTOs)){
            response = (OverruleNewsResponse)buildAbstractResponse(response, ResultCodeEnum.NEWS_LIST_NULL_ERROR);
            return response;
        }

        List<NewsLogDTO> newsLogDTOs = new ArrayList<NewsLogDTO>();
        List<NewsDTO> changeNews = new ArrayList<NewsDTO>();
        for(NewsDTO newsDTO : newsDTOs ){
            newsDTO.setNewsStatus(NewsStatusEnum.OVERRULE.getStatus());

            NewsLogDTO newsLogDTO = new NewsLogDTO();
            newsLogDTO.setNewsId(newsDTO.getNewsId());
            newsLogDTO.setFromStatus(NewsStatusEnum.PUBLISH.getStatus());
            newsLogDTO.setToStatus(NewsStatusEnum.OVERRULE.getStatus());
            newsLogDTO.setOptTime(new Date());
            newsLogDTO.setCheckUserId(request.getCheckedUserId());
            newsLogDTO.setCheckUserName(request.getCheckedUserName());
            newsLogDTO.setOverruleReason(request.getOverruleReason());
            newsLogDTO.setVersion(0);
            newsLogDTOs.add(newsLogDTO);
        }
        changeNews.addAll(newsDTOs);

        approveChange(newsDTOs,newsLogDTOs);

        response = (OverruleNewsResponse)buildAbstractResponse(response,ResultCodeEnum.SUCCESS);
        return response;
    }
}