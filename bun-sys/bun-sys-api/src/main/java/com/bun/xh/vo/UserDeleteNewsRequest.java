package com.bun.xh.vo;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;


/**
 * Created by xin on 2018/4/23.
 */
@Getter
@Setter
public class UserDeleteNewsRequest {

    @NotEmpty
    private String userId;
    @NotEmpty
    private String newsId;
}
