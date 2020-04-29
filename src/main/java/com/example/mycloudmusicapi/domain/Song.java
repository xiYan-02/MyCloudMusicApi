package com.example.mycloudmusicapi.domain;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

/**
 * 音乐模型
 */
@Data
public class Song extends Common {
    /**
     * 标题
     */
    @NotBlank(message = "标题不能为空")
    @Length(min = 1, max = 30, message = "标题长度必须为1~30位")
    private String title;

    /**
     * 封面
     */
    @NotBlank(message = "封面不能为空")
    private String banner;

    /**
     * 当前音乐的url
     *
     * 相对地址
     * 真实项目中，可能会区分不同的码率
     * 但根据不同的实现，会不同的方式
     */
    @NotBlank(message = "音乐地址不能为空")
    private String uri;

    /**
     * 点击数
     */
    private int clicksCount;

    /**
     * 评论数
     */
    private int commentsCount;

    /**
     * 歌词类型
     *
     * 0:lrc，10:ksc
     */
    private Integer style;

    /**
     * 歌词
     */
    private String lyric;

    /**
     * 谁创建这首音乐
     */
    private User user;

    /**
     * 创建音乐用户id
     *
     * 保存数据用
     */
    private String userId;

    /**
     * 歌手
     */
    private User singer;

    /**
     * 歌手Id
     *
     * 这里引用的是user
     * 没有将歌手放到单独的表中
     * 保存数据用
     */
    @NotBlank(message = "歌手不能为空")
    private String singerId;
}
