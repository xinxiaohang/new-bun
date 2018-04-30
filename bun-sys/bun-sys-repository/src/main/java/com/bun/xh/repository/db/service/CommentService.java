package com.bun.xh.repository.db.service;

import com.bun.xh.repository.db.dao.CommentMapper;
import com.bun.xh.repository.db.model.Comment;
import com.bun.xh.repository.dto.CommentDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * Created by xin on 2018/4/7.
 */
@Service
public class CommentService {

    @Autowired
    private CommentMapper commentMapper;

    public void insert(CommentDTO commentDTO){
        if(StringUtils.isEmpty(commentDTO)){
            return;
        }
        Comment comment = new Comment();
        BeanUtils.copyProperties(commentDTO,comment);
        commentMapper.insert(comment);
    }

    public CommentDTO selectCommByCommId(String commentId){
        Comment comment = commentMapper.selectCommByCommId(commentId);
        if(StringUtils.isEmpty(comment)){
            return null;
        }
        CommentDTO commentDTO = new CommentDTO();
        BeanUtils.copyProperties(comment,commentDTO);
        return commentDTO;
    }

    public CommentDTO selectCommByUserIdAndCommId(String userId,String commentId){
        Comment comment = commentMapper.selectCommByUserIdAndCommId(userId,commentId);
        if(StringUtils.isEmpty(comment)){
            return null;
        }
        CommentDTO commentDTO = new CommentDTO();
        BeanUtils.copyProperties(comment,commentDTO);
        return commentDTO;
    }

    public void deleteCommByCommId(String commentId){
        commentMapper.deleteCommByCommId(commentId);
    }

    public void updeteCommByCommId(CommentDTO commentDTO){
        if(StringUtils.isEmpty(commentDTO)){
            return;
        }
        Comment comment = new Comment();
        BeanUtils.copyProperties(commentDTO,comment);
        commentMapper.updateCommByCommentId(comment);
    }
}
