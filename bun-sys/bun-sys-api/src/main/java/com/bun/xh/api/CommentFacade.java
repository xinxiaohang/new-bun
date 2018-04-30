package com.bun.xh.api;

import com.bun.xh.exception.BunServerException;
import com.bun.xh.exception.BunServiceException;
import com.bun.xh.vo.ReportCommentRequest;
import com.bun.xh.vo.ReportCommentResponse;
import com.bun.xh.vo.SupportCommentRequest;
import com.bun.xh.vo.SupportCommentResponse;
import com.bun.xh.vo.TreadCommentRequest;
import com.bun.xh.vo.TreadCommentResponse;
import com.bun.xh.vo.UserDeleteCommentRequest;
import com.bun.xh.vo.UserDeleteCommentResponse;
import com.bun.xh.vo.SubmitCommentResponse;
import com.bun.xh.vo.SubmitCommentRequest;

/**
 * Created by xin on 2018/4/6.
 */
public interface CommentFacade {

    SubmitCommentResponse submitComment(SubmitCommentRequest request) throws BunServerException,BunServiceException;

    UserDeleteCommentResponse userDeleteComment(UserDeleteCommentRequest request) throws BunServerException,BunServiceException;

    SupportCommentResponse supportComment(SupportCommentRequest request) throws BunServerException,BunServiceException;

    TreadCommentResponse treadComment(TreadCommentRequest request) throws BunServerException,BunServiceException;

    ReportCommentResponse reportComment(ReportCommentRequest request)throws BunServerException,BunServiceException;
}
