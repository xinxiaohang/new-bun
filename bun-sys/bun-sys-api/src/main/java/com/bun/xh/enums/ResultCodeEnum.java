package com.bun.xh.enums;

import org.springframework.util.StringUtils;


/**
 * Created by xin on 2018/4/6.
 */
public enum  ResultCodeEnum {

    SUCCESS("0000","操作成功",0),

    //状态错误
    NEWS_STATUS_ERROR("1000","新闻状态不合法",0),

    //查询错误
    NEWS_NULL_ERROR("2000","新闻不存在",0),
    NEWS_LIST_NULL_ERROR("2001","新闻列表不存在",0),
    COMMENT_NULL_ERROR("2002","评论不存在",0),
    USER_NULL_ERROR("2003","用户不存在",0),

    //验证错误
    USER_LOGIN_ERROR("3000","用户名或密码错误",0);

    String code;
    String message;
    Integer eFlag;

    ResultCodeEnum(String code, String message, Integer eFlag) {
        this.code = code;
        this.message = message;
        this.eFlag = eFlag;
    }

    public String getCode(){
        return code;
    }

    public String getMessage(){
        return message;
    }

    public Integer getEFlag(){
        return eFlag;
    }

    public static Integer getEFlagByCode(String code){
        Integer eFlag = 0;
        if(StringUtils.isEmpty(code)){
            ResultCodeEnum[] enums = ResultCodeEnum.values();
            for(ResultCodeEnum codeEnum: enums){
                if(code.equals(codeEnum.getCode())){
                    eFlag = codeEnum.eFlag;
                }
            }
        }
        return eFlag;
    }
}
