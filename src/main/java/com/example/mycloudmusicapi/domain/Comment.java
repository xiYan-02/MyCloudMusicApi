package com.example.mycloudmusicapi.domain;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

/**
 * 评论模型
 */
@Data
public class Comment extends Common {
    /**
     * 内容
     */
    @NotBlank(message = "评论内容不能为空")
    @Length(min = 1, max = 140,message = "评论内容请在150字之内")
    private String content;

    /**
     * 被回复评论id
     */
    private String parentId;

    /**
     * 被回复评论
     */
    private Comment parent;

    /**
     * 视频id
     */
    private String videoId;

    /**
     * 歌单id
     */
    private String sheetId;

    /**
     * 歌单对象
     */
    private Sheet sheet;

    /**
     * 音乐id
     */
    private String songId;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 用户
     */
    private User user;

    /**
     * 点赞数
     */
    private int likesCount;

    /**
     * 是否点赞
     */
    private Integer isLike;
}