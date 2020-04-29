-- 测试数据库表结构

-- 下面的sql前面有依赖关系

-- 我们这里使用的是h2数据库
-- 因为我们使用的内存数据库，测试更快
-- 语法和mysql有些一些区别
-- 当然也可以使用mysql

-- SET MODE=MySQL;
-- SET FOREIGN_KEY_CHECKS=0;

-- 用户表
CREATE TABLE `user`
(
    `id`                   VARCHAR(32)  NOT NULL COMMENT '主键',
    `nickname`             VARCHAR(30)  NOT NULL COMMENT '昵称',
    `avatar`               VARCHAR(255)          DEFAULT NULL COMMENT '头像',
    `description`          VARCHAR(255)          DEFAULT NULL COMMENT '描述',
    `gender`               INT          NOT NULL DEFAULT '0' COMMENT '性别',
    `birthday`             DATE                  DEFAULT NULL COMMENT '生日',
    `email`                VARCHAR(255) NOT NULL COMMENT '邮箱',
    `phone`                VARCHAR(50)  NOT NULL COMMENT '手机号',
    `province`             VARCHAR(50)           DEFAULT NULL COMMENT '省',
    `province_code`        VARCHAR(50)           DEFAULT NULL COMMENT '省编码',
    `city`                 VARCHAR(50)           DEFAULT NULL COMMENT '市',
    `city_code`            VARCHAR(50)           DEFAULT NULL COMMENT '市编码',
    `area`                 VARCHAR(50)           DEFAULT NULL COMMENT '区',
    `area_code`            VARCHAR(50)           DEFAULT NULL COMMENT '区编码',
    `password`             VARCHAR(255) NOT NULL COMMENT '密码',
    `session_digest`       VARCHAR(255)          DEFAULT NULL COMMENT '登录后token',
    `confirmation_digest`  VARCHAR(255)          DEFAULT NULL COMMENT '邮箱确认token',
    `confirmed_at`         DATETIME              DEFAULT NULL COMMENT '邮箱确认时间',
    `confirmation_sent_at` DATETIME              DEFAULT NULL COMMENT '邮箱确认发送时间',
    `qq_id`                VARCHAR(200)          DEFAULT NULL COMMENT 'QQ登录id',
    `qq_id_digest`         VARCHAR(200)          DEFAULT NULL COMMENT 'QQ登录id加密后值',
    `wechat_id`            VARCHAR(200)          DEFAULT NULL COMMENT '微信id',
    `wechat_id_digest`     VARCHAR(200)          DEFAULT NULL COMMENT '微信id加密后值',
    `weibo_id`             VARCHAR(200)          DEFAULT NULL COMMENT '微博id',
    `weibo_id_digest`      VARCHAR(200)          DEFAULT NULL COMMENT '微博id加密后值',
    `code`                 VARCHAR(200)          DEFAULT NULL COMMENT '验证码',
    `code_sent_at`         DATETIME              DEFAULT NULL COMMENT '验证码发送时间',
    `push`                 varchar(255)          default null comment '当前用户设备推送id',
    `songs_count`          int          not null default '0' comment '音乐数',
    `sheets_count`         int          not null default '0' comment '歌单数',
    `videos_count`         int          not null default '0' comment '视频数',
    `comments_count`       int          not null default '0' comment '评论数',
    `likes_count`          int          not null default '0' comment '点赞数',
    `followings_count`     int          not null default '0' comment '好友数',
    `followers_count`      int          not null default '0' comment '粉丝数',
    `created_at`           DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_at`           DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `index_user_on_email` (`email`),
    UNIQUE KEY `index_user_on_phone` (`phone`),
    UNIQUE KEY `index_user_on_qq_id` (`qq_id`),
    UNIQUE KEY `index_user_on_wechat_id` (`wechat_id`),
    UNIQUE KEY `index_user_on_weibo_id` (`weibo_id`)
);

CREATE TABLE `ad`
(
    `id`         VARCHAR(32)  NOT NULL COMMENT '主键',
    `title`      VARCHAR(255)          DEFAULT NULL COMMENT '标题',
    `banner`     VARCHAR(255) NOT NULL COMMENT '封面',
    `uri`        VARCHAR(255)          DEFAULT NULL COMMENT '广告地址',
    `order`      INT                   DEFAULT NULL COMMENT '排序',
    `user_id`    VARCHAR(32)  NOT NULL COMMENT '用户id',
    `created_at` DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_at` DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`),
    KEY `index_ad_on_user_id` (`user_id`),
    CONSTRAINT `fk_ad_user_id` FOREIGN KEY (`user_id`)
        REFERENCES `user` (`id`)
);

-- 歌单表
CREATE TABLE `sheet`
(
    `id`                VARCHAR(32)  NOT NULL COMMENT '主键id',
    `title`             VARCHAR(255) NOT NULL COMMENT '标题',
    `banner`            VARCHAR(255)          DEFAULT NULL COMMENT '封面',
    `description`       VARCHAR(255)          DEFAULT NULL COMMENT '描述',
    `clicks_count`      INT          NOT NULL DEFAULT '0' COMMENT '点击数',
    `collections_count` INT          NOT NULL DEFAULT '0' COMMENT '收藏数',
    `comments_count`    INT          NOT NULL DEFAULT '0' COMMENT '评论数',
    `user_id`           VARCHAR(32)  NOT NULL COMMENT '用户id',
    `created_at`        DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_at`        DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`),
    KEY `index_sheet_on_user_id` (`user_id`),
    CONSTRAINT `fk_sheet_user_id` FOREIGN KEY (`user_id`)
        REFERENCES `user` (`id`)
);

-- 标签表
CREATE TABLE `tag`
(
    `id`         VARCHAR(32)  NOT NULL COMMENT '主键id',
    `title`      VARCHAR(255) NOT NULL COMMENT '标题',
    `parent_id`  VARCHAR(32)      NULL DEFAULT NULL COMMENT '上级标签id',
    `user_id`    VARCHAR(32)  NOT NULL COMMENT '用户id',
    `created_at` DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_at` DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `index_tag_on_title_and_user_id` (`title`, `user_id`),
    KEY `index_tag_on_user_id` (`user_id`),
    CONSTRAINT `fk_tag_user_id` FOREIGN KEY (`user_id`)
        REFERENCES `user` (`id`)
);

