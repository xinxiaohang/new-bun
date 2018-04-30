package com.bun.xh.service.news;

import com.bun.xh.enums.ResultCodeEnum;
import com.bun.xh.exception.BunServerException;
import com.bun.xh.exception.BunServiceException;
import com.bun.xh.vo.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Report extends AbstractNews{
    @Test
    public void test() throws BunServerException, BunServiceException {
        String newsId = String.valueOf(System.currentTimeMillis());
        String userId = "测试人";
        SubmitNewsRequest submitNewsRequest = buildSubmitNewsRequest(userId,newsId);
        SubmitNewsResponse submitNewsResponse = newsFacade.submitNews(submitNewsRequest);

        PublishNewsRequest publishNewsRequest = buildPublishNewsRequest(userId,newsId);
        PublishNewsResponse publishNewsResponse = newsFacade.publishNews(publishNewsRequest);

        List<String> newsIds = new ArrayList<String>();
        newsIds.add(newsId);
        ApproveNewsRequest approveNewsRequest = buildApproveRequest(newsIds);
        ApproveNewsResponse approveNewsResponse = newsFacade.approveNews(approveNewsRequest);

        ReportNewsRequest reportNewsRequest = buildReportNewsRequest(newsId);
        ReportNewsResponse reportNewsResponse = newsFacade.reportNews(reportNewsRequest);
        Assert.assertEquals(ResultCodeEnum.SUCCESS.getCode(),reportNewsResponse.getResultCode());
    }
}