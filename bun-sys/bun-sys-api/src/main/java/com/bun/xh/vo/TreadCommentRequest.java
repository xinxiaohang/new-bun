package com.bun.xh.vo;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

@Getter
@Setter
public class TreadCommentRequest {

    @NotEmpty
    private String commentId;
}