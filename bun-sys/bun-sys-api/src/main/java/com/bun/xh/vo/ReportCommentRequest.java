package com.bun.xh.vo;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

@Getter
@Setter
public class ReportCommentRequest {

    @NotEmpty
    private String commentId;
    @NotEmpty
    private String reportUserId;
    @NotEmpty
    private String reportReason;
}