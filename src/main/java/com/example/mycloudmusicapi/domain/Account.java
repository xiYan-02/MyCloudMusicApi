package com.example.mycloudmusicapi.domain;

import lombok.Data;

/**
 * 第三方登录实体类
 */
@Data
public class Account extends Base {

    /**
     * 平台，如20为qq，30位微博
     */
    private Integer platform;

    /**
     * 第三方登录后的id
     */
    private String account;

}
