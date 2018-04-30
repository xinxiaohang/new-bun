package com.bun.xh.service.news;

import com.bun.xh.enums.ResultCodeEnum;
import com.bun.xh.exception.BunServerException;
import com.bun.xh.exception.BunServiceException;
import com.bun.xh.vo.SubmitNewsRequest;
import com.bun.xh.vo.SubmitNewsResponse;
import com.bun.xh.vo.UserDeleteNewsRequest;
import com.bun.xh.vo.UserDeleteNewsResponse;
import org.junit.Assert;
import org.junit.Test;

public class Delete extends AbstractNews{
    @Test
    public void test() throws BunServerException, BunServiceException {
        String newsId = String.valueOf(System.currentTimeMillis());
        String userId = "测试人";
        SubmitNewsRequest submitNewsRequest = buildSubmitNewsRequest(userId,newsId);
        SubmitNewsResponse response = newsFacade.submitNews(submitNewsRequest);

        UserDeleteNewsRequest userDeleteNewsRequest = buildUserDeleteNewsRequest(userId,newsId);
        UserDeleteNewsResponse userDeleteNewsResponse = newsFacade.userDeleteNews(userDeleteNewsRequest);
        Assert.assertEquals(ResultCodeEnum.SUCCESS.getCode(),userDeleteNewsResponse.getResultCode());
    }
}