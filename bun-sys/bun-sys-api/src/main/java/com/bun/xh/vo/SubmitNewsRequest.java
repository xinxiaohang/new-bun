package com.bun.xh.vo;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.EAN;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by xin on 2018/4/22.
 */
@Getter
@Setter
public class SubmitNewsRequest {

    @NotEmpty
    private String newsId;
    @NotEmpty
    private String newTitle;
    @NotEmpty
    private Integer newsType;
    @NotEmpty
    private String newDesc;
    @NotEmpty
    private String newsPic;
    @NotEmpty
    private String userId;
}
