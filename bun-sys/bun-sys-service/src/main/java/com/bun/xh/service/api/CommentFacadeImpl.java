package com.bun.xh.service.api;

import com.alibaba.fastjson.JSON;
import com.bun.xh.api.CommentFacade;
import com.bun.xh.biz.commenthandler.ReportCommentHandler;
import com.bun.xh.biz.commenthandler.SubmitCommentHandler;
import com.bun.xh.biz.commenthandler.SupportCommentHandler;
import com.bun.xh.biz.commenthandler.TreadCommentHandler;
import com.bun.xh.biz.commenthandler.UserDeleteCommentHandler;
import com.bun.xh.exception.BunServerException;
import com.bun.xh.exception.BunServiceException;
import com.bun.xh.service.convert.ExceptionConvert;
import com.bun.xh.vo.ReportCommentRequest;
import com.bun.xh.vo.ReportCommentResponse;
import com.bun.xh.vo.SupportCommentRequest;
import com.bun.xh.vo.SupportCommentResponse;
import com.bun.xh.vo.TreadCommentRequest;
import com.bun.xh.vo.TreadCommentResponse;
import com.bun.xh.vo.UserDeleteCommentRequest;
import com.bun.xh.vo.UserDeleteCommentResponse;
import com.bun.xh.vo.SubmitCommentRequest;
import com.bun.xh.vo.SubmitCommentResponse;
import com.bun.xh.vo.SubmitNewsResponse;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by xin on 2018/4/7.
 */
@Service
public class CommentFacadeImpl implements CommentFacade {

    private static Logger LOG = Logger.getLogger(CommentFacadeImpl.class);

    @Autowired
    private SubmitCommentHandler submitCommentHandler;

    @Autowired
    private UserDeleteCommentHandler userDeleteCommentHandler;

    @Autowired
    private SupportCommentHandler supportCommentHandler;

    @Autowired
    private TreadCommentHandler treadCommentHandler;

    @Autowired
    private ReportCommentHandler reportCommentHandler;

    public SubmitCommentResponse submitComment(SubmitCommentRequest request) throws BunServiceException,BunServerException{
        SubmitCommentResponse response = new SubmitCommentResponse();
        try {
            LOG.info("提交评论开始|请求报文" + JSON.toJSONString(request));
            response = submitCommentHandler.submitComment(request);
            LOG.info("提交评论结束|返回报文" + JSON.toJSONString(response));
            ExceptionConvert.CreateException(response);
        }catch (Exception e){
            LOG.error("提交评论异常",e);
            ExceptionConvert.throwException(e);
        }
        return response;
    }

    public UserDeleteCommentResponse userDeleteComment(UserDeleteCommentRequest request) throws BunServerException,BunServiceException {
        UserDeleteCommentResponse response = new UserDeleteCommentResponse();
        try {
            LOG.info("删除评论开始|请求报文" + JSON.toJSONString(request));
            response = userDeleteCommentHandler.userDeleteComment(request);
            LOG.info("删除评论结束|返回报文" + JSON.toJSONString(response));
            ExceptionConvert.CreateException(response);
        }catch (Exception e){
            LOG.error("删除评论异常",e);
            ExceptionConvert.throwException(e);
        }
        return response;
    }

    public SupportCommentResponse supportComment(SupportCommentRequest request) throws BunServerException, BunServiceException {
        SupportCommentResponse response = new SupportCommentResponse();
        try {
            LOG.info("点赞评论开始|请求报文" + JSON.toJSONString(request));
            response = supportCommentHandler.supportComment(request);
            LOG.info("点赞评论结束|返回报文" + JSON.toJSONString(response));
            ExceptionConvert.CreateException(response);
        }catch (Exception e){
            LOG.error("点赞评论异常",e);
            ExceptionConvert.throwException(e);
        }
        return response;
    }

    public TreadCommentResponse treadComment(TreadCommentRequest request) throws BunServerException, BunServiceException {
        TreadCommentResponse response = new TreadCommentResponse();
        try {
            LOG.info("点踩评论开始|请求报文" + JSON.toJSONString(request));
            response = treadCommentHandler.treadComment(request);
            LOG.info("点踩评论结束|返回报文" + JSON.toJSONString(response));
            ExceptionConvert.CreateException(response);
        }catch (Exception e){
            LOG.error("点踩评论异常",e);
            ExceptionConvert.throwException(e);
        }
        return response;
    }

    public ReportCommentResponse reportComment(ReportCommentRequest request) throws BunServerException, BunServiceException {
        ReportCommentResponse response = new ReportCommentResponse();
        try {
            LOG.info("举报评论开始|请求报文" + JSON.toJSONString(request));
            response = reportCommentHandler.reportComment(request);
            LOG.info("举报评论结束|返回报文" + JSON.toJSONString(response));
            ExceptionConvert.CreateException(response);
        }catch (Exception e){
            LOG.error("举报评论异常",e);
            ExceptionConvert.throwException(e);
        }
        return response;
    }
}
