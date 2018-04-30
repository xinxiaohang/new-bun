package com.bun.xh.repository.dto;

import java.util.Date;

public class NewsLogDTO {

    private String newsId;

    private Integer fromStatus;

    private Integer toStatus;

    private Date optTime;

    private String checkUserName;

    private String checkUserId;

    private String overruleReason;

    private Integer version;

    public NewsLogDTO(){};

    public NewsLogDTO(String newsId, Integer fromStatus, Integer toStatus,
                      Date optTime, String checkUserName, String checkUserId,
                      String overruleReason, Integer version) {
        this.newsId = newsId;
        this.fromStatus = fromStatus;
        this.toStatus = toStatus;
        this.optTime = optTime;
        this.checkUserName = checkUserName;
        this.checkUserId = checkUserId;
        this.overruleReason = overruleReason;
        this.version = version;
    }

    public String getNewsId() {
        return newsId;
    }

    public void setNewsId(String newsId) {
        this.newsId = newsId == null ? null : newsId.trim();
    }

    public Integer getFromStatus() {
        return fromStatus;
    }

    public void setFromStatus(Integer fromStatus) {
        this.fromStatus = fromStatus == null ? null : fromStatus;
    }

    public Integer getToStatus() {
        return toStatus;
    }

    public void setToStatus(Integer toStatus) {
        this.toStatus = toStatus == null ? null : toStatus;
    }

    public Date getOptTime() {
        return optTime;
    }

    public void setOptTime(Date optTime) {
        this.optTime = optTime;
    }

    public String getCheckUserName() {
        return checkUserName;
    }

    public void setCheckUserName(String checkUserName) {
        this.checkUserName = checkUserName == null ? null : checkUserName.trim();
    }

    public String getCheckUserId() {
        return checkUserId;
    }

    public void setCheckUserId(String checkUserId) {
        this.checkUserId = checkUserId == null ? null : checkUserId.trim();
    }

    public String getOverruleReason() {
        return overruleReason;
    }

    public void setOverruleReason(String overruleReason) {
        this.overruleReason = overruleReason == null ? null : overruleReason.trim();
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}