package com.bun.xh.vo;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.List;

/**
 * Created by xin on 2018/4/22.
 */
@Getter
@Setter
public class OverruleNewsRequest {

    @NotEmpty
    private List<String> newsIds;
    @NotEmpty
    private String checkedUserName;
    @NotEmpty
    private String checkedUserId;
    @NotEmpty
    private String OverruleReason;
}
