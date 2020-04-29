package com.example.mycloudmusicapi.domain;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

/**
 * 视频模型
 */
@Data
public class Video extends Common {
    /**
     * 标题
     */
    @NotBlank(message = "标题不能为空")
    @Length(min = 1, max = 30, message = "标题长度为1~30位")
    private String title;

    /**
     * 点击数
     */
    private int clicksCount;

    /**
     * 点赞数
     */
    private int likesCount;

    /**
     * 评论数
     */
    private int commentsCount;

    /**
     * 视频地址
     */
    @NotBlank(message = "视频地址不能为空")
    private String uri;

    /**
     * 封面
     */
    @NotBlank(message = "封面地址不能为空")
    private String banner;

    /**
     * 视频时长
     *
     * 单位秒
     */
    private int duration;

    /**
     * 创建视频用户id
     */
    private String userId;

    /**
     * 创建视频用户
     */
    private User user;
}
