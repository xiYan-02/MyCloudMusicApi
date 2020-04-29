package com.example.mycloudmusicapi.domain;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 点赞模型
 */
@Data
public class Like extends Common {
    /**
     * 评论id
     */
    @NotBlank(message = "评论id不能为空")
    private String commentId;

    /**
     * 用户id
     */
    private String userId;
}
