package com.example.mycloudmusicapi.domain;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

@Data
public class Ad extends Common {

    @NotEmpty(message = "标题不能为空")
    @Length(max = 30,min = 1,message = "标题长度应在1~30之间")
    private String title;

    @NotEmpty(message = "封面不能为空")
    private String banner;

    /**
     * 跳转地址
     */
    private String uri;

    /**
     * 排序，值越大越靠前
     */
    private int order;

    /**
     * 用户id
     * <p>
     * 保存数据/更新数据时用
     */
    private String userId;

    /**
     * 谁创建的
     */
    private User user;

}
