package com.bun.xh.vo;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class BeCheckRequest {

    @NotNull
    private String userId;
}