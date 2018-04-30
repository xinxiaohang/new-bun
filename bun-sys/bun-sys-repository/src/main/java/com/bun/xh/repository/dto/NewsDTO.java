package com.bun.xh.repository.dto;

import com.bun.xh.repository.db.model.News;

import java.util.Date;

/**
 * Created by xin on 2018/4/22.
 */
public class NewsDTO {

    private String newsId;

    private String newsTitle;

    private String newDesc;

    private String newsPic;

    private Integer newsType;

    private Integer newsStatus;

    private String userId;

    private Integer newsSupportTime;

    private Integer newsReportTime;

    private String newsReportReason;

    private Integer newsTreadTime;

    private Integer version;

    public NewsDTO(){};

    public NewsDTO(String newsId, String newsTitle, String newDesc,
                   String newsPic, Integer newsType, Integer newsStatus,
                   String userId, Integer newsSupportTime, Integer newsReportTime,
                   String newsReportReason, Integer newsTreadTime, Integer version) {
        this.newsId = newsId;
        this.newsTitle = newsTitle;
        this.newDesc = newDesc;
        this.newsPic = newsPic;
        this.newsType = newsType;
        this.newsStatus = newsStatus;
        this.userId = userId;
        this.newsSupportTime = newsSupportTime;
        this.newsReportTime = newsReportTime;
        this.newsReportReason = newsReportReason;
        this.newsTreadTime = newsTreadTime;
        this.version = version;
    }

    public String getNewsId() {
        return newsId;
    }

    public void setNewsId(String newsId) {
        this.newsId = newsId == null ? null : newsId.trim();
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle == null ? null : newsTitle.trim();
    }

    public String getNewDesc() {
        return newDesc;
    }

    public void setNewDesc(String newDesc) {
        this.newDesc = newDesc == null ? null : newDesc.trim();
    }

    public String getNewsPic() {
        return newsPic;
    }

    public void setNewsPic(String newsPic) {
        this.newsPic = newsPic == null ? null : newsPic.trim();
    }

    public Integer getNewsType() {
        return newsType;
    }

    public void setNewsType(Integer newsType) {
        this.newsType = newsType;
    }

    public Integer getNewsStatus() {
        return newsStatus;
    }

    public void setNewsStatus(Integer newsStatus) {
        this.newsStatus = newsStatus;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Integer getNewsSupportTime() {
        return newsSupportTime;
    }

    public void setNewsSupportTime(Integer newsSupportTime) {
        this.newsSupportTime = newsSupportTime;
    }

    public Integer getNewsReportTime() {
        return newsReportTime;
    }

    public void setNewsReportTime(Integer newsReportTime) {
        this.newsReportTime = newsReportTime;
    }

    public String getNewsReportReason() {
        return newsReportReason;
    }

    public void setNewsReportReason(String newsReportReason) {
        this.newsReportReason = newsReportReason;
    }

    public Integer getNewsTreadTime() {
        return newsTreadTime;
    }

    public void setNewsTreadTime(Integer newsTreadTime) {
        this.newsTreadTime = newsTreadTime;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
