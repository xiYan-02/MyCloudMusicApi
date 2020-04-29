package com.example.mycloudmusicapi.domain;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * 动态模型
 */
@Data
public class Feed extends Common {
    /**
     * 动态内容
     */
    @NotBlank(message = "内容不能为空")
    @Length(min = 1, max = 140, message = "内容长度必须为1~140位")
    private String content;

    /**
     * 省
     */
    private String province;

    /**
     * 市
     */
    private String city;

    /**
     * 经度
     */
    private Double longitude;

    /**
     * 纬度
     */
    private Double latitude;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 用户
     */
    private User user;

    /**
     * 图片资源
     */
    private List<Resource> images;
}
