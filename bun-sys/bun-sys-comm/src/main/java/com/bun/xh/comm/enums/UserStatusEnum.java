package com.bun.xh.comm.enums;

public enum UserStatusEnum {

    NEWS_USER("1","新闻用户"),

    CHECK_USER("2","审核用户"),

    OPERATION("3","后台");

    String status;
    String statusDesc;

    UserStatusEnum(String status, String statusDesc) {
        this.status = status;
        this.statusDesc = statusDesc;
    }

    public String getStatus(){
        return status;
    }

    public String getStatusDesc(){
        return statusDesc;
    }
}