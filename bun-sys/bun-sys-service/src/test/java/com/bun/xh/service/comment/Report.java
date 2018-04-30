package com.bun.xh.service.comment;

import com.bun.xh.enums.ResultCodeEnum;
import com.bun.xh.exception.BunServerException;
import com.bun.xh.exception.BunServiceException;
import com.bun.xh.vo.ApproveNewsRequest;
import com.bun.xh.vo.ApproveNewsResponse;
import com.bun.xh.vo.PublishNewsRequest;
import com.bun.xh.vo.PublishNewsResponse;
import com.bun.xh.vo.ReportCommentRequest;
import com.bun.xh.vo.ReportCommentResponse;
import com.bun.xh.vo.SubmitCommentRequest;
import com.bun.xh.vo.SubmitCommentResponse;
import com.bun.xh.vo.SubmitNewsRequest;
import com.bun.xh.vo.SubmitNewsResponse;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Report extends AbstractComment {

    @Test
    public void test() throws BunServerException, BunServiceException {
        String newsId = String.valueOf(System.currentTimeMillis());
        String commentId = String.valueOf(System.currentTimeMillis());

        String userId = "测试人";
        SubmitNewsRequest submitNewsRequest = buildSubmitNewsRequest(userId,newsId);
        SubmitNewsResponse submitNewsResponse = newsFacade.submitNews(submitNewsRequest);

        PublishNewsRequest publishNewsRequest = buildPublishNewsRequest(userId,newsId);
        PublishNewsResponse publishNewsResponse = newsFacade.publishNews(publishNewsRequest);

        List<String> newsIds = new ArrayList<String>();
        newsIds.add(newsId);
        ApproveNewsRequest approveNewsRequest = buildApproveRequest(newsIds);
        ApproveNewsResponse approveNewsResponse = newsFacade.approveNews(approveNewsRequest);

        SubmitCommentRequest submitCommentRequest = buildSubmitCommentRequest(userId,commentId,newsId);
        SubmitCommentResponse commentResponse = commentFacade.submitComment(submitCommentRequest);

        ReportCommentRequest reportCommentRequest = buildReportCommentRequest(commentId);
        ReportCommentResponse reportCommentResponse = commentFacade.reportComment(reportCommentRequest);
        Assert.assertEquals(ResultCodeEnum.SUCCESS.getCode(),reportCommentResponse.getResultCode());
    }
}