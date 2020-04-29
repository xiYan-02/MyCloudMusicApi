package com.example.mycloudmusicapi.domain;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 歌单收藏模型
 */
@Data
public class Collection extends Common {
    /**
     * 歌单id
     */
    @NotBlank(message = "歌单id不能为空")
    private String sheetId;

    /**
     * 用户id
     */
    private String userId;
}