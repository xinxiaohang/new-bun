package com.bun.xh.vo;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by xin on 2018/4/22.
 */

@Getter
@Setter
public class RegisterRequest {

    @NotEmpty
    private String userId;
    @NotEmpty
    private String userName;
    @NotEmpty
    private String password;
    private String userPic;
}
