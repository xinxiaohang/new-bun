package com.bun.xh.service.news;

import com.bun.xh.api.NewsFacade;
import com.bun.xh.vo.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by xin on 2018/4/23.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:config/spring/applicationContext-boot.xml")
public class AbstractNews {

    @Autowired
    protected NewsFacade newsFacade;

    protected SubmitNewsRequest buildSubmitNewsRequest(String userId,String newsId){
        SubmitNewsRequest request = new SubmitNewsRequest();
        request.setNewsId(newsId);
        request.setNewDesc("测试新闻内容");
        request.setNewTitle("测试新闻题目");
        request.setNewsPic("测试图片");
        request.setUserId(userId);
        request.setNewsType(1);
        return request;
    }

    protected PublishNewsRequest buildPublishNewsRequest(String userId,String newsId){
        PublishNewsRequest request = new PublishNewsRequest();
        request.setNewsId(newsId);
        request.setUserId(userId);
        return request;
    }

    protected ApproveNewsRequest buildApproveRequest(List<String>newsIds){
        ApproveNewsRequest request = new ApproveNewsRequest();
        request.setCheckedUserId("测试审核人id");
        request.setCheckedUserName("测试审核人名字");
        request.setNewsIds(newsIds);
        return request;
    }

    protected OverruleNewsRequest buildOverruleNewsRequest(List<String>newsIds){
        OverruleNewsRequest request = new OverruleNewsRequest();
        request.setCheckedUserId("测试审核人id");
        request.setCheckedUserName("测试审核人名字");
        request.setOverruleReason("测试不通过理由");
        request.setNewsIds(newsIds);
        return request;
    }

    protected ReportNewsRequest buildReportNewsRequest(String newsId){
        ReportNewsRequest request = new ReportNewsRequest();
        request.setNewsId(newsId);
        request.setReportUserId("测试举报人");
        request.setReportReason("测试举报理由");
        return request;
    }

    protected UserDeleteNewsRequest buildUserDeleteNewsRequest(String userId,String newsId){
        UserDeleteNewsRequest request = new UserDeleteNewsRequest();
        request.setNewsId(newsId);
        request.setUserId(userId);
        return request;
    }

    protected SupportNewsRequest buildSupportNewsRequest(String newsId){
        SupportNewsRequest request = new SupportNewsRequest();
        request.setNewsId(newsId);
        return request;
    }

    protected TreadNewsRequest buildTreadNewsRequest(String newsId){
        TreadNewsRequest request = new TreadNewsRequest();
        request.setNewsId(newsId);
        return request;
    }
}
