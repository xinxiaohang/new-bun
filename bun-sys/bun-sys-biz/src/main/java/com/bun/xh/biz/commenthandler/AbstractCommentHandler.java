package com.bun.xh.biz.commenthandler;

import com.bun.xh.biz.AbstractHandler;
import com.bun.xh.repository.db.dao.CommentMapper;
import com.bun.xh.repository.db.service.CommentService;
import com.bun.xh.repository.dto.CommentDTO;
import org.springframework.beans.factory.annotation.Autowired;

public class AbstractCommentHandler extends AbstractHandler{

    @Autowired
    private CommentService commentService;

    protected CommentDTO selectCommByCommId(String commentId){
        return commentService.selectCommByCommId(commentId);
    }

    protected void insertComm(CommentDTO commentDTO){
        commentService.insert(commentDTO);
    }

    protected CommentDTO selectCommByUserIdAndCommId(String userId,String commentId){
        return commentService.selectCommByUserIdAndCommId(userId,commentId);
    }

    protected void deleteCommByCommId(String commentId){
        commentService.deleteCommByCommId(commentId);
    }

    protected void updateCommByCommId(CommentDTO commentDTO){
        commentService.updeteCommByCommId(commentDTO);
    }
}