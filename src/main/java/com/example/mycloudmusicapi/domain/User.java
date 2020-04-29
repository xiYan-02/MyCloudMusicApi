package com.example.mycloudmusicapi.domain;

import com.example.mycloudmusicapi.util.BCryptUtil;
import com.example.mycloudmusicapi.util.SHAUtil;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.sql.Timestamp;


@ApiModel(value = "用户信息")
@Data
public class User extends Common {

//    对部分用户数据加密
    public void encryptData(){
//        加密密码
        this.password = BCryptUtil.encrypt(this.password);

//        有qqid的话就加密

//            qq_id：对qq进行sha1加密
//            qq_id_digest：对qq进行BCrypt加密，
//            判断的时候你只要根据sha1(qq)从数据库中拿到qq_id_digest，然后把这个digest和传过来的qq进行对比即可
        if(!StringUtils.isBlank(this.qqId)){
//            注意先后顺序
            this.qqIdDigest = BCryptUtil.encrypt(this.qqId);
            this.qqId = SHAUtil.sha1(this.qqId);
        }
//        有微博就加密
        if(!StringUtils.isBlank(this.weiboId)){
            this.weiboIdDigest = BCryptUtil.encrypt(this.weiboId);
            this.weiboId = SHAUtil.sha1(this.weiboId);
        }

        //        有微信就加密
        if(!StringUtils.isBlank(this.wechatId)){
            this.wechatIdDigest = BCryptUtil.encrypt(this.wechatId);
            this.wechatId = SHAUtil.sha1(this.wechatId);
        }

    }

    /**
     * 昵称，不能为空
     * 长度为1~30
     */
    @ApiModelProperty(value = "昵称，不能为空，长度为1~15")
    @NotBlank(message = "昵称不能为空")
    @Length(min = 1,max = 15,message = "昵称应在1~15位之间")
    private String nickname;

    /**
     * 头像
     */
    @ApiModelProperty(value = "头像")
    private String avatar;

    /**
     * 描述
     */
    @ApiModelProperty(value = "描述")
    private String description;

    /**
     * 性别
     * 不能为空
     * 默认为0：保密；1：男；2：女
     */
    @ApiModelProperty(value = "性别：默认为0：保密；1：男；2：女")
    private Integer gender;

    /**
     * 出生日志
     * 格式为yyyy-MM-dd格式
     */
    @ApiModelProperty(value = "出生日志，格式为yyyy-MM-dd格式")
    private String birthday;

    /**
     * 邮箱
     * 不能为空
     */
    @NotBlank(message = "邮箱不能为空")
    @Email(message = "邮箱格式有误")
    @ApiModelProperty(value = "邮箱 不能为空")
    private String email;

    /**
     * 手机号
     * <p>
     * 不能为空
     */
    @NotBlank(message = "手机号不能为空")
    @Pattern(regexp = "^(13[0-9]|14[579]|15[0-3,5-9]|16[6]|17[0135678]|18[0-9]|19[89])\\d{8}$", message = "手机号格式有误")
    @ApiModelProperty(value = "手机号 不能为空")
    private String phone;

    /**
     * 省
     */
    @ApiModelProperty(value = "省")
    private String province;

    /**
     * 省编码
     */
    @ApiModelProperty(value = "省编码")
    private String provinceCode;

    /**
     * 市
     */
    @ApiModelProperty(value = "市")
    private String city;

    /**
     * 市编码
     */
    @ApiModelProperty(value = "市编码")
    private String cityCode;

    /**
     * 区
     */
    @ApiModelProperty(value = "区")
    private String area;

    /**
     * 区编码
     */
    @ApiModelProperty(value = "区编码")
    private String areaCode;

    /**
     * 密码
     */
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ApiModelProperty(value = "密码")
    private String password;

    /**
     * 用户登录后的token
     */
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ApiModelProperty(value = "用户登录后的token")
    private String sessionDigest;

    /**
     * 邮箱确认token
     */
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ApiModelProperty(value = "邮箱确认token")
    private String confirmationDigest;

    /**
     * 邮箱确认时间
     */
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ApiModelProperty(value = "邮箱确认时间")
    private Timestamp confirmedAt;

    /**
     * 邮箱确认链接发送时间
     */
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ApiModelProperty(value = "邮箱确认链接发送时间")
    private Timestamp confirmationSendAt;

    /**
     * 第三方登录QQid，使用sha1算法计算签名
     */
    @ApiModelProperty(value = "第三方登录QQid，使用sha1算法计算签名")
    private String qqId;

    /**
     * 第三方登录QQid加密后值，bcrypt算法加密
     */
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ApiModelProperty(value = "第三方登录QQid加密后值，bcrypt算法加密")
    private String qqIdDigest;

    /**
     * 第三方登录微信id，使用sha1算法计算签名
     */
    @ApiModelProperty(value = "第三方登录微信id，使用sha1算法计算签名")
    private String wechatId;

    /**
     * 第三方登录微信id加密后值，bcrypt算法加密
     */
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ApiModelProperty(value = "第三方登录微信id加密后值，bcrypt算法加密")
    private String wechatIdDigest;

    /**
     * 第三方登录微博id，使用sha1算法计算签名
     */
    @ApiModelProperty(value = "第三方登录微博id，使用sha1算法计算签名")
    private String weiboId;

    /**
     * 第三方登录微博id加密后值，bcrypt算法加密
     */
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ApiModelProperty(value = "第三方登录微博id加密后值，bcrypt算法加密")
    private String weiboIdDigest;

    /**
     * 验证码字段
     * <p>
     * md5签名
     */
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ApiModelProperty(value = "验证码字段 md5签名")
    private String code;

    /**
     * 验证码发送时间
     */
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ApiModelProperty(value = "验证码发送时间")
    private Timestamp codeSendAt;

    /**
     * 是否关注，在查看用户详情的时候用到
     */
    private Integer following;

}
