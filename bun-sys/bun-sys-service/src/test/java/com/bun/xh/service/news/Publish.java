package com.bun.xh.service.news;

import com.bun.xh.enums.ResultCodeEnum;
import com.bun.xh.exception.BunServerException;
import com.bun.xh.exception.BunServiceException;
import com.bun.xh.vo.PublishNewsRequest;
import com.bun.xh.vo.PublishNewsResponse;
import com.bun.xh.vo.SubmitNewsRequest;
import com.bun.xh.vo.SubmitNewsResponse;
import org.junit.Assert;
import org.junit.Test;

public class Publish extends AbstractNews {
    @Test
    public void test() throws BunServerException, BunServiceException {
        String newsId = String.valueOf(System.currentTimeMillis());
        String userId = "测试人";
        SubmitNewsRequest submitNewsRequest = buildSubmitNewsRequest(userId,newsId);
        SubmitNewsResponse submitNewsResponse = newsFacade.submitNews(submitNewsRequest);

        PublishNewsRequest publishNewsRequest = buildPublishNewsRequest(userId,newsId);
        PublishNewsResponse publishNewsResponse = newsFacade.publishNews(publishNewsRequest);
        Assert.assertEquals(ResultCodeEnum.SUCCESS.getCode(),publishNewsResponse.getResultCode());
    }
}