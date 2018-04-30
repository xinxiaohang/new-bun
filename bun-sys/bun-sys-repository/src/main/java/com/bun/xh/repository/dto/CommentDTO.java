package com.bun.xh.repository.dto;

import java.util.Date;

public class CommentDTO {

    private String commentId;

    private String commentDesc;

    private Date commentTime;

    private String newsId;

    private String userId;

    private String userName;

    private String respCommentId;

    private Integer commSupportTime;

    private Integer commTreadTime;

    private Integer commReportTime;

    private String commReportReason;

    private Integer version;

    public CommentDTO() {
    }

    public CommentDTO(String commentId, String commentDesc, Date commentTime,
                      String newsId, String userId, String userName,
                      String respCommentId, Integer commSupportTime, Integer commTreadTime,
                      Integer commReportTime, String commReportReason, Integer version) {
        this.commentId = commentId;
        this.commentDesc = commentDesc;
        this.commentTime = commentTime;
        this.newsId = newsId;
        this.userId = userId;
        this.userName = userName;
        this.respCommentId = respCommentId;
        this.commSupportTime = commSupportTime;
        this.commTreadTime = commTreadTime;
        this.commReportTime = commReportTime;
        this.commReportReason = commReportReason;
        this.version = version;
    }

    public String getCommentId() {
        return commentId;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId == null ? null : commentId.trim();
    }

    public String getCommentDesc() {
        return commentDesc;
    }

    public void setCommentDesc(String commentDesc) {
        this.commentDesc = commentDesc == null ? null : commentDesc.trim();
    }

    public Date getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
    }

    public String getNewsId() {
        return newsId;
    }

    public void setNewsId(String newsId) {
        this.newsId = newsId == null ? null : newsId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getRespCommentId() {
        return respCommentId;
    }

    public void setRespCommentId(String respCommentId) {
        this.respCommentId = respCommentId == null ? null : respCommentId.trim();
    }

    public Integer getCommSupportTime() {
        return commSupportTime;
    }

    public void setCommSupportTime(Integer commSupportTime) {
        this.commSupportTime = commSupportTime;
    }

    public Integer getCommTreadTime() {
        return commTreadTime;
    }

    public void setCommTreadTime(Integer commTreadTime) {
        this.commTreadTime = commTreadTime;
    }

    public Integer getCommReportTime() {
        return commReportTime;
    }

    public void setCommReportTime(Integer commReportTime) {
        this.commReportTime = commReportTime;
    }

    public String getCommReportReason() {
        return commReportReason;
    }

    public void setCommReportReason(String commReportReason) {
        this.commReportReason = commReportReason;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}