-- 标签和歌单关联关系表
CREATE TABLE `label`
(
    `id`         VARCHAR(32) NOT NULL COMMENT '主键id',
    `tag_id`     VARCHAR(32) NOT NULL COMMENT '标签id',
    `sheet_id`   VARCHAR(32) NOT NULL COMMENT '歌单id',
    `user_id`    VARCHAR(32) NOT NULL COMMENT '用户id',
    `created_at` DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_at` DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY index_label_on_tag_id_and_sheet_id_and_user_id (`tag_id`, `sheet_id`, `user_id`),
    KEY `index_label_on_tag_id` (`tag_id`),
    KEY `index_label_on_sheet_id` (`sheet_id`),
    KEY `index_label_on_user_id` (`user_id`),
    CONSTRAINT `fk_label_tag_id` FOREIGN KEY (`tag_id`)
        REFERENCES `tag` (`id`),
    CONSTRAINT `fk_label_sheet_id` FOREIGN KEY (`sheet_id`)
        REFERENCES `sheet` (`id`),
    CONSTRAINT `fk_label_user_id` FOREIGN KEY (`user_id`)
        REFERENCES `user` (`id`)
);

-- 音乐表
CREATE TABLE `song`
(
    `id`             VARCHAR(32)  NOT NULL COMMENT '主键id',
    `title`          VARCHAR(50)  NOT NULL COMMENT '标题',
    `banner`         VARCHAR(255) NOT NULL COMMENT '封面',
    `uri`            VARCHAR(255) NOT NULL COMMENT '音乐地址',
    `style`          INT COMMENT '歌词类型',
    `lyric`          TEXT COMMENT '歌词内容',
    `clicks_count`   INT          NOT NULL DEFAULT '0' COMMENT '点击数',
    `comments_count` INT          NOT NULL DEFAULT '0' COMMENT '评论数',
    `user_id`        VARCHAR(32)  NOT NULL COMMENT '用户id',
    `singer_id`      VARCHAR(32)  NOT NULL COMMENT '歌手id',
    `created_at`     DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_at`     DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`),
    KEY `index_song_on_user_id` (`user_id`),
    CONSTRAINT `fk_song_user_id` FOREIGN KEY (`user_id`)
        REFERENCES `user` (`id`),
    CONSTRAINT `fk_song_singer_id` FOREIGN KEY (`singer_id`)
        REFERENCES `user` (`id`)
);

-- 歌单，音乐关系表
CREATE TABLE `relation`
(
    `id`         VARCHAR(32) NOT NULL COMMENT '主键id',
    `song_id`    VARCHAR(32) NOT NULL COMMENT '音乐id',
    `sheet_id`   VARCHAR(32) NOT NULL COMMENT '歌单id',
    `user_id`    VARCHAR(32) NOT NULL COMMENT '用户id',
    `created_at` DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_at` DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `index_relation_on_song_id_and_sheet_id_and_user_id` (`song_id`, `sheet_id`, `user_id`),
    KEY `index_relation_on_song_id` (`song_id`),
    KEY `index_relation_on_sheet_id` (`sheet_id`),
    KEY `index_relation_on_user_id` (`user_id`),
    CONSTRAINT `fk_relation_song_id` FOREIGN KEY (`song_id`)
        REFERENCES `song` (`id`) ON DELETE CASCADE,
    CONSTRAINT `fk_relation_sheet_id` FOREIGN KEY (`sheet_id`)
        REFERENCES `sheet` (`id`),
    CONSTRAINT `fk_relation_user_id` FOREIGN KEY (`user_id`)
        REFERENCES `user` (`id`)
);

