package com.demo.model.vo;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;

@Data
@Accessors(chain = true)
public class NewAccountRequestVO {

    @NotNull(message = "姓名{name}不能为空")
    private String name;

    @NotNull(message = "性别{sex}不能为空")
    private Integer sex;

    private Integer age;

    @NotNull(message = "会员级别{level}不能为空")
    private String level;
}
