package com.example.mycloudmusicapi.domain;

import lombok.Data;

/**
 * 好友模型
 */
@Data
public class Friend extends Common{
    /**
     * 当前用户id
     */
    private String followerId;

    /**
     * 对方id
     */
    private String followedId;
}