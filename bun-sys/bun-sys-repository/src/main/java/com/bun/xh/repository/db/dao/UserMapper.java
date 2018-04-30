package com.bun.xh.repository.db.dao;

import com.bun.xh.repository.db.model.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

    int insert(User record);

    int updateByUserId(User record);

    User selectUserByUserId(@Param("userId") String userId);
}