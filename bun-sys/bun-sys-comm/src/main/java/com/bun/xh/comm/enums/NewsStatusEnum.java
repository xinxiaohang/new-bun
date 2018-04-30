package com.bun.xh.comm.enums;

/**
 * Created by xin on 2018/4/7.
 */
public enum NewsStatusEnum {

    SUBMIT(0,"已提交，未发布"),

    PUBLISH(1,"已发布，待审核"),

    APPROVE(2,"审核通过"),

    OVERRULE(-1,"审核不通过"),

    DELETE(-2,"已删除");

    Integer status;
    String statusDesc;

    NewsStatusEnum(int status, String statusDesc) {
        this.status = status;
        this.statusDesc = statusDesc;
    }

    public Integer getStatus(){
        return status;
    }

    public String getStatusDesc(){
        return statusDesc;
    }
}
