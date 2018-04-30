package com.bun.xh.service.comment;

import com.bun.xh.api.CommentFacade;
import com.bun.xh.api.NewsFacade;
import com.bun.xh.vo.ApproveNewsRequest;
import com.bun.xh.vo.PublishNewsRequest;
import com.bun.xh.vo.ReportCommentRequest;
import com.bun.xh.vo.SubmitCommentRequest;
import com.bun.xh.vo.SubmitNewsRequest;
import com.bun.xh.vo.SupportCommentRequest;
import com.bun.xh.vo.TreadCommentRequest;
import com.bun.xh.vo.UserDeleteCommentRequest;
import com.bun.xh.vo.UserDeleteNewsRequest;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:config/spring/applicationContext-boot.xml")
public class AbstractComment {

    @Autowired
    protected CommentFacade commentFacade;

    @Autowired
    protected NewsFacade newsFacade;

    protected SubmitNewsRequest buildSubmitNewsRequest(String userId, String newsId){
        SubmitNewsRequest request = new SubmitNewsRequest();
        request.setNewsId(newsId);
        request.setNewDesc("测试新闻内容");
        request.setNewTitle("测试新闻题目");
        request.setNewsPic("测试图片");
        request.setUserId(userId);
        request.setNewsType(1);
        return request;
    }

    protected PublishNewsRequest buildPublishNewsRequest(String userId, String newsId){
        PublishNewsRequest request = new PublishNewsRequest();
        request.setNewsId(newsId);
        request.setUserId(userId);
        return request;
    }

    protected ApproveNewsRequest buildApproveRequest(List<String> newsIds){
        ApproveNewsRequest request = new ApproveNewsRequest();
        request.setCheckedUserId("测试审核人id");
        request.setCheckedUserName("测试审核人名字");
        request.setNewsIds(newsIds);
        return request;
    }

    protected SubmitCommentRequest buildSubmitCommentRequest(
            String userId,String commentId,String newsId){
        SubmitCommentRequest request = new SubmitCommentRequest();
        request.setCommentId(commentId);
        request.setNewsId(newsId);
        request.setUserName("测试评论人");
        request.setRespCommentId(null);
        request.setCommentDesc("测试评论");
        request.setUserId(userId);
        return request;
    }

    protected UserDeleteCommentRequest buildUserDeleteCommentRequest(String userId,String commentId){
        UserDeleteCommentRequest request = new UserDeleteCommentRequest();
        request.setUserId(userId);
        request.setCommentId(commentId);
        return request;
    }

    protected SupportCommentRequest buildSupportCommentRequest(String commentId){
        SupportCommentRequest request = new SupportCommentRequest();
        request.setCommentId(commentId);
        return request;
    }

    protected TreadCommentRequest buildTreadCommentRequest(String commentId){
        TreadCommentRequest request = new TreadCommentRequest();
        request.setCommentId(commentId);
        return request;
    }

    protected ReportCommentRequest buildReportCommentRequest(String commentId){
        ReportCommentRequest request = new ReportCommentRequest();
        request.setCommentId(commentId);
        request.setReportUserId("测试举报userid");
        request.setReportReason("测试举报评论理由");
        return request;
    }
}