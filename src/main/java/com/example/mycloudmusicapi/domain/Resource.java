package com.example.mycloudmusicapi.domain;

import lombok.Data;

/**
 * 资源模型
 */
@Data
public class Resource extends Common {
    /**
     * 地址
     */
    private String uri;

    /**
     * 动态id
     */
    private String feedId;

    /**
     * 用户id
     */
    private String userId;
}
