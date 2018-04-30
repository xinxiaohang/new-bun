package com.bun.xh.service.news;

import com.bun.xh.enums.ResultCodeEnum;
import com.bun.xh.exception.BunServerException;
import com.bun.xh.exception.BunServiceException;
import com.bun.xh.vo.SubmitNewsRequest;
import com.bun.xh.vo.SubmitNewsResponse;
import org.junit.Assert;
import org.junit.Test;

public class Submit extends AbstractNews {

    @Test
    public void test() throws BunServerException, BunServiceException {
        String newsId = String.valueOf(System.currentTimeMillis());
        String userId = "测试人";
        SubmitNewsRequest submitNewsRequest = buildSubmitNewsRequest(userId,newsId);
        SubmitNewsResponse response = newsFacade.submitNews(submitNewsRequest);
        Assert.assertEquals(ResultCodeEnum.SUCCESS.getCode(),response.getResultCode());
    }
}