package com.example.mycloudmusicapi.domain;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * 歌单
 */
@Data
public class Sheet extends Common {
    /**
     * 标题
     */
    @NotBlank(message = "标题不能为空")
    @Length(min = 1, max = 30, message = "标题长度必须为1~30位")
    private String title;

    /**
     * 封面
     */
    private String banner;

    /**
     * 描述
     */
    private String description;

    /**
     * 创建歌单的用户
     */
    private User user;

    /**
     * 创建歌单的用户id
     */
    private String userId;

    /**
     * 点击数
     */
    private Integer clicksCount;

    /**
     * 收藏数
     */
    private Integer collectionsCount;

    /**
     * 评论数
     */
    private Integer commentsCount;

    /**
     * 标签
     */
    private List<Tag> tags;

    /**
     * 所有歌曲
     */
    private List<Song> songs;

    /**
     * 如果不为1表示用户未收藏该歌单
     */
    private Integer isCollection;

}
