package com.example.mycloudmusicapi.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.sql.Date;
import java.sql.Timestamp;

@Data
public class Common extends Base{

    /**
     * 数据ID
     */
    @ApiModelProperty(value = "数据ID")
    private String id;

    /**
     * 创建时间
     *
     * 通过MySQL机制去更新
     */
    @ApiModelProperty(value = "创建时间 通过MySQL机制去更新")
    private Timestamp createdAt;

    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间")
    private Date updatedAt;

}
