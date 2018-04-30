package com.bun.xh.service.news;

import com.bun.xh.enums.ResultCodeEnum;
import com.bun.xh.exception.BunServerException;
import com.bun.xh.exception.BunServiceException;
import com.bun.xh.vo.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Overrule extends AbstractNews {

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
        OverruleNewsRequest overruleNewsRequest = buildOverruleNewsRequest(newsIds);
        OverruleNewsResponse overruleNewsResponse = newsFacade.overruleNews(overruleNewsRequest);
        Assert.assertEquals(ResultCodeEnum.SUCCESS.getCode(),overruleNewsResponse.getResultCode());
    }

}