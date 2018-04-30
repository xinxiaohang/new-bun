package com.bun.xh.biz.newshandler;

import com.bun.xh.biz.AbstractHandler;
import com.bun.xh.enums.ResultCodeEnum;
import com.bun.xh.repository.db.model.News;
import com.bun.xh.repository.db.service.NewLogService;
import com.bun.xh.repository.db.service.NewsService;
import com.bun.xh.repository.dto.NewsDTO;
import com.bun.xh.repository.dto.NewsLogDTO;
import com.bun.xh.vo.AbstractResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;

public class AbstractNewsHandler extends AbstractHandler{

    @Autowired
    private NewsService newsService;

    @Autowired
    private NewLogService newLogService;

    @Autowired
    protected TransactionTemplate transactionTemplate;

    protected NewsDTO selectNewsByNewsId(String newsId){
        return newsService.selectNewsByNewsId(newsId);
    }

    protected void summitChange(final NewsDTO newsDTO, final NewsLogDTO newsLogDTO){
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                newsService.insert(newsDTO);
                newLogService.insertLog(newsLogDTO);
            }
        });
    }

    protected NewsDTO selectNewsByUserIdAndNewId(String userId,String newsId){
        return newsService.selectNewsByUserIdAndNewId(userId,newsId);
    }

    protected void publishChange (final NewsDTO newsDTO, final NewsLogDTO newsLogDTO){
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                newsService.updateByNewsId(newsDTO);
                newLogService.insertLog(newsLogDTO);
            }
        });
    }

    protected List<NewsDTO> selectNewsByNewsIds(List<String> newsIds){
        List<NewsDTO> newsDTOs = newsService.selectNewsByNewsIds(newsIds);
        return newsDTOs;
    }

    protected void approveChange(final List<NewsDTO> newsDTOs, final List<NewsLogDTO> newsLogDTOs){
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                newsService.updateByNewsIds(newsDTOs);
                newLogService.insertLogs(newsLogDTOs);
            }
        });
    }

    protected void updateByNewsId(NewsDTO newsDTO){
        newsService.updateByNewsId(newsDTO);
    }

//    protected void userDeleteNewsByNewsId(String newsId){
//        newsService.deleteNewsByNewsId(newsId);
//    }
}