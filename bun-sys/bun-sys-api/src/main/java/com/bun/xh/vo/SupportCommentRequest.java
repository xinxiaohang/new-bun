package com.bun.xh.vo;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

@Getter
@Setter
public class SupportCommentRequest {

    @NotEmpty
    private String commentId;
}