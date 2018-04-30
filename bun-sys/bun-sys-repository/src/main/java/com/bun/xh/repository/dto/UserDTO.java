package com.bun.xh.repository.dto;

import java.util.Date;

public class UserDTO {

    private String userId;

    private String userName;

    private String password;

    private String userPic;

    private Date registTime;

    private String userStatus;

    private Integer version;

    public UserDTO(){}

    public UserDTO(String userId, String userName, String password,
                   String userPic, Date registTime, String userStatus,
                   Integer version) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.userPic = userPic;
        this.registTime = registTime;
        this.userStatus = userStatus;
        this.version = version;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getUserPic() {
        return userPic;
    }

    public void setUserPic(String userPic) {
        this.userPic = userPic == null ? null : userPic.trim();
    }

    public Date getRegistTime() {
        return registTime;
    }

    public void setRegistTime(Date registTime) {
        this.registTime = registTime;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus == null ? null : userStatus.trim();
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}