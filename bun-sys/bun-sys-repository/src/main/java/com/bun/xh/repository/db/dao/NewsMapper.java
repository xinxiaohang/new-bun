package com.bun.xh.repository.db.dao;

import com.bun.xh.repository.db.model.News;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NewsMapper {

    int insert(News record);

    int deleteNewsByNewsId(@Param("newsId") String newsId);

    int updateByNewsId(News record);

    News selectNewsByNewsId(@Param("newsId") String newsId);

    News selectNewsByUserIdAndNewId(@Param("userId") String userId,
                                    @Param("newsId") String newsId);

    List<News> selectNewsByNewsIds(@Param("newsIds")List<String> newsIds);
}