-- 歌单收藏状态
CREATE TABLE `collection`
(
    `id`         VARCHAR(32) NOT NULL COMMENT '主键',
    `sheet_id`   VARCHAR(32) NOT NULL COMMENT '歌单id',
    `user_id`    VARCHAR(32) NOT NULL COMMENT '用户id',
    `created_at` DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_at` DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `index_collection_on_sheet_id_and_user_id` (`sheet_id`, `user_id`),
    KEY `index_collection_sheet_id` (`sheet_id`),
    KEY `index_collection_user_id` (`user_id`),
    CONSTRAINT `fk_collection_sheet_id` FOREIGN KEY (`sheet_id`)
        REFERENCES `sheet` (`id`),
    CONSTRAINT `fk_collection_user_id` FOREIGN KEY (`user_id`)
        REFERENCES `user` (`id`)
);

-- 视频表
CREATE TABLE `video`
(
    `id`             VARCHAR(32)  NOT NULL COMMENT '主键id',
    `title`          VARCHAR(50)  NOT NULL COMMENT '标题',
    `clicks_count`   INT          NOT NULL DEFAULT '0' COMMENT '点击数',
    `likes_count`    INT          NOT NULL DEFAULT '0' COMMENT '点赞数',
    `comments_count` INT          NOT NULL DEFAULT '0' COMMENT '评论数',
    `uri`            VARCHAR(255) NOT NULL COMMENT '视频地址',
    `banner`         VARCHAR(255)          DEFAULT NULL COMMENT '封面',
    `duration`       INT                   DEFAULT '0' COMMENT '视频时长',
    `user_id`        VARCHAR(32)  NOT NULL COMMENT '用户id',
    `created_at`     DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_at`     DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`),
    KEY `index_video_on_user_id` (`user_id`),
    CONSTRAINT `fk_video_user_id` FOREIGN KEY (`user_id`)
        REFERENCES `user` (`id`)
);

-- 评论表
CREATE TABLE `comment`
(
    `id`          VARCHAR(32)  NOT NULL COMMENT '主键id',
    `content`     VARCHAR(190) NOT NULL COMMENT '内容',
    `parent_id`   VARCHAR(32)           DEFAULT NULL COMMENT '被回复评论id',
    `video_id`    VARCHAR(32)           DEFAULT NULL COMMENT '视频id',
    `sheet_id`    VARCHAR(32)           DEFAULT NULL COMMENT '歌单id',
    `song_id`     VARCHAR(32)           DEFAULT NULL COMMENT '音乐id',
    `likes_count` INT                   DEFAULT '0' COMMENT '点赞数',
    `user_id`     VARCHAR(32)  NOT NULL COMMENT '用户id',
    `created_at`  DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_at`  DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`),
    KEY `index_comment_on_parent_id` (`parent_id`),
    KEY `index_comment_on_video_id` (`video_id`),
    KEY `index_comment_on_sheet_id` (`sheet_id`),
    KEY `index_comment_on_song_id` (`song_id`),
    KEY `index_comment_on_user_id` (`user_id`),
    CONSTRAINT `fk_comment_parent_id` FOREIGN KEY (`parent_id`)
        REFERENCES `comment` (`id`),
    CONSTRAINT `fk_comment_video_id` FOREIGN KEY (`video_id`)
        REFERENCES `video` (`id`),
    CONSTRAINT `fk_comment_sheet_id` FOREIGN KEY (`sheet_id`)
        REFERENCES `sheet` (`id`),
    CONSTRAINT `fk_comment_song_id` FOREIGN KEY (`song_id`)
        REFERENCES `song` (`id`),
    CONSTRAINT `fk_comment_user_id` FOREIGN KEY (`user_id`)
        REFERENCES `user` (`id`)
);

-- 点赞表
CREATE TABLE `like`
(
    `id`         VARCHAR(32) NOT NULL COMMENT '主键id',
    `comment_id` VARCHAR(32) NOT NULL COMMENT '评论id',
    `user_id`    VARCHAR(32) NOT NULL COMMENT '用户id',
    `created_at` DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_at` DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `index_like_on_comment_id_and_user_id` (`comment_id`, `user_id`),
    KEY `index_like_on_comment_id` (`comment_id`),
    KEY `index_like_on_user_id` (`user_id`),
    CONSTRAINT `fk_like_user_id` FOREIGN KEY (`user_id`)
        REFERENCES `user` (`id`),
    CONSTRAINT `fk_like_comment_id` FOREIGN KEY (`comment_id`)
        REFERENCES `comment` (`id`)
);

