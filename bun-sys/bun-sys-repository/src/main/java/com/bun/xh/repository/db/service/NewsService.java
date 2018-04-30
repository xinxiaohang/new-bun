package com.bun.xh.repository.db.service;

import com.bun.xh.repository.db.dao.NewsMapper;
import com.bun.xh.repository.db.model.News;
import com.bun.xh.repository.db.model.NewsLog;
import com.bun.xh.repository.dto.NewsDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xin on 2018/4/7.
 */
@Service
public class NewsService {

    @Autowired
    private NewsMapper newsMapper;

    public void insert(NewsDTO newsDTO){
        News news = new News();
        BeanUtils.copyProperties(newsDTO,news);
        newsMapper.insert(news);
    }

    public void deleteNewsByNewsId(String newsId){
        newsMapper.deleteNewsByNewsId(newsId);
    }

    public void updateByNewsId(NewsDTO newsDTO){
        News news = new News();
        BeanUtils.copyProperties(newsDTO,news);
        newsMapper.updateByNewsId(news);
    }

    public void updateByNewsIds(List<NewsDTO> newsDTOs){
        if(CollectionUtils.isEmpty(newsDTOs)){
            return;
        }
        for(NewsDTO newsDTO : newsDTOs){
            News news = new News();
            BeanUtils.copyProperties(newsDTO,news);
            newsMapper.updateByNewsId(news);
        }
    }

    public NewsDTO selectNewsByNewsId(String newsId){
        News news = newsMapper.selectNewsByNewsId(newsId);
        if(null == news){
            return null;
        }
        NewsDTO newsDTO = new NewsDTO();
        BeanUtils.copyProperties(news,newsDTO);
        return newsDTO;
    }

    public NewsDTO selectNewsByUserIdAndNewId(String userId,String newsId){
        News news = newsMapper.selectNewsByUserIdAndNewId(userId,newsId);
        if(null == news){
            return null;
        }
        NewsDTO newsDTO = new NewsDTO();
        BeanUtils.copyProperties(news,newsDTO);
        return newsDTO;
    }

    public List<NewsDTO> selectNewsByNewsIds(List<String> newsIds){
        List<NewsDTO> newsDTOs = new ArrayList<NewsDTO>();
        List<News> newses = newsMapper.selectNewsByNewsIds(newsIds);

        if(CollectionUtils.isEmpty(newses)){
            return null;
        }
        for (News news : newses){
            NewsDTO newsDTO = new NewsDTO();
            BeanUtils.copyProperties(news,newsDTO);
            newsDTOs.add(newsDTO);
        }
        return newsDTOs;
    }
}
