package com.bun.xh.service.news;

import com.bun.xh.enums.ResultCodeEnum;
import com.bun.xh.exception.BunServerException;
import com.bun.xh.exception.BunServiceException;
import com.bun.xh.vo.ApproveNewsRequest;
import com.bun.xh.vo.ApproveNewsResponse;
import com.bun.xh.vo.PublishNewsRequest;
import com.bun.xh.vo.PublishNewsResponse;
import com.bun.xh.vo.SubmitNewsRequest;
import com.bun.xh.vo.SubmitNewsResponse;
import com.bun.xh.vo.SupportNewsRequest;
import com.bun.xh.vo.SupportNewsResponse;
import com.bun.xh.vo.TreadNewsRequest;
import com.bun.xh.vo.TreadNewsResponse;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Tread extends AbstractNews {

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

        TreadNewsRequest treadNewsRequest = buildTreadNewsRequest(newsId);
        TreadNewsResponse treadNewsResponse = newsFacade.treadNews(treadNewsRequest);
        Assert.assertEquals(ResultCodeEnum.SUCCESS.getCode(),treadNewsResponse.getResultCode());
    }
}