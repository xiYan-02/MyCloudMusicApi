package com.example.mycloudmusicapi.domain;

import lombok.Data;

/**
 * 歌单和音乐关系
 */
@Data
public class Relation extends Common {
    /**
     * 音乐id
     */
    private String songId;

    /**
     * 歌单id
     */
    private String sheetId;

    /**
     * 用户id
     */
    private String userId;
}