-- 动态表
CREATE TABLE `feed`
(
    `id`         VARCHAR(32)  NOT NULL COMMENT '主键id',
    `content`    VARCHAR(190) NOT NULL COMMENT '内容',
    `province`   VARCHAR(50)           DEFAULT NULL COMMENT '省',
    `city`       VARCHAR(50)           DEFAULT NULL COMMENT '市',
    `longitude`  DECIMAL(10, 7)        DEFAULT NULL COMMENT '经度',
    `latitude`   DECIMAL(10, 7)        DEFAULT NULL COMMENT '纬度',
    `user_id`    VARCHAR(32)  NOT NULL COMMENT '用户id',
    `created_at` DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_at` DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`),
    KEY `index_feed_on_user_id` (`user_id`),
    CONSTRAINT `fk_feed_user_id` FOREIGN KEY (`user_id`)
        REFERENCES `user` (`id`)
);

-- 资源表
CREATE TABLE `resource`
(
    `id`         VARCHAR(32)  NOT NULL COMMENT '主键id',
    `uri`        VARCHAR(255) NOT NULL COMMENT '地址',
    `feed_id`    VARCHAR(32)  NOT NULL COMMENT '动态id',
    `user_id`    VARCHAR(32)  NOT NULL COMMENT '用户id',
    `created_at` DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_at` DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `index_resource_on_uri` (`uri`),
    KEY `index_resource_on_feed_id` (`feed_id`),
    KEY `index_resource_on_user_id` (`user_id`),
    CONSTRAINT `fk_resource_feed_id` FOREIGN KEY (`feed_id`)
        REFERENCES `feed` (`id`),
    CONSTRAINT `fk_resource_user_id` FOREIGN KEY (`user_id`)
        REFERENCES `user` (`id`)
);

-- 好友表
CREATE TABLE `friend`
(
    `id`          VARCHAR(32) NOT NULL COMMENT '主键id',
    `follower_id` VARCHAR(32) NOT NULL COMMENT '当前用户id',
    `followed_id` VARCHAR(32) NOT NULL COMMENT '对方id',
    `created_at`  DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_at`  DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `index_friend_on_follower_id_and_followed_id` (`follower_id`, `followed_id`),
    KEY `index_friend_on_follower_id` (`follower_id`),
    KEY `index_friend_on_followed_id` (`followed_id`),
    CONSTRAINT `fk_follower_id` FOREIGN KEY (`follower_id`)
        REFERENCES `user` (`id`),
    CONSTRAINT `fk_followed_id` FOREIGN KEY (`followed_id`)
        REFERENCES `user` (`id`)
);

