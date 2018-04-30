package com.bun.xh.repository.db.dao;

import com.bun.xh.repository.db.model.Comment;
import org.apache.ibatis.annotations.Param;

public interface CommentMapper {

    int insert(Comment record);

    int deleteCommByCommId(@Param("commentId") String commentId);

    int updateCommByCommentId(Comment comment);

    Comment selectCommByCommId(@Param("commentId") String commentId);

    Comment selectCommByUserIdAndCommId(@Param("userId") String userId,
                                        @Param("commentId") String commentId);
}