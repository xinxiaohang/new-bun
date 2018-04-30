package com.bun.xh.vo;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by xin on 2018/4/22.
 */
@Getter
@Setter
public class ReportNewsRequest {

    @NotEmpty
    private String newsId;
    @NotEmpty
    private String reportUserId;
    @NotEmpty
    private String reportReason;
}