-- 话题表
CREATE TABLE `topic`
(
    `id`          VARCHAR(32)  NOT NULL COMMENT '主键id',
    `title`       VARCHAR(50)  NOT NULL COMMENT '标题',
    `banner`      VARCHAR(255) NOT NULL COMMENT '封面',
    `description` VARCHAR(255)          DEFAULT NULL COMMENT '描述',
    `joins_count` VARCHAR(255)          DEFAULT '0' COMMENT '参与人数',
    `user_id`     VARCHAR(32)  NOT NULL COMMENT '用户id',
    `created_at`  DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_at`  DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`),
    KEY `index_topic_on_user_id` (`user_id`),
    CONSTRAINT `fk_topic_user_id` FOREIGN KEY (`user_id`)
        REFERENCES `user` (`id`)
);

-- 商品表
CREATE TABLE `book`
(
    `id`         VARCHAR(32)    NOT NULL COMMENT '主键id',
    `title`      VARCHAR(50)    NOT NULL COMMENT '标题',
    `banner`     VARCHAR(255)   NOT NULL COMMENT '封面',
    `price`      DECIMAL(10, 2) NOT NULL COMMENT '价格',
    `user_id`    VARCHAR(32)    NOT NULL COMMENT '用户id',
    `created_at` DATETIME       NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_at` DATETIME       NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`),
    KEY `index_book_on_user_id` (`user_id`),
    CONSTRAINT `fk_book_user_id` FOREIGN KEY (`user_id`)
        REFERENCES `user` (`id`)
);

-- 订单表
CREATE TABLE `order`
(
    `id`         VARCHAR(32)    NOT NULL COMMENT '注解id',
    `status`     INT                     DEFAULT '0' COMMENT '状态',
    `price`      DECIMAL(10, 2) NOT NULL COMMENT '价格',
    `source`     INT                     DEFAULT '0' COMMENT '订单来源',
    `origin`     INT                     DEFAULT '0' COMMENT '支付来源',
    `channel`    INT                     DEFAULT '0' COMMENT '支付渠道',
    `number`     VARCHAR(190)   NOT NULL COMMENT '订单号',
    `other`      VARCHAR(190)            DEFAULT NULL COMMENT '第三方订单号',
    `book_id`    VARCHAR(32)    NOT NULL COMMENT '商品id',
    `user_id`    VARCHAR(32)    NOT NULL COMMENT '用户id',
    `created_at` DATETIME       NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_at` DATETIME       NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `index_order_on_number` (`number`),
    UNIQUE KEY `index_order_on_book_id_and_user_id` (`book_id`, `user_id`),
    KEY `index_order_on_book_id` (`book_id`),
    KEY `index_order_on_user_id` (`user_id`),
    CONSTRAINT `fk_order_book_id` FOREIGN KEY (`book_id`)
        REFERENCES `book` (`id`),
    CONSTRAINT `fk_order_user_id` FOREIGN KEY (`user_id`)
        REFERENCES `user` (`id`)
);