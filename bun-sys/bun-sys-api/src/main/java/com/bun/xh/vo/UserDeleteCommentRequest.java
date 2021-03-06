package com.bun.xh.vo;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by xin on 2018/4/23.
 */
@Getter
@Setter
public class UserDeleteCommentRequest {

    @NotEmpty
    private String userId;
    @NotEmpty
    private String commentId;
}
