-- 测试数据


/*
用户数据

-- Query: SELECT * FROM my_cloud_music_api_sp_dev.user
LIMIT 0, 500

*/
INSERT INTO `user` (`id`, `nickname`, `avatar`, `description`, `gender`, `birthday`, `email`, `phone`, `province`,
                    `province_code`, `city`, `city_code`, `area`, `area_code`, `password`, `session_digest`,
                    `confirmation_digest`, `confirmed_at`, `confirmation_sent_at`, `qq_id`, `qq_id_digest`, `wechat_id`,
                    `wechat_id_digest`, `weibo_id`, `weibo_id_digest`, `created_at`, `updated_at`, `code`,
                    `code_sent_at`, `push`, `songs_count`, `sheets_count`, `videos_count`, `comments_count`,
                    `likes_count`, `followers_count`, `followings_count`)
VALUES ('0a9f66ac1c9311eaad6c00163e101bf3', '张北北', 'assets/yong_bao_ni_de_ni_de_li_qu.jpg',
        '张北北，华语新锐男主持、歌手、艺人经纪人。青春阳光，以轻松幽默亲和的主持风格见长，以潮流的姿态赋予生活独立的娱乐精神，深受年轻观众的喜爱。发行过个人单曲《1234567》', 0, NULL,
        'ixueaeduzbb@163.com', '13712348765', NULL, NULL, NULL, NULL, NULL, NULL,
        '$2a$10$SnSd8CiGL29bn97b34m41Oy2kMqtzhglNETsCEbYUL4j4b5OtVUKy', NULL, '580da1f1ca74b7514a2b8d84afc9fd80', NULL,
        '2019-12-12 11:54:05', NULL, NULL, NULL, NULL, NULL, NULL, '2019-12-12 11:54:05', '2019-12-19 23:26:52', NULL,
        NULL, NULL, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO `user` (`id`, `nickname`, `avatar`, `description`, `gender`, `birthday`, `email`, `phone`, `province`,
                    `province_code`, `city`, `city_code`, `area`, `area_code`, `password`, `session_digest`,
                    `confirmation_digest`, `confirmed_at`, `confirmation_sent_at`, `qq_id`, `qq_id_digest`, `wechat_id`,
                    `wechat_id_digest`, `weibo_id`, `weibo_id_digest`, `created_at`, `updated_at`, `code`,
                    `code_sent_at`, `push`, `songs_count`, `sheets_count`, `videos_count`, `comments_count`,
                    `likes_count`, `followers_count`, `followings_count`)
VALUES ('1d79719d1c9311eaad6c00163e101bf3', '李宗盛', 'assets/li_zong_sheng.jpg',
        '台湾知名创作歌手兼音乐制作人。李宗盛的作品大部分都是词曲包办，旋律与歌词并重。1986年，李宗盛发行全创作专辑《生命中的精灵》，编曲以木吉他为基调，偶尔缀以简约的乐团伴奏，凝炼、集中、张力十足的音场，是台湾流行音乐前所未闻的创举。2006年开始，华语乐坛教父李宗盛开始举办《李宗盛理性与感性作品音乐会》巡演。被称为“华语流行乐坛教父”，华语流行乐坛公认的首席金牌制作人，除了他擅长创作，制作外还有很重要的一个原因。发掘提携出周华健、辛晓琪、张信哲、莫文蔚、光良、品冠、五月天、梁静茹等歌手，是80年代后期和90',
        0, NULL, 'ixueaedulzs@163.com', '13812348765', NULL, NULL, NULL, NULL, NULL, NULL,
        '$2a$10$qm0VPUZ7gNedqpwPjXHS6.DjoasyclJjbCXSZnbTve9biaiEh.35W', NULL, '05080963c62328a371a5a9e26c7f6085', NULL,
        '2019-12-12 11:54:37', NULL, NULL, NULL, NULL, NULL, NULL, '2019-12-12 11:54:36', '2019-12-19 23:26:52', NULL,
        NULL, NULL, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO `user` (`id`, `nickname`, `avatar`, `description`, `gender`, `birthday`, `email`, `phone`, `province`,
                    `province_code`, `city`, `city_code`, `area`, `area_code`, `password`, `session_digest`,
                    `confirmation_digest`, `confirmed_at`, `confirmation_sent_at`, `qq_id`, `qq_id_digest`, `wechat_id`,
                    `wechat_id_digest`, `weibo_id`, `weibo_id_digest`, `created_at`, `updated_at`, `code`,
                    `code_sent_at`, `push`, `songs_count`, `sheets_count`, `videos_count`, `comments_count`,
                    `likes_count`, `followers_count`, `followings_count`)
VALUES ('31808a741c9311eaad6c00163e101bf3', '叶启田', 'assets/ye_qi_tian.jpg',
        '叶宪修（1948年6月1日－），艺名叶启田，台湾嘉义县太保市人，著名歌手，有“宝岛歌王”之美誉。1964年出道，以《爱拼才会赢》一曲成为龙头巨星，出过50张以上的专辑，而歌曲达1000首以上。曾任中国台湾地区第二及第四届立法委员。2005年末，复出并再发行新唱片《爱你未着我祝你幸福》。',
        0, NULL, 'ixueaeduyqt@163.com', '13912348765', NULL, NULL, NULL, NULL, NULL, NULL,
        '$2a$10$UWtl4JgHlas1ydI0JyGARu04A.sAkFmQYw3/FHBY/B4Na4c.Yax.m', NULL, 'fed3c46148cf5974f1a57d9f74c223b5', NULL,
        '2019-12-12 11:55:10', NULL, NULL, NULL, NULL, NULL, NULL, '2019-12-12 11:55:10', '2019-12-19 23:26:52', NULL,
        NULL, NULL, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO `user` (`id`, `nickname`, `avatar`, `description`, `gender`, `birthday`, `email`, `phone`, `province`,
                    `province_code`, `city`, `city_code`, `area`, `area_code`, `password`, `session_digest`,
                    `confirmation_digest`, `confirmed_at`, `confirmation_sent_at`, `qq_id`, `qq_id_digest`, `wechat_id`,
                    `wechat_id_digest`, `weibo_id`, `weibo_id_digest`, `created_at`, `updated_at`, `code`,
                    `code_sent_at`, `push`, `songs_count`, `sheets_count`, `videos_count`, `comments_count`,
                    `likes_count`, `followers_count`, `followings_count`)
VALUES ('a79f853e1c9211eaad6c00163e101bf3', '安东阳', 'assets/andongyang.jpg',
        '安东阳(Aidy)，男歌手。 代表作品有《缘分惹的祸》《网络一线牵》《一只蝴蝶》等。', 0, NULL, 'ixueaeduady@163.com', '13412348765', NULL, NULL, NULL,
        NULL, NULL, NULL, '$2a$10$sTHhHNwV7XzuOZtIScUbGe3NQEEsY6xCePMish2.rjT.L5HPKoTde', NULL,
        '78a5d488748ded5e9117b6cb17e57cfb', NULL, '2019-12-12 11:51:19', NULL, NULL, NULL, NULL, NULL, NULL,
        '2019-12-12 11:51:19', '2019-12-19 23:26:52', NULL, NULL, NULL, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO `user` (`id`, `nickname`, `avatar`, `description`, `gender`, `birthday`, `email`, `phone`, `province`,
                    `province_code`, `city`, `city_code`, `area`, `area_code`, `password`, `session_digest`,
                    `confirmation_digest`, `confirmed_at`, `confirmation_sent_at`, `qq_id`, `qq_id_digest`, `wechat_id`,
                    `wechat_id_digest`, `weibo_id`, `weibo_id_digest`, `created_at`, `updated_at`, `code`,
                    `code_sent_at`, `push`, `songs_count`, `sheets_count`, `videos_count`, `comments_count`,
                    `likes_count`, `followers_count`, `followings_count`)
VALUES ('f30cefcf1c9211eaad6c00163e101bf3', '曾春年', 'assets/zengchunnian.jpg',
        '曾春年，中国大陆华语流行歌手，实力唱作人，著名音乐人。他的才能――除了作曲、填词，包办唱片全部制作。2010年凭借《最幸福的人》成为当代大街小巷首选的播放曲目。 曾春年的名字已经成为一股强烈旋风，迅速由广东席卷至全国各地。',
        0, NULL, 'ixueaeduzcn@163.com', '13512348765', NULL, NULL, NULL, NULL, NULL, NULL,
        '$2a$10$qza/Z1rstbDXTN3BqPgAseaPTmAgAF7DmQfLLqIue0HYzT.IskIQK', NULL, '188928b1e12c66a517e4083d68a15bf2', NULL,
        '2019-12-12 11:53:25', NULL, NULL, NULL, NULL, NULL, NULL, '2019-12-12 11:53:25', '2019-12-19 23:26:52', NULL,
        NULL, NULL, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO `user` (`id`, `nickname`, `avatar`, `description`, `gender`, `birthday`, `email`, `phone`, `province`,
                    `province_code`, `city`, `city_code`, `area`, `area_code`, `password`, `session_digest`,
                    `confirmation_digest`, `confirmed_at`, `confirmation_sent_at`, `qq_id`, `qq_id_digest`, `wechat_id`,
                    `wechat_id_digest`, `weibo_id`, `weibo_id_digest`, `created_at`, `updated_at`, `code`,
                    `code_sent_at`, `push`, `songs_count`, `sheets_count`, `videos_count`, `comments_count`,
                    `likes_count`, `followers_count`, `followings_count`)
VALUES ('efef0b5019c111eaad6c00163e101bf3', '爱学啊',
        'http://thirdqq.qlogo.cn/qqapp/101464132/1A9F7466DF196A10D4F969522B0871D6/100', '我们是爱学啊！', '0', NULL,
        'ixueaedu@163.com', '13141111222', NULL, NULL, NULL, NULL, NULL, NULL,
        '$2a$10$wv6dus/16I3LQGhHNLy2r./Dqi/ih6B.oZSdCukVwZC21G/cDJyg2',
        '$2a$10$WsqjUck70UH2d8zSvvJA/uyD02n.2QN/Wgc2.BjU/Be34lLL1RS8e', NULL, '2019-12-08 22:22:59',
        '2019-12-08 22:22:31', '8ab5f6ef0a180bc281d33681e6940cf0092eccdd',
        '$2a$10$U97.Uq.VahbiglKCGT25POOLbZZYaG2ZCfYueN/IbMEmIT628A7y2', NULL, NULL,
        '8ab5f6ef0a180bc281d33681e6940cf0092eccdd', '$2a$10$HIuHxmErr6ofBLPaV2n/1.juUL2Xc0aMid22f0rMjro1PZDiBLxoi',
        '2019-12-08 21:52:13', '2019-12-30 10:05:24', 'fb8feff253bb6c834deb61ec76baa893', '2019-12-30 10:05:24', NULL,
        '0', '0', '0', '0', '0', '2', '0');
INSERT INTO `user` (`id`, `nickname`, `avatar`, `description`, `gender`, `birthday`, `email`, `phone`, `province`,
                    `province_code`, `city`, `city_code`, `area`, `area_code`, `password`, `session_digest`,
                    `confirmation_digest`, `confirmed_at`, `confirmation_sent_at`, `qq_id`, `qq_id_digest`, `wechat_id`,
                    `wechat_id_digest`, `weibo_id`, `weibo_id_digest`, `created_at`, `updated_at`, `code`,
                    `code_sent_at`, `push`, `songs_count`, `sheets_count`, `videos_count`, `comments_count`,
                    `likes_count`, `followers_count`, `followings_count`)
VALUES ('2bef0b5019c111eaad6c00163e101bf3', '爱学啊dev',
        'http://thirdqq.qlogo.cn/qqapp/101464132/1A9F7466DF196A10D4F969522B0871D6/100',
        '我们是爱学啊Android开发组哟1，有什么问题可以联系我们呀！new', '0', NULL, 'ixueadev@163.com', '13141111333', NULL, NULL, NULL, NULL,
        NULL, NULL, '$2a$10$wv6dus/16I3LQGhHNLy2r./Dqi/ih6B.oZSdCukVwZC21G/cDJyg2',
        '$2a$10$WsqjUck70UH2d8zSvvJA/uyD02n.2QN/Wgc2.BjU/Be34lLL1RS8e', NULL, '2019-12-08 22:22:59',
        '2019-12-08 22:22:31', NULL, '$2a$10$U97.Uq.VahbiglKCGT25POOLbZZYaG2ZCfYueN/IbMEmIT628A7y2', NULL, NULL, NULL,
        '$2a$10$HIuHxmErr6ofBLPaV2n/1.juUL2Xc0aMid22f0rMjro1PZDiBLxoi', '2019-12-08 21:52:13', '2019-12-30 10:05:24',
        NULL, '2019-12-30 10:05:24', NULL, '0', '0', '0', '0', '0', '2', '0');

/*
-- Query: SELECT * FROM my_cloud_music_api_sp_dev.ad
LIMIT 0, 500


*/
INSERT INTO `ad` (`id`, `title`, `banner`, `uri`, `order`, `user_id`, `created_at`, `updated_at`)
VALUES ('1', '人生苦短，我们只做好课！', 'assets/banner1.png', 'http://www.ixuea.com/courses', 1,
        'efef0b5019c111eaad6c00163e101bf3', '2019-05-01 05:35:48', '2020-01-04 00:25:40');
INSERT INTO `ad` (`id`, `title`, `banner`, `uri`, `order`, `user_id`, `created_at`, `updated_at`)
VALUES ('2', '这是广告，你信不信1', 'assets/banner2.png', 'http://www.ixuea.com/books', 100, 'efef0b5019c111eaad6c00163e101bf3',
        '2019-05-01 05:35:49', '2020-01-04 00:25:41');

/*
-- Query: SELECT * FROM my_cloud_music_api_sp_dev.sheet
LIMIT 0, 500


*/
INSERT INTO `sheet` (`id`, `title`, `banner`, `description`, `clicks_count`, `collections_count`, `comments_count`,
                     `user_id`, `created_at`, `updated_at`)
VALUES ('1', '这世上所有的歌zheshishangtest', 'assets/list1.jpg',
        '这是因为iOS9引入了新特性App Transport Security (ATS)，他要求App内网络请求必须使用HTTPS协议。解决方法是要么改为HTTPS，要么声明可以使用HTTP，可以声明部分使用HTTP，也可以所有；但需要说明的是如果APP内所有请求都是HTTP，那么如果要上架App Store的时候基本都会被拒。',
        3084, 7, 40, 'efef0b5019c111eaad6c00163e101bf3', '2200-04-10 00:28:49', '2019-12-21 22:48:03');
INSERT INTO `sheet` (`id`, `title`, `banner`, `description`, `clicks_count`, `collections_count`, `comments_count`,
                     `user_id`, `created_at`, `updated_at`)
VALUES ('10', '你开始懂得了歌词', 'assets/shengburusi.jpg', '这是歌单描述', 346, 0, 0, 'efef0b5019c111eaad6c00163e101bf3',
        '2200-04-10 00:20:49', '2019-12-11 22:25:52');
INSERT INTO `sheet` (`id`, `title`, `banner`, `description`, `clicks_count`, `collections_count`, `comments_count`,
                     `user_id`, `created_at`, `updated_at`)
VALUES ('2', '我向来做事十拿九不稳 不信可以试试woxianglaitest', 'assets/list2.jpg',
        '第三方SDK只是将消息从一个用户分发到另一个用户，而用户信息，好友关系，群组关系我们后台维护，当然如果要严格显示非好友之间发消息，所以还需要将用户，好友关系，群组同步到第三方；用户信息大多数平台都只需要一个Id，像群组的实现逻辑是，在我们的后台创建一个群组后在第三方平台也创建一个',
        680, 0, 0, 'efef0b5019c111eaad6c00163e101bf3', '2200-04-10 00:26:49', '2019-12-11 18:38:11');
INSERT INTO `sheet` (`id`, `title`, `banner`, `description`, `clicks_count`, `collections_count`, `comments_count`,
                     `user_id`, `created_at`, `updated_at`)
VALUES ('3', '网络离别歌曲最后还是离开了wangllibietest', 'assets/list3.jpg',
        '今天盘点了网络离别歌曲，用这些歌纪念那些最后还是离开的人吧。在人生的旅途中走得越远，陪你走到最后的人就越少，有些人渐行渐远，渐渐消失在人海，我们也会离开别人', 3723, 0, 0,
        'efef0b5019c111eaad6c00163e101bf3', '2200-04-10 00:24:49', '2019-12-11 18:38:15');
INSERT INTO `sheet` (`id`, `title`, `banner`, `description`, `clicks_count`, `collections_count`, `comments_count`,
                     `user_id`, `created_at`, `updated_at`)
VALUES ('4558b886240511eaad6c00163e101bf3', 'test create sheet1', NULL, NULL, 0, 0, 0,
        'efef0b5019c111eaad6c00163e101bf3', '2019-12-21 23:19:24', '2020-01-03 22:35:58');
INSERT INTO `sheet` (`id`, `title`, `banner`, `description`, `clicks_count`, `collections_count`, `comments_count`,
                     `user_id`, `created_at`, `updated_at`)
VALUES ('9', '伤心的人怎可愿意听慢歌', 'assets/yuanfengredehuo_andongyang.jpg',
        '今天盘点了网络离别歌曲，用这些歌纪念那些最后还是离开的人吧。在人生的旅途中走得越远，陪你走到最后的人就越少，有些人渐行渐远，渐渐消失在人海，我们也会离开别人', 84, 0, 0,
        'efef0b5019c111eaad6c00163e101bf3', '2200-04-10 00:22:49', '2019-12-09 11:16:31');
INSERT INTO `sheet` (`id`, `title`, `banner`, `description`, `clicks_count`, `collections_count`, `comments_count`,
                     `user_id`, `created_at`, `updated_at`)
VALUES ('a672d09e1d8e11eaad6c00163e101bf3', 'sheet', NULL, NULL, 0, 0, 0, 'efef0b5019c111eaad6c00163e101bf3',
        '2019-12-13 17:56:04', '2019-12-13 17:56:04');
INSERT INTO `sheet` (`id`, `title`, `banner`, `description`, `clicks_count`, `collections_count`, `comments_count`,
                     `user_id`, `created_at`, `updated_at`)
VALUES ('aeca600e1bf811eaad6c00163e101bf3', '这是歌单1', 'banner1.jpg', '这是歌单描述，爱学啊！', 0, 0, 0,
        'efef0b5019c111eaad6c00163e101bf3', '2019-12-11 17:29:35', '2019-12-11 17:29:35');
INSERT INTO `sheet` (`id`, `title`, `banner`, `description`, `clicks_count`, `collections_count`, `comments_count`,
                     `user_id`, `created_at`, `updated_at`)
VALUES ('b672d09e1d8e11eaad6c00163e101bf3', '我没有名词', NULL, '这是没有歌单名称歌单的描述', 0, 0, 0, 'efef0b5019c111eaad6c00163e101bf3',
        '2019-12-13 17:56:04', '2019-12-13 17:56:04');
INSERT INTO `sheet` (`id`, `title`, `banner`, `description`, `clicks_count`, `collections_count`, `comments_count`,
                     `user_id`, `created_at`, `updated_at`)
VALUES ('bb08f21e1d8711eaad6c00163e101bf3', '这是歌单NewJSON', NULL, NULL, 0, 0, 0, 'efef0b5019c111eaad6c00163e101bf3',
        '2019-12-13 17:05:38', '2019-12-13 17:05:38');
INSERT INTO `sheet` (`id`, `title`, `banner`, `description`, `clicks_count`, `collections_count`, `comments_count`,
                     `user_id`, `created_at`, `updated_at`)
VALUES ('beca600e1bf811eaad6c00163e101bf3', '这是歌单1', 'banner1.jpg', '这是歌单描述，爱学啊！', 0, 0, 0,
        'efef0b5019c111eaad6c00163e101bf3', '2019-12-11 17:29:35', '2019-12-11 17:29:35');
INSERT INTO `sheet` (`id`, `title`, `banner`, `description`, `clicks_count`, `collections_count`, `comments_count`,
                     `user_id`, `created_at`, `updated_at`)
VALUES ('c672d09e1d8e11eaad6c00163e101bf3', '这是有Tag的歌单', NULL, NULL, 0, 0, 0, 'efef0b5019c111eaad6c00163e101bf3',
        '2019-12-13 17:56:04', '2019-12-13 17:56:04');

/*
-- Query: SELECT * FROM my_cloud_music_api_sp_dev.tag
LIMIT 0, 500


*/
INSERT INTO `tag` (`id`, `title`, `parent_id`, `user_id`, `created_at`, `updated_at`)
VALUES ('1', '语种', NULL, 'efef0b5019c111eaad6c00163e101bf3', '2019-05-01 05:35:13', '2019-05-01 05:35:13');
INSERT INTO `tag` (`id`, `title`, `parent_id`, `user_id`, `created_at`, `updated_at`)
VALUES ('12osdglsgg', '测试标签1', NULL, 'efef0b5019c111eaad6c00163e101bf3', '2019-12-29 15:45:03', '2019-12-29 15:45:03');
INSERT INTO `tag` (`id`, `title`, `parent_id`, `user_id`, `created_at`, `updated_at`)
VALUES ('2', '华语', '1', 'efef0b5019c111eaad6c00163e101bf3', '2019-05-01 05:35:13', '2019-05-01 05:35:13');
INSERT INTO `tag` (`id`, `title`, `parent_id`, `user_id`, `created_at`, `updated_at`)
VALUES ('3', '欧美', '1', 'efef0b5019c111eaad6c00163e101bf3', '2019-05-01 05:35:13', '2019-05-01 05:35:13');
INSERT INTO `tag` (`id`, `title`, `parent_id`, `user_id`, `created_at`, `updated_at`)
VALUES ('4', '风格', NULL, 'efef0b5019c111eaad6c00163e101bf3', '2019-05-01 05:35:14', '2019-05-01 05:35:14');
INSERT INTO `tag` (`id`, `title`, `parent_id`, `user_id`, `created_at`, `updated_at`)
VALUES ('5', '流行', '4', 'efef0b5019c111eaad6c00163e101bf3', '2019-05-01 05:35:14', '2019-05-01 05:35:14');
INSERT INTO `tag` (`id`, `title`, `parent_id`, `user_id`, `created_at`, `updated_at`)
VALUES ('6', '摇滚', '4', 'efef0b5019c111eaad6c00163e101bf3', '2019-05-01 05:35:14', '2019-05-01 05:35:14');
INSERT INTO `tag` (`id`, `title`, `parent_id`, `user_id`, `created_at`, `updated_at`)
VALUES ('fdlgijfdl0', '测试标签2', NULL, 'efef0b5019c111eaad6c00163e101bf3', '2019-12-29 15:45:03', '2019-12-29 15:45:03');

/*
-- Query: SELECT * FROM my_cloud_music_api_sp_dev.label
LIMIT 0, 500


*/
INSERT INTO `label` (`id`, `tag_id`, `sheet_id`, `user_id`, `created_at`, `updated_at`)
VALUES ('1', '2', '1', 'efef0b5019c111eaad6c00163e101bf3', '2019-05-01 05:35:21', '2019-05-01 05:35:21');
INSERT INTO `label` (`id`, `tag_id`, `sheet_id`, `user_id`, `created_at`, `updated_at`)
VALUES ('2', '2', '2', 'efef0b5019c111eaad6c00163e101bf3', '2019-05-01 05:35:25', '2019-05-01 05:35:25');
INSERT INTO `label` (`id`, `tag_id`, `sheet_id`, `user_id`, `created_at`, `updated_at`)
VALUES ('3', '3', '3', 'efef0b5019c111eaad6c00163e101bf3', '2019-05-01 05:35:29', '2019-05-01 05:35:29');
INSERT INTO `label` (`id`, `tag_id`, `sheet_id`, `user_id`, `created_at`, `updated_at`)
VALUES ('4', '5', '1', 'efef0b5019c111eaad6c00163e101bf3', '2019-05-01 05:35:32', '2019-05-01 05:35:32');
INSERT INTO `label` (`id`, `tag_id`, `sheet_id`, `user_id`, `created_at`, `updated_at`)
VALUES ('4c64d4a8bc78f0a60514922aeacb9452', '5', 'bb08f21e1d8711eaad6c00163e101bf3', 'efef0b5019c111eaad6c00163e101bf3',
        '2019-12-13 17:56:34', '2019-12-13 17:56:34');
INSERT INTO `label` (`id`, `tag_id`, `sheet_id`, `user_id`, `created_at`, `updated_at`)
VALUES ('4cc5560cbf77562e04a2fbe540decc9f', '4', 'c672d09e1d8e11eaad6c00163e101bf3', 'efef0b5019c111eaad6c00163e101bf3',
        '2019-12-13 17:56:04', '2019-12-13 17:56:04');
INSERT INTO `label` (`id`, `tag_id`, `sheet_id`, `user_id`, `created_at`, `updated_at`)
VALUES ('5', '5', '2', 'efef0b5019c111eaad6c00163e101bf3', '2019-05-01 05:35:36', '2019-05-01 05:35:36');
INSERT INTO `label` (`id`, `tag_id`, `sheet_id`, `user_id`, `created_at`, `updated_at`)
VALUES ('6', '6', '3', 'efef0b5019c111eaad6c00163e101bf3', '2019-05-01 05:35:40', '2019-05-01 05:35:40');
INSERT INTO `label` (`id`, `tag_id`, `sheet_id`, `user_id`, `created_at`, `updated_at`)
VALUES ('b21f614915d76e6e0e2ababa8f7d5798', '2', 'bb08f21e1d8711eaad6c00163e101bf3', 'efef0b5019c111eaad6c00163e101bf3',
        '2019-12-13 17:56:34', '2019-12-13 17:56:34');
INSERT INTO `label` (`id`, `tag_id`, `sheet_id`, `user_id`, `created_at`, `updated_at`)
VALUES ('cca20fc42ccd40f1cfbcdf7cf1e0c4c1', '5', 'c672d09e1d8e11eaad6c00163e101bf3', 'efef0b5019c111eaad6c00163e101bf3',
        '2019-12-13 17:56:04', '2019-12-13 17:56:04');

/*
-- Query: SELECT * FROM my_cloud_music_api_sp_dev.song
LIMIT 0, 500


*/
-- h2数据库无法插入这条sql；因为语法KSC歌词内容有冲突
-- INSERT INTO `song` (`id`,`title`,`banner`,`uri`,`clicks_count`,`comments_count`,`style`,`lyric`,`user_id`,`singer_id`,`created_at`,`updated_at`) VALUES ('1','爱拼才会赢','assets/s1.jpg','assets/s1.mp3',0,0,10,'karaoke := CreateKaraokeObject;\nkaraoke.rows := 2;\nkaraoke.TimeAfterAnimate := 2000;\nkaraoke.TimeBeforeAnimate := 4000;\nkaraoke.clear;\n\nkaraoke.add(\'00:27.487\', \'00:32.068\', \'一时失志不免怨叹\', \'347,373,1077,320,344,386,638,1096\');\nkaraoke.add(\'00:33.221\', \'00:38.068\', \'一时落魄不免胆寒\', \'282,362,1118,296,317,395,718,1359\');\nkaraoke.add(\'00:38.914\', \'00:42.164\', \'那通失去希望\', \'290,373,348,403,689,1147\');\nkaraoke.add(\'00:42.485\', \'00:44.530\', \'每日醉茫茫\', \'298,346,366,352,683\');\nkaraoke.add(\'00:45.273\', \'00:49.029\', \'无魂有体亲像稻草人\', \'317,364,380,351,326,351,356,389,922\');\nkaraoke.add(\'00:50.281\', \'00:55.585\', \'人生可比是海上的波浪\', \'628,1081,376,326,406,371,375,1045,378,318\');\nkaraoke.add(\'00:56.007\', \'01:00.934\', \'有时起有时落\', \'303,362,1416,658,750,1438\');\nkaraoke.add(\'01:02.020\', \'01:04.581\', \'好运歹运\', \'360,1081,360,760\');\nkaraoke.add(\'01:05.283\', \'01:09.453\', \'总嘛要照起来行\', \'303,338,354,373,710,706,1386\');\nkaraoke.add(\'01:10.979\', \'01:13.029\', \'三分天注定\', \'304,365,353,338,690\');\nkaraoke.add(\'01:13.790\', \'01:15.950\', \'七分靠打拼\', \'356,337,338,421,708\');\nkaraoke.add(\'01:16.339\', \'01:20.870\', \'爱拼才会赢\', \'325,1407,709,660,1430\');\nkaraoke.add(\'01:33.068\', \'01:37.580\', \'一时失志不免怨叹\', \'307,384,1021,363,357,374,677,1029\');\nkaraoke.add(\'01:38.660\', \'01:43.656\', \'一时落魄不免胆寒\', \'381,411,1067,344,375,381,648,1389\');\nkaraoke.add(\'01:44.473\', \'01:47.471\', \'那通失去希望\', \'315,365,340,369,684,925\');\nkaraoke.add(\'01:48.000\', \'01:50.128\', \'每日醉茫茫\', \'338,361,370,370,689\');\nkaraoke.add(\'01:50.862\', \'01:54.593\', \'无魂有体亲像稻草人\', \'330,359,368,376,325,334,352,389,898\');\nkaraoke.add(\'01:55.830\', \'02:01.185\', \'人生可比是海上的波浪\', \'654,1056,416,318,385,416,373,1032,342,363\');\nkaraoke.add(\'02:01.604\', \'02:06.716\', \'有时起有时落\', \'303,330,1432,649,704,1694\');\nkaraoke.add(\'02:07.624\', \'02:10.165\', \'好运歹运\', \'329,1090,369,753\');\nkaraoke.add(\'02:10.829\', \'02:15.121\', \'总嘛要照起来行\', \'313,355,362,389,705,683,1485\');\nkaraoke.add(\'02:16.609\', \'02:18.621\', \'三分天注定\', \'296,363,306,389,658\');\nkaraoke.add(\'02:19.426\', \'02:21.428\', \'七分靠打拼\', \'330,359,336,389,588\');\nkaraoke.add(\'02:21.957\', \'02:26.457\', \'爱拼才会赢\', \'315,1364,664,767,1390\');\nkaraoke.add(\'02:50.072\', \'02:55.341\', \'人生可比是海上的波浪\', \'656,1086,349,326,359,356,364,1095,338,340\');\nkaraoke.add(\'02:55.774\', \'03:01.248\', \'有时起有时落\', \'312,357,1400,670,729,2006\');\nkaraoke.add(\'03:01.787\', \'03:04.369\', \'好运歹运\', \'341,1084,376,781\');\nkaraoke.add(\'03:05.041\', \'03:09.865\', \'总嘛要起工来行\', \'305,332,331,406,751,615,2084\');\nkaraoke.add(\'03:10.754\', \'03:12.813\', \'三分天注定\', \'309,359,361,366,664\');\nkaraoke.add(\'03:13.571\', \'03:15.596\', \'七分靠打拼\', \'320,362,349,352,642\');\nkaraoke.add(\'03:16.106\', \'03:20.688\', \'爱拼才会赢\', \'304,1421,661,706,1490\');','efef0b5019c111eaad6c00163e101bf3','31808a741c9311eaad6c00163e101bf3','2019-05-01 05:20:44','2020-01-04 00:29:50');

INSERT INTO `song` (`id`, `title`, `banner`, `uri`, `clicks_count`, `comments_count`, `style`, `lyric`, `user_id`,
                    `singer_id`, `created_at`, `updated_at`)
VALUES ('10', '伤心的站台', 'assets/yuanfengredehuo_andongyang.jpg', 'assets/shangxingzhantai_andongyang.mp3', 0, 0, 0,
        '[00:00.01]伤心的站台\n[00:05.01]\n[00:06.01]演唱：安东阳\n[00:09.01]作词：安东阳\n[00:11.01]作曲：安东阳\n[00:13.01]编曲：李凯稠\n[00:15.01]伴唱：樊桐舟〈黑鸭子〉\n[00:17.01]混音：周晓明\n[00:19.01]音乐总监：徐齐\n[00:21.01]\n[00:36.75]\n[00:37.75]站在那离别的站台\n[00:43.62]我的心里有太多的无奈\n[00:50.14]想起对你的情想起对你的爱\n[00:57.66]我的心里无限感慨\n[01:02.55]\n[01:04.29]走在这伤心的站台\n[01:10.23]千言万语无法去表白\n[01:17.01]为何有情的人到最后要分开\n[01:24.25]我的心里满是伤怀\n[01:29.30]\n[01:30.76]你就是我的爱 你是一生的爱\n[01:37.70]为何今天你却要离开\n[01:43.53]我徘徊在车窗外 向你把手摆\n[01:50.91]我的心情是否明白\n[01:56.02]\n[01:57.56]看烈车已离开 我的眼泪掉下来\n[02:04.19]明天不能把你来关怀\n[02:10.26]我心里在等待 永远在等待\n[02:17.61]等待拥抱曾经的爱\n[02:22.95]\n[02:24.26]LRC编辑：爱学啊\n[02:49.97]\n[02:50.97]走在这伤心的站台\n[02:57.12]千言万语无法去表白\n[03:03.59]为何有情的人到最后要分开\n[03:10.90]我的心里满是伤怀\n[03:16.04]\n[03:17.41]你就是我的爱 你是一生的爱\n[03:24.31]为何今天你却要离开\n[03:30.12]我徘徊在车窗外 向你把手摆\n[03:37.65]我的心情是否明白\n[03:42.47]\n[03:43.95]看烈车已离开 我的眼泪掉下来\n[03:51.08]明天不能把你来关怀\n[03:57.09]我心里在等待 永远在等待\n[04:04.31]等待拥抱曾经的爱\n[04:09.37]\n[04:10.53]你就是我的爱 你是一生的爱\n[04:17.69]为何今天你却要离开\n[04:23.64]我徘徊在车窗外 向你把手摆\n[04:31.04]我的心情是否明白\n[04:35.98]\n[04:37.26]看烈车已离开 我的眼泪掉下来\n[04:44.22]明天不能把你来关怀\n[04:50.30]我心里在等待 永远在等待\n[04:57.67]等待拥抱曾经的爱\n[05:02.85]\n[05:03.95]我心里在等待 永远在等待\n[05:10.94]等待拥抱曾经的爱\n[05:18.90]',
        'efef0b5019c111eaad6c00163e101bf3', 'a79f853e1c9211eaad6c00163e101bf3', '2019-09-17 05:50:50',
        '2020-01-04 00:29:50');
INSERT INTO `song` (`id`, `title`, `banner`, `uri`, `clicks_count`, `comments_count`, `style`, `lyric`, `user_id`,
                    `singer_id`, `created_at`, `updated_at`)
VALUES ('11', '忘不了的温柔', 'assets/yuanfengredehuo_andongyang.jpg', 'assets/wangbiliaodewenrou_andongyang.mp3', 0, 0, 0,
        '[00:02.21]忘不了的温柔\n[00:04.45]作词：安东阳\n[00:06.38]作曲：安东阳\n[00:08.08]编曲：李凯稠\n[00:09.21]演唱：安东阳\n[00:10.57]伴唱：黑鸭子 樊桐舟\n[00:12.20]混音：周晓明\n[00:16.91]\n[00:17.53]走在落叶飘零的深秋\n[00:21.81]忧伤占据我的心头\n[00:26.23]想起曾经深爱的朋友\n[00:30.52]我的泪就湿了眼眸\n[00:34.10]\n[00:34.99]是你给我太多的温柔\n[00:39.35]让我忘掉所有的哀愁\n[00:43.56]爱你那么深 爱你那么久\n[00:47.97]最后你却放开了手\n[00:51.94]\n[00:53.02]忘不了你最美的温柔\n[00:56.72]忘不了你是我的朋友\n[01:00.70]在天涯的尽头冷冷的秋\n[01:04.97]我用歌声向你深情问候\n[01:09.28]\n[01:10.39]忘不了你最美的温柔\n[01:13.87]忘不了你是我的所有\n[01:17.93]对你太多的思念化作了忧\n[01:22.99]我永远等候\n[01:28.42]\n[01:44.75]是你给我太多的温柔\n[01:49.06]让我忘掉所有的哀愁\n[01:53.43]爱你那么深 爱你那么久\n[01:57.67]最后你却放开了手\n[02:01.64]\n[02:02.79]忘不了你最美的温柔\n[02:06.30]忘不了你是我的朋友\n[02:10.55]在天涯的尽头冷冷的秋\n[02:15.00]我用歌声向你深情问候\n[02:19.43]\n[02:20.26]忘不了你最美的温柔\n[02:23.81]忘不了你是我的所有\n[02:28.29]对你太多的思念化作了忧\n[02:32.71]我永远等候\n[02:36.69]\n[02:37.70]忘不了你最美的温柔\n[02:41.05]忘不了你是我的朋友\n[02:45.80]在天涯的尽头冷冷的秋\n[02:50.10]我用歌声向你深情问候\n[02:54.12]\n[02:55.12]忘不了你最美的温柔\n[02:58.84]忘不了你是我的所有\n[03:03.27]对你太多的思念化作了忧\n[03:07.54]我永远等候\n[03:15.78]',
        'efef0b5019c111eaad6c00163e101bf3', 'a79f853e1c9211eaad6c00163e101bf3', '2019-09-17 05:52:50',
        '2020-01-04 00:29:50');
INSERT INTO `song` (`id`, `title`, `banner`, `uri`, `clicks_count`, `comments_count`, `style`, `lyric`, `user_id`,
                    `singer_id`, `created_at`, `updated_at`)
VALUES ('2', '爱的代价-live', 'assets/s2.jpg', 'assets/s2.mp3', 0, 0, 0,
        '[ti:爱的代价]\n[ar:李宗盛]\n[al:爱的代价]\n[00:00.50]爱的代价\n[00:02.50]演唱：李宗盛\n[00:06.50]\n[00:16.70]还记得年少时的梦吗\n[00:21.43]像朵永远不调零的花\n[00:25.23]陪我经过那风吹雨打\n[00:28.59]看世事无常\n[00:30.57]看沧桑变化\n[00:33.31]那些为爱所付出的代价\n[00:37.10]是永远都难忘的啊\n[00:41.10]所有真心的痴心的话\n[00:44.57]永在我心中虽然已没有他\n[00:51.46]走吧 走吧 人总要学着自己长大\n[00:59.53]走吧 走吧 人生难免经历苦痛挣扎\n[01:07.19]走吧 走吧 为自己的心找一个家\n[01:15.41]也曾伤心流泪\n[01:17.55]也曾黯然心碎\n[01:19.57]这是爱的代价\n[01:22.57]\n[01:40.67]也许我偶尔还是会想他\n[01:45.28]偶尔难免会惦记着他\n[01:49.10]就当他是个老朋友吧\n[01:52.60]也让我心疼也让我牵挂\n[01:57.37]只是我心中不再有火花\n[02:01.21]让往事都随风去吧\n[02:05.10]所有真心的痴心的话\n[02:08.53]仍在我心中\n[02:10.39]虽然已没有他\n[02:15.26]走吧 走吧 人总要学着自己长大\n[02:23.14]走吧 走吧 人生难免经历苦痛挣扎\n[02:31.26]走吧 走吧 为自己的心找一个家\n[02:39.22]也曾伤心流泪\n[02:41.54]也曾黯然心碎\n[02:43.60]这是爱的代价\n[02:46.44]\n[03:22.77]走吧 走吧 人总要学着自己长大\n[03:31.16]走吧 走吧 人生难免经历苦痛挣扎\n[03:39.08]走吧 走吧 为自己的心找一个家\n[03:47.12]也曾伤心流泪\n[03:49.41]也曾黯然心碎\n[03:51.58]这是爱的代价\n',
        'efef0b5019c111eaad6c00163e101bf3', '1d79719d1c9311eaad6c00163e101bf3', '2019-05-01 05:24:44',
        '2020-01-04 00:29:50');
INSERT INTO `song` (`id`, `title`, `banner`, `uri`, `clicks_count`, `comments_count`, `style`, `lyric`, `user_id`,
                    `singer_id`, `created_at`, `updated_at`)
VALUES ('3', '拥抱你离去', 'assets/yong_bao_ni_de_ni_de_li_qu.jpg', 'assets/yong_bao_ni_de_ni_de_li_qu.mp3', 0, 0, 0, NULL,
        'efef0b5019c111eaad6c00163e101bf3', '0a9f66ac1c9311eaad6c00163e101bf3', '2019-05-01 05:30:50',
        '2020-01-04 00:29:50');
INSERT INTO `song` (`id`, `title`, `banner`, `uri`, `clicks_count`, `comments_count`, `style`, `lyric`, `user_id`,
                    `singer_id`, `created_at`, `updated_at`)
VALUES ('4', '一生的牵挂', 'assets/yishengdeqiangua_zengchunnian.jpg', 'assets/yishengdeqiangua_zengchunnian.mp3', 0, 0, 0,
        '[00:00.00]一生的牵挂\n[00:02.00]词曲：张海风/张耀明\n[00:04.00]编曲：廖灵光\n[00:06.00]演唱：曾春年\n[00:08.00]出品公司：东嘉娱乐\n[00:15.00]\n[00:16.52]忍着眼泪不让它流下\n[00:20.32]我害怕会把幸福融化\n[00:24.45]情绪的表达 有点复杂\n[00:28.16]请你感觉不要太惊讶\n[00:32.58]回忆它就好象一幅画\n[00:36.16]放在心里好好珍藏它\n[00:40.61]我对你的爱 从不虚假\n[00:44.20]我也需要你肯定的回答\n[00:48.38]你是我最爱的人啊\n[00:52.52]你是我一生的牵挂\n[00:56.58]心中有太多 想要对你说的话\n[01:00.16]想你知道 我有多么爱你啊\n[01:04.34]你是我最爱的人啊\n[01:08.53]你是我心中的牵挂\n[01:12.56]什么都放下 甘愿和你走天涯\n[01:16.22]相依相偎 不怕风吹雨打\n[01:19.46]做我的人吧\n[01:23.37]\n[01:26.50]监制：廖灵光\n[01:29.50]混音：刘羽伦\n[01:32.50]出品公司：东嘉娱乐\n[01:36.50]\n[01:40.41]忍着眼泪不让它流下\n[01:44.18]我害怕会把幸福融化\n[01:48.56]情绪的表达 有点复杂\n[01:52.19]请你感觉不要太惊讶\n[01:56.55]回忆它就好象一幅画\n[02:00.04]放在心里好好珍藏它\n[02:04.55]我对你的爱 从不虚假\n[02:08.08]我也需要你肯定的回答\n[02:12.47]你是我最爱的人啊\n[02:16.53]你是我一生的牵挂\n[02:20.48]心中有太多 想要对你说的话\n[02:24.20]想你知道 我有多么爱你啊\n[02:28.55]你是我最爱的人啊\n[02:32.53]你是我心中的牵挂\n[02:36.48]什么都放下 甘愿和你走天涯\n[02:40.14]相依相偎 不怕风吹雨打\n[02:43.46]做我的人吧\n[02:47.04]\n[03:20.41]你是我最爱的人啊\n[03:24.55]你是我一生的牵挂\n[03:28.47]心里有太多 想要对你说的话\n[03:32.16]想你知道 我有多么爱你啊\n[03:36.56]你是我最爱的人啊\n[03:40.53]你是我心中的牵挂\n[03:44.54]什么都放下 甘愿和你走天涯\n[03:48.11]相依相偎 不怕风吹雨打\n[03:51.57]做我的人吧\n[03:56.30]',
        'efef0b5019c111eaad6c00163e101bf3', 'f30cefcf1c9211eaad6c00163e101bf3', '2019-09-17 05:34:50',
        '2020-01-04 00:29:51');
INSERT INTO `song` (`id`, `title`, `banner`, `uri`, `clicks_count`, `comments_count`, `style`, `lyric`, `user_id`,
                    `singer_id`, `created_at`, `updated_at`)
VALUES ('5', '最痛的人', 'assets/zuitongderen_andongyang.jpg', 'assets/zuitongderen_andongyang.mp3', 0, 0, 0,
        '[00:02.45]最痛的人\n[00:04.52]作词:安东阳\n[00:06.47]作曲:安东阳\n[00:07.94]演唱:安东阳\n[00:09.95]监制:徐齐\n[00:11.48]发行:新月演艺\n[00:15.13]\n[00:21.01]我走在那个漂雨黄昏\n[00:26.21]想起一生之中最爱的人\n[00:31.23]你那迷你的眼神\n[00:33.86]和那温柔的双唇\n[00:36.67]在我脑海里浮浮沉沉\n[00:40.66]\n[00:42.30]我走在那个午夜十分\n[00:47.22]伤痛就像潮水撞击心门\n[00:52.27]爱情那么的残忍\n[00:54.95]给我太多的伤痕\n[00:57.90]我在风雨里不停追问\n[01:02.02]\n[01:03.36]我就是那个世界上\n[01:06.27]最爱你的疼你的人\n[01:10.71]为你我早已付出我的灵魂\n[01:15.94]而你却冷漠无情断了缘分\n[01:21.06]让我的爱情的路都是伤痕\n[01:26.37]我就是世界上那最痛的人\n[01:32.32]我就是那个最爱你\n[01:35.24]最疼你的伤心的人\n[01:39.55]为你我付出太多爱的天真\n[01:44.87]而你却冷漠无情断了温纯\n[01:50.44]让我的爱情的路都是泪痕\n[01:55.57]我就是世界上那最痛的人',
        'efef0b5019c111eaad6c00163e101bf3', 'a79f853e1c9211eaad6c00163e101bf3', '2019-09-17 05:40:50',
        '2020-01-04 00:29:51');
INSERT INTO `song` (`id`, `title`, `banner`, `uri`, `clicks_count`, `comments_count`, `style`, `lyric`, `user_id`,
                    `singer_id`, `created_at`, `updated_at`)
VALUES ('6', '败给爱情', 'assets/baigeianqing_zengchunnian.jpg', 'assets/baigeianqing_zengchunnian.mp3', 0, 0, 0,
        '[ti:败给爱情]\n[ar:曾春年]\n[00:00.00]\n[00:00.81]败给爱情\n[00:01.60]\n[00:02.26]作词：张海风\n[00:03.09]作曲：张海风\n[00:03.98]演唱：曾春年\n[00:04.90]推广：刘维刚 贺丽\n[00:05.85]发行：深圳市华人世代传媒有限公司\n[00:07.00]\n[00:19.68]一颗心像飘浮不定\n[00:22.95]不敢再相信爱情\n[00:26.69]寻寻觅觅中你的身影\n[00:30.62]到最后变成了泡影\n[00:33.93]\n[00:35.53]没忘记 你的眼晴\n[00:38.82]和信誓旦旦的约定\n[00:42.56]为何转过头已经\n[00:46.77]已消失人海里\n[00:49.91]\n[00:50.65]多想用力把你手拉紧\n[00:54.58]却敌不过你的无情\n[00:58.56]原谅我的眼已看不清\n[01:02.75]我败给了爱情\n[01:06.95]\n[01:08.24]原来你给我的爱情\n[01:10.88]只是冲动决定\n[01:13.00]恨我当初没看清\n[01:16.63]为何爱到最后 我还相信永久\n[01:20.55]相信你对我的感情\n[01:24.36]\n[01:24.57]原来你给我的约定\n[01:26.94]只是一场梦境\n[01:29.01]但我还不想清醒\n[01:32.57]爱你爱过了头 付出所有\n[01:36.75]你却让我败给爱情\n[01:43.58]\n[01:44.57]\n[01:57.52]没忘记 你的眼晴\n[02:00.84]和信誓旦旦的约定\n[02:04.62]为何转过头已经\n[02:08.95]已消失人海里\n[02:11.70]\n[02:12.62]多想用力把你手拉紧\n[02:16.58]却敌不过你的无情\n[02:20.54]原谅我的眼已看不清\n[02:24.75]我败给了爱情\n[02:28.67]\n[02:30.29]原来你给我的爱情\n[02:32.82]只是冲动决定\n[02:35.07]恨我当初没看清\n[02:38.60]为何爱到最后 我还相信永久\n[02:42.50]相信你对我的感情\n[02:46.32]\n[02:46.61]原来你给我的约定\n[02:48.82]只是一场梦境\n[02:50.98]但我还不想清醒\n[02:54.58]爱你爱过了头 付出所有\n[02:58.74]你却让我败给爱情\n[03:05.12]\n[03:06.32]原来你给我的爱情\n[03:08.87]只是冲动决定\n[03:11.04]恨我当初没看清\n[03:14.82]为何爱到最后 我还相信永久\n[03:18.50]相信你对我的感情\n[03:22.28]\n[03:22.69]原来你给我的约定\n[03:24.90]只是一场梦境\n[03:26.91]但我还不想清醒\n[03:30.66]爱你爱过了头 付出所有\n[03:34.68]你却让我败给爱情\n[03:41.61]\n[03:46.64]',
        'efef0b5019c111eaad6c00163e101bf3', 'f30cefcf1c9211eaad6c00163e101bf3', '2019-09-17 05:42:50',
        '2020-01-04 00:29:51');
INSERT INTO `song` (`id`, `title`, `banner`, `uri`, `clicks_count`, `comments_count`, `style`, `lyric`, `user_id`,
                    `singer_id`, `created_at`, `updated_at`)
VALUES ('7', '爱牢', 'assets/anlao_zengchunnian.jpg', 'assets/anlao_zengchunnian.mp3', 0, 0, 0,
        '[ti:爱牢]\n[ar:曾春年]\n[al:]\n[by:]\n[00:00.00]爱牢\n[00:03.00]作词：张海风/廖灵光\n[00:06.00]作曲：廖灵光/张海风\n[00:09.00]演唱：曾春年\n[00:12.00]\n[00:20.84]有过风也有过雨\n[00:24.56]从不失去爱的回忆\n[00:28.46]你的笑颜还是一样的美丽\n[00:32.27]从朋友口中听到你消息\n[00:36.63]\n[00:38.31]这些年漂泊在外的我\n[00:42.15]天天喝下想你的毒药\n[00:45.89]每一夜还是想你睡不着\n[00:49.78]你叫我怎么忘记你的好\n[00:55.08]\n[00:56.47]我爱来爱去终于知道\n[00:59.50]天长地久都不重要\n[01:01.54]你是我一生最大的期盼\n[01:05.46]心里苦又有谁知道\n[01:08.95]我逃不出你致命的爱牢\n[01:12.95]我爱来爱去终于明了\n[01:15.14]曾经拥有多么美好\n[01:17.12]你是我一生最大的遗憾\n[01:20.69]心里有太多的煎熬\n[01:24.69]爱的监牢我无处可逃\n[01:31.05]\n[01:51.87]这些年漂泊在外的我\n[01:55.56]天天喝下想你的毒药\n[01:59.44]每一夜还是想你睡不着\n[02:03.27]你叫我怎么忘记你的好\n[02:08.56]\n[02:10.15]我爱来爱去终于知道\n[02:13.13]天长地久都不重要\n[02:15.11]你是我一生最大的期盼\n[02:18.86]心里苦又有谁知道\n[02:22.58]我逃不出你致命的爱牢\n[02:26.46]我爱来爱去终于明了\n[02:28.51]曾经拥有多么美好\n[02:30.59]你是我一生最大的遗憾\n[02:34.28]心里有太多的煎熬\n[02:38.03]爱的监牢我无处可逃\n[02:43.99]\n[02:45.03]我爱来爱去终于知道\n[02:48.01]天长地久都不重要\n[02:49.91]你是我一生最大的期盼\n[02:53.72]心里苦又有谁知道\n[02:57.44]我逃不出你致命的爱牢\n[03:01.33]我爱来爱去终于明了\n[03:03.43]曾经拥有多么美好\n[03:05.44]你是我一生最大的遗憾\n[03:09.12]心里有太多的煎熬\n[03:13.06]爱的监牢我无处可逃\n[03:19.83]\n[03:24.12]爱的监牢我无处可逃\n[03:34.54]',
        'efef0b5019c111eaad6c00163e101bf3', 'f30cefcf1c9211eaad6c00163e101bf3', '2019-09-17 05:44:50',
        '2020-01-04 00:29:51');
INSERT INTO `song` (`id`, `title`, `banner`, `uri`, `clicks_count`, `comments_count`, `style`, `lyric`, `user_id`,
                    `singer_id`, `created_at`, `updated_at`)
VALUES ('8', '叫你一声老婆', 'assets/jiaoniyishenglaopo_zengchunnian.jpg', 'assets/jiaoniyishenglaopo_zengchunnian.mp3', 0, 0,
        0,
        '[ti:叫你一声老婆]\n[ar:曾春年]\n[al:]\n[by:薰风习习]\n[00:02.00]叫你一声老婆\n[00:05.00]词曲：张海风\n[00:08.00]编曲：廖灵光\n[00:11.00]演唱：曾春年\n[00:15.00]监制：张海风/廖灵光/刘羽伦\n[00:18.00]混音：刘羽伦\n[00:21.00]制作人：张海风\n[00:24.00]出品公司：东嘉娱乐\n[00:27.00]\n[00:28.50]歌词编辑：薰风习习\n[00:32.00]QQ：980920533\n[00:35.50]\n[00:37.17]当我凝神看见你浅浅的微笑\n[00:41.47]这种感觉相当的美好\n[00:45.31]每个心跳 跃动得很奇妙\n[00:49.44]是否这就是甜蜜的预告\n[00:53.98]这一刻的心情你知不知道\n[00:57.52]无限爱火在心底燃烧\n[01:01.52]我也不管 世界多么糟糕\n[01:05.66]也要给你最温暖的拥抱\n[01:10.76]我叫你一声老婆答应我好不好\n[01:15.38]从此以后我和你一起天荒地老\n[01:19.57]你有多重要 只有我心里知道\n[01:23.60]为你就算多累 也很骄傲\n[01:26.85]我叫你一声老婆答应我好不好\n[01:31.37]从此以后我给你最幸福的依靠\n[01:35.51]赋予的承诺 我都会统统做到\n[01:39.59]只需要你的一个点头 好不好\n[01:47.16]\n[02:17.65]现实的生活中各种的烦恼\n[02:21.46]有你多好就像是解药\n[02:25.42]再多郁闷 也给你融化掉\n[02:29.55]让我确定爱的人已找到\n[02:34.64]我叫你一声老婆答应我好不好\n[02:39.40]从此以后我和你一起天荒地老\n[02:43.43]你有多重要 只有我心里知道\n[02:47.57]为你就算多累 也很骄傲\n[02:50.80]我叫你一声老婆答应我好不好\n[02:55.32]从此以后我给你最幸福的依靠\n[02:59.45]赋予的承诺 我都会统统做到\n[03:03.46]只需要你的一个点头\n[03:07.09]我叫你一声老婆答应我好不好\n[03:11.35]从此以后我和你一起天荒地老\n[03:15.42]你有多重要 只有我心里知道\n[03:19.47]为你就算多累 也很骄傲\n[03:22.79]我叫你一声老婆答应我好不好\n[03:27.31]从此以后我给你最幸福的依靠\n[03:31.46]赋予的承诺 我都会统统做到\n[03:35.47]只需要你的一个点头 好不好\n[03:43.30]',
        'efef0b5019c111eaad6c00163e101bf3', 'f30cefcf1c9211eaad6c00163e101bf3', '2019-09-17 05:46:50',
        '2020-01-04 00:29:51');
INSERT INTO `song` (`id`, `title`, `banner`, `uri`, `clicks_count`, `comments_count`, `style`, `lyric`, `user_id`,
                    `singer_id`, `created_at`, `updated_at`)
VALUES ('9', '缘分惹的祸', 'assets/yuanfengredehuo_andongyang.jpg', 'assets/yuanfengredehuo_andongyang.mp3', 0, 0, 0,
        '[00:00.00]缘分惹的祸(发行版)\n[00:02.99]\n[00:06.13]作 词:安东阳\n[00:09.27]作 曲:安东阳\n[00:12.41]演 唱:安东阳\n[00:15.55]\n[00:28.11]\n[00:31.25]不要说你心里只有我\n[00:36.58]不要说这都是你的错\n[00:41.91]其实我想太多都是情路的过客\n[00:47.26]何必留下那烦恼太多\n[00:51.87]\n[00:52.61]不要说你真心爱着我\n[00:57.89]不要说这一生陪我过\n[01:03.26]别让我想太多海誓山盟的承诺\n[01:08.60]我怕泪水把自己吞没\n[01:13.27]\n[01:13.92]都是缘分惹的祸让我着了魔\n[01:19.95]情海深处无法去解脱\n[01:24.64]多想打开这这把锁\n[01:27.25]走出爱情的漩涡\n[01:29.91]多想陪你看日出日落\n[01:34.44]\n[01:35.21]都是缘分惹的祸让我受折磨\n[01:41.23]情海之中让我去漂泊\n[01:45.91]今天为你唱支歌\n[01:48.61]愿你天天都快乐\n[01:51.32]多年以后你还会记得我\n[01:56.50]\n[02:01.10]━━≡Music≡━━\n[02:15.55]\n[02:17.90]不要说你真心爱着我\n[02:23.23]不要说这一生陪我过\n[02:28.60]别让我想太多海誓山盟的承诺\n[02:33.97]我怕泪水把自己吞没\n[02:38.38]\n[02:39.26]都是缘分惹的祸让我着了魔\n[02:45.27]情海深处无法去解脱\n[02:49.94]多想打开这这把锁\n[02:52.58]走出爱情的漩涡\n[02:55.26]多想陪你看日出日落\n[02:59.23]\n[03:00.59]都是缘分惹的祸让我受折磨\n[03:06.58]情海之中让我去漂泊\n[03:11.22]今天为你唱支歌\n[03:13.94]愿你天天都快乐\n[03:16.63]多年以后你还会记得我\n[03:21.22]\n[03:21.94]都是缘分惹的祸让我着了魔\n[03:27.91]情海深处无法去解脱\n[03:32.58]多想打开这这把锁\n[03:35.20]走出爱情的漩涡\n[03:37.88]多想陪你看日出日落\n[03:42.33]\n[03:43.25]都是缘分惹的祸让我受折磨\n[03:49.21]情海之中让我去漂泊\n[03:53.89]今天为你唱支歌\n[03:56.55]愿你天天都快乐\n[03:59.25]多年以后你还会记得我\n[04:03.46]\n[04:04.53]今天为你唱支歌\n[04:07.24]愿你天天都快乐\n[04:09.94]多年以后你还会记得我\n[04:15.16]',
        'efef0b5019c111eaad6c00163e101bf3', 'a79f853e1c9211eaad6c00163e101bf3', '2019-09-17 05:48:50',
        '2020-01-04 00:29:51');

/*
-- Query: SELECT * FROM my_cloud_music_api_sp_dev.relation
LIMIT 0, 500


*/
INSERT INTO `relation` (`id`, `song_id`, `sheet_id`, `user_id`, `created_at`, `updated_at`)
VALUES ('14', '4', '1', 'efef0b5019c111eaad6c00163e101bf3', '2019-09-03 04:02:12', '2019-09-03 03:59:12');
INSERT INTO `relation` (`id`, `song_id`, `sheet_id`, `user_id`, `created_at`, `updated_at`)
VALUES ('15', '5', '1', 'efef0b5019c111eaad6c00163e101bf3', '2019-09-03 04:04:12', '2019-09-03 03:59:12');
INSERT INTO `relation` (`id`, `song_id`, `sheet_id`, `user_id`, `created_at`, `updated_at`)
VALUES ('16', '6', '1', 'efef0b5019c111eaad6c00163e101bf3', '2019-09-03 04:08:12', '2019-09-03 03:59:12');
INSERT INTO `relation` (`id`, `song_id`, `sheet_id`, `user_id`, `created_at`, `updated_at`)
VALUES ('17', '7', '1', 'efef0b5019c111eaad6c00163e101bf3', '2019-09-03 04:12:12', '2019-09-03 03:59:12');
INSERT INTO `relation` (`id`, `song_id`, `sheet_id`, `user_id`, `created_at`, `updated_at`)
VALUES ('18', '8', '1', 'efef0b5019c111eaad6c00163e101bf3', '2019-09-03 04:16:12', '2019-09-03 03:59:12');
INSERT INTO `relation` (`id`, `song_id`, `sheet_id`, `user_id`, `created_at`, `updated_at`)
VALUES ('19', '5', '9', 'efef0b5019c111eaad6c00163e101bf3', '2019-09-03 04:18:12', '2019-09-03 03:59:12');
INSERT INTO `relation` (`id`, `song_id`, `sheet_id`, `user_id`, `created_at`, `updated_at`)
VALUES ('2', '2', '1', 'efef0b5019c111eaad6c00163e101bf3', '2019-05-01 05:35:45', '2019-05-01 05:35:45');
INSERT INTO `relation` (`id`, `song_id`, `sheet_id`, `user_id`, `created_at`, `updated_at`)
VALUES ('20', '9', '9', 'efef0b5019c111eaad6c00163e101bf3', '2019-09-03 04:20:12', '2019-09-03 03:59:12');
INSERT INTO `relation` (`id`, `song_id`, `sheet_id`, `user_id`, `created_at`, `updated_at`)
VALUES ('21', '10', '9', 'efef0b5019c111eaad6c00163e101bf3', '2019-09-03 04:22:12', '2019-09-03 03:59:12');
INSERT INTO `relation` (`id`, `song_id`, `sheet_id`, `user_id`, `created_at`, `updated_at`)
VALUES ('22', '11', '9', 'efef0b5019c111eaad6c00163e101bf3', '2019-09-03 04:24:12', '2019-09-03 03:59:12');
INSERT INTO `relation` (`id`, `song_id`, `sheet_id`, `user_id`, `created_at`, `updated_at`)
VALUES ('23', '4', '10', 'efef0b5019c111eaad6c00163e101bf3', '2019-09-03 04:24:12', '2019-09-03 03:59:12');
INSERT INTO `relation` (`id`, `song_id`, `sheet_id`, `user_id`, `created_at`, `updated_at`)
VALUES ('24', '6', '10', 'efef0b5019c111eaad6c00163e101bf3', '2019-09-03 04:26:12', '2019-09-03 03:59:12');
INSERT INTO `relation` (`id`, `song_id`, `sheet_id`, `user_id`, `created_at`, `updated_at`)
VALUES ('25', '7', '10', 'efef0b5019c111eaad6c00163e101bf3', '2019-09-03 04:28:12', '2019-09-03 03:59:12');
INSERT INTO `relation` (`id`, `song_id`, `sheet_id`, `user_id`, `created_at`, `updated_at`)
VALUES ('26', '8', '10', 'efef0b5019c111eaad6c00163e101bf3', '2019-09-03 04:30:12', '2019-09-03 03:59:12');
INSERT INTO `relation` (`id`, `song_id`, `sheet_id`, `user_id`, `created_at`, `updated_at`)
VALUES ('27', '10', '1', 'efef0b5019c111eaad6c00163e101bf3', '2019-05-01 05:32:44', '2019-05-01 05:35:44');
INSERT INTO `relation` (`id`, `song_id`, `sheet_id`, `user_id`, `created_at`, `updated_at`)
VALUES ('28', '11', '1', 'efef0b5019c111eaad6c00163e101bf3', '2019-05-01 05:34:45', '2019-05-01 05:35:45');
INSERT INTO `relation` (`id`, `song_id`, `sheet_id`, `user_id`, `created_at`, `updated_at`)
VALUES ('29', '9', '1', 'efef0b5019c111eaad6c00163e101bf3', '2019-09-03 04:06:12', '2019-09-03 03:59:12');
-- INSERT INTO `relation` (`id`,`song_id`,`sheet_id`,`user_id`,`created_at`,`updated_at`) VALUES ('3','1','2','efef0b5019c111eaad6c00163e101bf3','2019-05-01 05:35:45','2019-05-01 05:35:45');
-- INSERT INTO `relation` (`id`,`song_id`,`sheet_id`,`user_id`,`created_at`,`updated_at`) VALUES ('37','1','1','efef0b5019c111eaad6c00163e101bf3','2019-11-07 05:21:02','2019-11-07 05:21:02');

/*
-- Query: SELECT * FROM my_cloud_music_api_sp_dev.video
LIMIT 0, 500


*/
INSERT INTO `video` (`id`, `title`, `clicks_count`, `likes_count`, `comments_count`, `uri`, `banner`, `duration`,
                     `user_id`, `created_at`, `updated_at`)
VALUES ('1', '一晃就老了 秋裤大叔(赵小兵) 1', 338, 0, 9, 'assets/yi_huang_jiu_lao_le.mp4', 'assets/s3.png', 36,
        'efef0b5019c111eaad6c00163e101bf3', '2019-05-01 05:35:47', '2020-01-04 00:30:57');
INSERT INTO `video` (`id`, `title`, `clicks_count`, `likes_count`, `comments_count`, `uri`, `banner`, `duration`,
                     `user_id`, `created_at`, `updated_at`)
VALUES ('2', '李宗盛《给自己的歌》Live，想得却不可得，你奈人生何2？', 178, 0, 8, 'assets/1.mp4', 'assets/s2.jpg', 56,
        'efef0b5019c111eaad6c00163e101bf3', '2019-05-01 05:35:47', '2020-01-04 00:30:57');
INSERT INTO `video` (`id`, `title`, `clicks_count`, `likes_count`, `comments_count`, `uri`, `banner`, `duration`,
                     `user_id`, `created_at`, `updated_at`)
VALUES ('3', '拥抱你离去 – 张北北3', 64, 0, 18, 'assets/yong_bao_ni_de_li_qu.mp4', 'assets/s4.png', 72,
        'efef0b5019c111eaad6c00163e101bf3', '2019-05-01 05:35:47', '2020-01-04 00:30:57');
INSERT INTO `video` (`id`, `title`, `clicks_count`, `likes_count`, `comments_count`, `uri`, `banner`, `duration`,
                     `user_id`, `created_at`, `updated_at`)
VALUES ('4', '年少不听李宗盛 听懂已是不惑年4', 39, 0, 16, 'assets/1.mp4', 'assets/s2.jpg', 112, 'efef0b5019c111eaad6c00163e101bf3',
        '2019-05-01 05:35:47', '2020-01-04 00:30:58');
INSERT INTO `video` (`id`, `title`, `clicks_count`, `likes_count`, `comments_count`, `uri`, `banner`, `duration`,
                     `user_id`, `created_at`, `updated_at`)
VALUES ('5', '李宗盛《给自己的歌》Live，想得却不可得，你奈人生何5？', 74, 0, 27, 'assets/1.mp4', 'assets/s2.jpg', 108,
        'efef0b5019c111eaad6c00163e101bf3', '2019-05-01 05:35:47', '2020-01-04 00:30:58');
INSERT INTO `video` (`id`, `title`, `clicks_count`, `likes_count`, `comments_count`, `uri`, `banner`, `duration`,
                     `user_id`, `created_at`, `updated_at`)
VALUES ('6', '年少不听李宗盛 听懂已是不惑年6', 54, 0, 24, 'assets/1.mp4', 'assets/s2.jpg', 168, 'efef0b5019c111eaad6c00163e101bf3',
        '2019-05-01 05:35:48', '2020-01-04 00:30:58');
INSERT INTO `video` (`id`, `title`, `clicks_count`, `likes_count`, `comments_count`, `uri`, `banner`, `duration`,
                     `user_id`, `created_at`, `updated_at`)
VALUES ('7', '李宗盛《给自己的歌》Live，想得却不可得，你奈人生何7？', 87, 0, 36, 'assets/1.mp4', 'assets/s2.jpg', 144,
        'efef0b5019c111eaad6c00163e101bf3', '2019-05-01 05:35:48', '2020-01-04 00:30:58');
INSERT INTO `video` (`id`, `title`, `clicks_count`, `likes_count`, `comments_count`, `uri`, `banner`, `duration`,
                     `user_id`, `created_at`, `updated_at`)
VALUES ('8', '年少不听李宗盛 听懂已是不惑年8', 66, 0, 32, 'assets/1.mp4', 'assets/s2.jpg', 224, 'efef0b5019c111eaad6c00163e101bf3',
        '2019-05-01 05:35:48', '2020-01-04 00:30:58');

/*
-- Query: SELECT * FROM my_cloud_music_api_sp_dev.comment
LIMIT 0, 500


*/
INSERT INTO `comment` (`id`, `content`, `parent_id`, `user_id`, `video_id`, `sheet_id`, `song_id`, `likes_count`,
                       `created_at`, `updated_at`)
VALUES ('1', '你好啊爱学啊 来参加这个话题吧#最向往的城市#这是评论内容', NULL, 'efef0b5019c111eaad6c00163e101bf3', NULL, '1', NULL, 2,
        '2200-04-10 00:28:49', '2200-04-10 00:28:49');
INSERT INTO `comment` (`id`, `content`, `parent_id`, `user_id`, `video_id`, `sheet_id`, `song_id`, `likes_count`,
                       `created_at`, `updated_at`)
VALUES ('2', '这是一条很长的评论，不#这是话题#看看，包含了@liwei各种特性，有话题，提醒人，例如：这是一个话题#有没有一个永远忘不掉#，有提醒人，例如：你好@liwei，还有emoji，这些都是???????。',
        NULL, 'efef0b5019c111eaad6c00163e101bf3', NULL, '1', NULL, 0, '2200-04-10 00:28:49', '2019-12-21 22:35:14');
INSERT INTO `comment` (`id`, `content`, `parent_id`, `user_id`, `video_id`, `sheet_id`, `song_id`, `likes_count`,
                       `created_at`, `updated_at`)
VALUES ('3', '这是回复一条评论，这条评论比较长长长长', '1', '2bef0b5019c111eaad6c00163e101bf3', NULL, '1', NULL, 9, '2200-04-10 00:28:49',
        '2019-12-21 23:18:32');
INSERT INTO `comment` (`id`, `content`, `parent_id`, `user_id`, `video_id`, `sheet_id`, `song_id`, `likes_count`,
                       `created_at`, `updated_at`)
VALUES ('e427014a240011eaad6c00163e101bf3', 'comment from android.', NULL, 'efef0b5019c111eaad6c00163e101bf3', NULL,
        '1', NULL, 0, '2019-12-21 22:48:03', '2020-01-04 00:26:23');

/*
-- Query: SELECT * FROM my_cloud_music_api_sp_dev.feed
LIMIT 0, 500


*/
INSERT INTO `feed` (`id`, `content`, `province`, `city`, `longitude`, `latitude`, `user_id`, `created_at`, `updated_at`)
VALUES ('1', '你好啊@smile 来参加这个话题吧@那年高中 这是动态内容,#最向往的城市# 这个话题,有图片', '四川', '成都', 23.9034450, 67.9234450,
        'efef0b5019c111eaad6c00163e101bf3', '2200-04-10 00:28:49', '2200-04-10 00:28:49');
INSERT INTO `feed` (`id`, `content`, `province`, `city`, `longitude`, `latitude`, `user_id`, `created_at`, `updated_at`)
VALUES ('2', '你好呀，我看见你发的动态了哟', '浙江', '杭州', 29.9034450, 27.9234450, 'efef0b5019c111eaad6c00163e101bf3',
        '2200-04-10 00:26:49', '2019-12-21 23:32:00');
INSERT INTO `feed` (`id`, `content`, `province`, `city`, `longitude`, `latitude`, `user_id`, `created_at`, `updated_at`)
VALUES ('3', '人生苦短，我们只做好课！', '陕西', '西安', 67.9034450, 89.9234450, 'efef0b5019c111eaad6c00163e101bf3',
        '2200-04-10 00:24:49', '2019-12-21 23:32:00');
INSERT INTO `feed` (`id`, `content`, `province`, `city`, `longitude`, `latitude`, `user_id`, `created_at`, `updated_at`)
VALUES ('3bf8918c1dac11eaad6c00163e101bf3', '爱学啊动态', '四川', '成都', 123.0094000, 34.2346000,
        'efef0b5019c111eaad6c00163e101bf3', '2019-12-13 21:26:56', '2019-12-13 21:26:56');
INSERT INTO `feed` (`id`, `content`, `province`, `city`, `longitude`, `latitude`, `user_id`, `created_at`, `updated_at`)
VALUES ('4', '学习成就更好的自己，我们是爱学啊！', NULL, NULL, NULL, NULL, 'efef0b5019c111eaad6c00163e101bf3', '2200-04-10 00:22:49',
        '2019-12-21 23:32:00');
INSERT INTO `feed` (`id`, `content`, `province`, `city`, `longitude`, `latitude`, `user_id`, `created_at`, `updated_at`)
VALUES ('4a1f5ae21dac11eaad6c00163e101bf3', '爱学啊动态2', '四川', '成都', NULL, NULL, 'efef0b5019c111eaad6c00163e101bf3',
        '2019-12-13 21:27:20', '2019-12-13 21:27:20');
INSERT INTO `feed` (`id`, `content`, `province`, `city`, `longitude`, `latitude`, `user_id`, `created_at`, `updated_at`)
VALUES ('4ed1431720d311eaad6c00163e101bf3', '爱学啊动态2', '四川', '成都', 123.0094000, 34.2346000,
        'efef0b5019c111eaad6c00163e101bf3', '2019-12-17 21:44:12', '2019-12-17 21:44:12');
INSERT INTO `feed` (`id`, `content`, `province`, `city`, `longitude`, `latitude`, `user_id`, `created_at`, `updated_at`)
VALUES ('592f01e7240611eaad6c00163e101bf3', 'feed from android', NULL, NULL, 0.0000000, 0.0000000,
        'efef0b5019c111eaad6c00163e101bf3', '2019-12-21 23:27:07', '2020-01-04 00:26:35');

/*
-- Query: SELECT * FROM my_cloud_music_api_sp_dev.resource
LIMIT 0, 500


*/
INSERT INTO `resource` (`id`, `uri`, `feed_id`, `user_id`, `created_at`, `updated_at`)
VALUES ('1', '37356726979E4275969954BC5E7EA730.jpg', '1', 'efef0b5019c111eaad6c00163e101bf3', '2019-05-01 05:35:51',
        '2019-05-01 05:35:51');
INSERT INTO `resource` (`id`, `uri`, `feed_id`, `user_id`, `created_at`, `updated_at`)
VALUES ('2', '89759B282BB84284BDB23816A20969FF.jpg', '1', 'efef0b5019c111eaad6c00163e101bf3', '2019-05-01 05:35:52',
        '2019-05-01 05:35:52');
INSERT INTO `resource` (`id`, `uri`, `feed_id`, `user_id`, `created_at`, `updated_at`)
VALUES ('3', '91B48BE2032B4FA5BC551AE75722E84A.jpg', '1', 'efef0b5019c111eaad6c00163e101bf3', '2019-05-01 05:35:52',
        '2019-05-01 05:35:52');
INSERT INTO `resource` (`id`, `uri`, `feed_id`, `user_id`, `created_at`, `updated_at`)
VALUES ('4', 'assets/4.jpg', '2', 'efef0b5019c111eaad6c00163e101bf3', '2019-05-01 05:35:52', '2019-05-01 05:35:52');
INSERT INTO `resource` (`id`, `uri`, `feed_id`, `user_id`, `created_at`, `updated_at`)
VALUES ('5', 'assets/5.jpg', '2', 'efef0b5019c111eaad6c00163e101bf3', '2019-05-01 05:35:52', '2019-05-01 05:35:52');
INSERT INTO `resource` (`id`, `uri`, `feed_id`, `user_id`, `created_at`, `updated_at`)
VALUES ('6', 'assets/6.jpg', '2', 'efef0b5019c111eaad6c00163e101bf3', '2019-05-01 05:35:53', '2019-05-01 05:35:53');
INSERT INTO `resource` (`id`, `uri`, `feed_id`, `user_id`, `created_at`, `updated_at`)
VALUES ('7', 'assets/7.jpg', '2', 'efef0b5019c111eaad6c00163e101bf3', '2019-05-01 05:35:53', '2019-05-01 05:35:53');
INSERT INTO `resource` (`id`, `uri`, `feed_id`, `user_id`, `created_at`, `updated_at`)
VALUES ('8', 'assets/11.jpg', '2', 'efef0b5019c111eaad6c00163e101bf3', '2019-05-01 05:35:53', '2019-05-01 05:35:53');

/*
-- Query: SELECT * FROM my_cloud_music_api_sp_dev.book
LIMIT 0, 500


*/
INSERT INTO `book` (`id`, `title`, `banner`, `price`, `user_id`, `created_at`, `updated_at`)
VALUES ('1', '爱学啊iOS电子书，测试商品1', 'assets/book_ios.jpg', 2.00, 'efef0b5019c111eaad6c00163e101bf3', '2019-05-01 05:35:12',
        '2019-05-01 05:35:12');
INSERT INTO `book` (`id`, `title`, `banner`, `price`, `user_id`, `created_at`, `updated_at`)
VALUES ('10', '爱学啊iOS电子书，测试商品10', 'assets/book_ios.jpg', 0.01, 'efef0b5019c111eaad6c00163e101bf3',
        '2019-05-01 05:35:12', '2019-05-01 05:35:12');
INSERT INTO `book` (`id`, `title`, `banner`, `price`, `user_id`, `created_at`, `updated_at`)
VALUES ('11', '爱学啊Android电子书，测试商品11', 'assets/book_android.jpg', 0.01, 'efef0b5019c111eaad6c00163e101bf3',
        '2019-05-01 05:35:12', '2019-05-01 05:35:12');
INSERT INTO `book` (`id`, `title`, `banner`, `price`, `user_id`, `created_at`, `updated_at`)
VALUES ('12', '爱学啊Rails电子书，测试商品12', 'assets/book_rails.jpg', 0.02, 'efef0b5019c111eaad6c00163e101bf3',
        '2019-05-01 05:35:13', '2019-05-01 05:35:13');
INSERT INTO `book` (`id`, `title`, `banner`, `price`, `user_id`, `created_at`, `updated_at`)
VALUES ('13', '爱学啊iOS电子书，测试商品13', 'assets/book_ios.jpg', 0.01, 'efef0b5019c111eaad6c00163e101bf3',
        '2019-05-01 05:35:12', '2019-05-01 05:35:12');
INSERT INTO `book` (`id`, `title`, `banner`, `price`, `user_id`, `created_at`, `updated_at`)
VALUES ('14', '爱学啊Android电子书，测试商品14', 'assets/book_android.jpg', 0.01, 'efef0b5019c111eaad6c00163e101bf3',
        '2019-05-01 05:35:12', '2019-05-01 05:35:12');
INSERT INTO `book` (`id`, `title`, `banner`, `price`, `user_id`, `created_at`, `updated_at`)
VALUES ('15', '爱学啊Rails电子书，测试商品15', 'assets/book_rails.jpg', 0.02, 'efef0b5019c111eaad6c00163e101bf3',
        '2019-05-01 05:35:13', '2019-05-01 05:35:13');
INSERT INTO `book` (`id`, `title`, `banner`, `price`, `user_id`, `created_at`, `updated_at`)
VALUES ('16', '爱学啊iOS电子书，测试商品16', 'assets/book_ios.jpg', 0.01, 'efef0b5019c111eaad6c00163e101bf3',
        '2019-05-01 05:35:12', '2019-05-01 05:35:12');
INSERT INTO `book` (`id`, `title`, `banner`, `price`, `user_id`, `created_at`, `updated_at`)
VALUES ('17', '爱学啊Android电子书，测试商品17', 'assets/book_android.jpg', 0.01, 'efef0b5019c111eaad6c00163e101bf3',
        '2019-05-01 05:35:12', '2019-05-01 05:35:12');
INSERT INTO `book` (`id`, `title`, `banner`, `price`, `user_id`, `created_at`, `updated_at`)
VALUES ('18', '爱学啊Rails电子书，测试商品18', 'assets/book_rails.jpg', 0.02, 'efef0b5019c111eaad6c00163e101bf3',
        '2019-05-01 05:35:13', '2019-05-01 05:35:13');
INSERT INTO `book` (`id`, `title`, `banner`, `price`, `user_id`, `created_at`, `updated_at`)
VALUES ('19', '爱学啊iOS电子书，测试商品19', 'assets/book_ios.jpg', 0.01, 'efef0b5019c111eaad6c00163e101bf3',
        '2019-05-01 05:35:12', '2019-05-01 05:35:12');
INSERT INTO `book` (`id`, `title`, `banner`, `price`, `user_id`, `created_at`, `updated_at`)
VALUES ('2', '爱学啊Android电子书，测试商品2', 'assets/book_android.jpg', 0.01, 'efef0b5019c111eaad6c00163e101bf3',
        '2019-05-01 05:35:12', '2019-05-01 05:35:12');
INSERT INTO `book` (`id`, `title`, `banner`, `price`, `user_id`, `created_at`, `updated_at`)
VALUES ('20', '爱学啊Android电子书，测试商品20', 'assets/book_android.jpg', 0.01, 'efef0b5019c111eaad6c00163e101bf3',
        '2019-05-01 05:35:12', '2019-05-01 05:35:12');
INSERT INTO `book` (`id`, `title`, `banner`, `price`, `user_id`, `created_at`, `updated_at`)
VALUES ('21', '爱学啊Rails电子书，测试商品21', 'assets/book_rails.jpg', 0.02, 'efef0b5019c111eaad6c00163e101bf3',
        '2019-05-01 05:35:13', '2019-05-01 05:35:13');
INSERT INTO `book` (`id`, `title`, `banner`, `price`, `user_id`, `created_at`, `updated_at`)
VALUES ('22', '爱学啊iOS电子书，测试商品22', 'assets/book_ios.jpg', 0.01, 'efef0b5019c111eaad6c00163e101bf3',
        '2019-05-01 05:35:12', '2019-05-01 05:35:12');
INSERT INTO `book` (`id`, `title`, `banner`, `price`, `user_id`, `created_at`, `updated_at`)
VALUES ('23', '爱学啊Android电子书，测试商品23', 'assets/book_android.jpg', 0.01, 'efef0b5019c111eaad6c00163e101bf3',
        '2019-05-01 05:35:12', '2019-05-01 05:35:12');
INSERT INTO `book` (`id`, `title`, `banner`, `price`, `user_id`, `created_at`, `updated_at`)
VALUES ('24', '爱学啊Rails电子书，测试商品24', 'assets/book_rails.jpg', 0.02, 'efef0b5019c111eaad6c00163e101bf3',
        '2019-05-01 05:35:13', '2019-05-01 05:35:13');
INSERT INTO `book` (`id`, `title`, `banner`, `price`, `user_id`, `created_at`, `updated_at`)
VALUES ('25', '爱学啊iOS电子书，测试商品25', 'assets/book_ios.jpg', 0.01, 'efef0b5019c111eaad6c00163e101bf3',
        '2019-05-01 05:35:12', '2019-05-01 05:35:12');
INSERT INTO `book` (`id`, `title`, `banner`, `price`, `user_id`, `created_at`, `updated_at`)
VALUES ('26', '爱学啊Android电子书，测试商品26', 'assets/book_android.jpg', 0.01, 'efef0b5019c111eaad6c00163e101bf3',
        '2019-05-01 05:35:12', '2019-05-01 05:35:12');
INSERT INTO `book` (`id`, `title`, `banner`, `price`, `user_id`, `created_at`, `updated_at`)
VALUES ('27', '爱学啊Rails电子书，测试商品27', 'assets/book_rails.jpg', 0.02, 'efef0b5019c111eaad6c00163e101bf3',
        '2019-05-01 05:35:13', '2019-05-01 05:35:13');
INSERT INTO `book` (`id`, `title`, `banner`, `price`, `user_id`, `created_at`, `updated_at`)
VALUES ('28', '爱学啊iOS电子书，测试商品28', 'assets/book_ios.jpg', 0.01, 'efef0b5019c111eaad6c00163e101bf3',
        '2019-05-01 05:35:12', '2019-05-01 05:35:12');
INSERT INTO `book` (`id`, `title`, `banner`, `price`, `user_id`, `created_at`, `updated_at`)
VALUES ('29', '爱学啊Android电子书，测试商品29', 'assets/book_android.jpg', 0.01, 'efef0b5019c111eaad6c00163e101bf3',
        '2019-05-01 05:35:12', '2019-05-01 05:35:12');
INSERT INTO `book` (`id`, `title`, `banner`, `price`, `user_id`, `created_at`, `updated_at`)
VALUES ('3', '爱学啊Rails电子书，测试商品3', 'assets/book_rails.jpg', 3.00, 'efef0b5019c111eaad6c00163e101bf3',
        '2019-05-01 05:35:13', '2019-05-01 05:35:13');
INSERT INTO `book` (`id`, `title`, `banner`, `price`, `user_id`, `created_at`, `updated_at`)
VALUES ('30', '爱学啊Rails电子书，测试商品30', 'assets/book_rails.jpg', 0.02, 'efef0b5019c111eaad6c00163e101bf3',
        '2019-05-01 05:35:13', '2019-05-01 05:35:13');
INSERT INTO `book` (`id`, `title`, `banner`, `price`, `user_id`, `created_at`, `updated_at`)
VALUES ('31', '爱学啊iOS电子书，测试商品31', 'assets/book_ios.jpg', 0.01, 'efef0b5019c111eaad6c00163e101bf3',
        '2019-05-01 05:35:12', '2019-05-01 05:35:12');
INSERT INTO `book` (`id`, `title`, `banner`, `price`, `user_id`, `created_at`, `updated_at`)
VALUES ('32', '爱学啊Android电子书，测试商品32', 'assets/book_android.jpg', 0.01, 'efef0b5019c111eaad6c00163e101bf3',
        '2019-05-01 05:35:12', '2019-05-01 05:35:12');
INSERT INTO `book` (`id`, `title`, `banner`, `price`, `user_id`, `created_at`, `updated_at`)
VALUES ('33', '爱学啊Rails电子书，测试商品33', 'assets/book_rails.jpg', 0.02, 'efef0b5019c111eaad6c00163e101bf3',
        '2019-05-01 05:35:13', '2019-05-01 05:35:13');
INSERT INTO `book` (`id`, `title`, `banner`, `price`, `user_id`, `created_at`, `updated_at`)
VALUES ('4', '爱学啊iOS电子书，测试商品4', 'assets/book_ios.jpg', 0.01, 'efef0b5019c111eaad6c00163e101bf3', '2019-05-01 05:35:12',
        '2019-05-01 05:35:12');
INSERT INTO `book` (`id`, `title`, `banner`, `price`, `user_id`, `created_at`, `updated_at`)
VALUES ('5', '爱学啊Android电子书，测试商品5', 'assets/book_android.jpg', 0.01, 'efef0b5019c111eaad6c00163e101bf3',
        '2019-05-01 05:35:12', '2019-05-01 05:35:12');
INSERT INTO `book` (`id`, `title`, `banner`, `price`, `user_id`, `created_at`, `updated_at`)
VALUES ('6', '爱学啊Rails电子书，测试商品6', 'assets/book_rails.jpg', 0.02, 'efef0b5019c111eaad6c00163e101bf3',
        '2019-05-01 05:35:13', '2019-05-01 05:35:13');
INSERT INTO `book` (`id`, `title`, `banner`, `price`, `user_id`, `created_at`, `updated_at`)
VALUES ('7', '爱学啊iOS电子书，测试商品7', 'assets/book_ios.jpg', 0.01, 'efef0b5019c111eaad6c00163e101bf3', '2019-05-01 05:35:12',
        '2019-05-01 05:35:12');
INSERT INTO `book` (`id`, `title`, `banner`, `price`, `user_id`, `created_at`, `updated_at`)
VALUES ('8', '爱学啊Android电子书，测试商品8', 'assets/book_android.jpg', 0.01, 'efef0b5019c111eaad6c00163e101bf3',
        '2019-05-01 05:35:12', '2019-05-01 05:35:12');
INSERT INTO `book` (`id`, `title`, `banner`, `price`, `user_id`, `created_at`, `updated_at`)
VALUES ('9', '爱学啊Rails电子书，测试商品9', 'assets/book_rails.jpg', 0.02, 'efef0b5019c111eaad6c00163e101bf3',
        '2019-05-01 05:35:13', '2019-05-01 05:35:13');

/*
-- Query: SELECT * FROM my_cloud_music_api_sp_dev.topic
LIMIT 0, 500


*/
INSERT INTO `topic` (`id`, `title`, `banner`, `description`, `joins_count`, `user_id`, `created_at`, `updated_at`)
VALUES ('1', '最向往的城市', 'assets/list1.jpg', '来谈谈你最向往的城市吧！', 23, 'efef0b5019c111eaad6c00163e101bf3',
        '2019-05-01 05:35:45', '2019-05-01 05:35:45');
INSERT INTO `topic` (`id`, `title`, `banner`, `description`, `joins_count`, `user_id`, `created_at`, `updated_at`)
VALUES ('2', '电影教会你的人生道理', 'assets/list2.jpg', '电影教会你的人生道理', 36, 'efef0b5019c111eaad6c00163e101bf3',
        '2019-05-01 05:35:46', '2019-05-01 05:35:46');
INSERT INTO `topic` (`id`, `title`, `banner`, `description`, `joins_count`, `user_id`, `created_at`, `updated_at`)
VALUES ('3', '理想的工作', 'assets/list3.jpg', '来谈谈你最向往的城市吧！', 9, 'efef0b5019c111eaad6c00163e101bf3', '2019-05-01 05:35:46',
        '2019-05-01 05:35:46');
INSERT INTO `topic` (`id`, `title`, `banner`, `description`, `joins_count`, `user_id`, `created_at`, `updated_at`)
VALUES ('4', '曾经爱过的人', 'assets/list4.jpg', '来谈谈你最向往的城市吧！', 10, 'efef0b5019c111eaad6c00163e101bf3',
        '2019-05-01 05:35:46', '2019-05-01 05:35:46');
INSERT INTO `topic` (`id`, `title`, `banner`, `description`, `joins_count`, `user_id`, `created_at`, `updated_at`)
VALUES ('5', '有没有一个永远忘不掉的人', 'assets/list5.jpg', '有没有一个永远忘不掉的人！', 8, 'efef0b5019c111eaad6c00163e101bf3',
        '2019-05-01 05:35:46', '2019-05-01 05:35:46');
INSERT INTO `topic` (`id`, `title`, `banner`, `description`, `joins_count`, `user_id`, `created_at`, `updated_at`)
VALUES ('6', '人生苦短，我们只做好课', 'assets/list6.jpg', '人生苦短，我们只做好课！', 8, 'efef0b5019c111eaad6c00163e101bf3',
        '2019-05-01 05:35:46', '2019-05-01 05:35:46');
