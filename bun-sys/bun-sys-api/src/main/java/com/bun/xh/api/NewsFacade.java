package com.bun.xh.api;

import com.bun.xh.exception.BunServerException;
import com.bun.xh.exception.BunServiceException;
import com.bun.xh.vo.ApproveNewsRequest;
import com.bun.xh.vo.ApproveNewsResponse;
import com.bun.xh.vo.OverruleNewsRequest;
import com.bun.xh.vo.OverruleNewsResponse;
import com.bun.xh.vo.PublishNewsRequest;
import com.bun.xh.vo.PublishNewsResponse;
import com.bun.xh.vo.ReportNewsRequest;
import com.bun.xh.vo.ReportNewsResponse;
import com.bun.xh.vo.SubmitNewsRequest;
import com.bun.xh.vo.SubmitNewsResponse;
import com.bun.xh.vo.SupportNewsRequest;
import com.bun.xh.vo.SupportNewsResponse;
import com.bun.xh.vo.TreadNewsRequest;
import com.bun.xh.vo.TreadNewsResponse;
import com.bun.xh.vo.UserDeleteNewsRequest;
import com.bun.xh.vo.UserDeleteNewsResponse;

/**
 * Created by xin on 2018/4/7.
 */
public interface NewsFacade {

    SubmitNewsResponse submitNews(SubmitNewsRequest request) throws BunServerException,BunServiceException;

    PublishNewsResponse publishNews(PublishNewsRequest request)throws BunServerException,BunServiceException;

    ApproveNewsResponse approveNews(ApproveNewsRequest request)throws BunServerException,BunServiceException;

    OverruleNewsResponse overruleNews(OverruleNewsRequest request)throws BunServerException,BunServiceException;

    SupportNewsResponse supportNews(SupportNewsRequest request) throws BunServerException,BunServiceException;

    TreadNewsResponse treadNews(TreadNewsRequest request) throws BunServerException,BunServiceException;

    ReportNewsResponse reportNews(ReportNewsRequest request)throws BunServerException,BunServiceException;

    UserDeleteNewsResponse userDeleteNews(UserDeleteNewsRequest request)throws BunServerException,BunServiceException;
}
