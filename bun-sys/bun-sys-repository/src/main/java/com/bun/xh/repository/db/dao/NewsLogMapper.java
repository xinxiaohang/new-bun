package com.bun.xh.repository.db.dao;

import com.bun.xh.repository.db.model.NewsLog;

public interface NewsLogMapper {
    int deleteByPrimaryKey(Long id);

    int insert(NewsLog record);

    int insertSelective(NewsLog record);

    NewsLog selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(NewsLog record);

    int updateByPrimaryKey(NewsLog record);
}