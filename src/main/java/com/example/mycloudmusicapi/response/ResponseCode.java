package com.example.mycloudmusicapi.response;

public enum  ResponseCode {

    SUCCESS(0,"OK"),

    SYSTEM_ERROR(1000,"系统异常，请稍后重试"),
    PARAM_IS_INVALID(1010,"参数无效"),
    EXIT_ERROR(1020,"退出登录失败，请稍后再试！"),
    UPDATE_FILED(1030,"更新数据失败，请稍后再试！"),
    ERROR_SEND_MAIL(1040,"发送邮件失败，请稍后再试"),
    ERROR_TOO_FAST(1040,"发送验证码时间间隔少于60秒"),
    ERROR_CODE(1050,"验证码错误"),
    ERROR_CODE_OUTTIME(1050,"验证码已过期，请重新发送"),
    ERROR_PWD_ALIGN(1060,"新密码不能和旧密码相同"),
    COLLECTION_HAS(1070,"该歌单已经被收藏了哦"),
    USER_NOT_FIND(2000,"用户不存在"),
    USER_HAS_EXISTED(2010,"数据已存在"),
    USER_HAS_PHONE(2020,"该手机号已注册"),
    USER_HAS_EMAIL(2030,"该邮箱已注册"),
    USER_HAS_QQID(2040,"该QQ已注册"),
    USER_HAS_WEIBOID(2050,"该微博已注册"),
    USER_HAS_WECHATID(2060,"该微信已注册"),
    ADD_EXCEPTION(2070,"注册失败，请稍后再试"),
    RELATION_HAS(2080,"歌曲已存在该歌单中,请勿重复添加"),
    PWD_ERROR(2100,"账号或密码有误！"),
    LOGIN_FILED(2110,"登录失败！"),
    HAS_SEND_MAIL(2120,"邮箱已验证，请勿重复操作"),
    HAS_LIKES(2130,"你已经点赞了哦"),
    USER_HAS_FOLLOWER(2140,"你已经关注他了哦"),
    AD_NOT_EXITS(3000,"该广告不存在"),
    SHEET_NOT_EXIT(3010,"该歌单不存在"),
    SONG_NOT_EXITS(3020,"该歌曲不存在"),
    RELATION_NOT_SONG(3030,"歌单中不存在该歌曲"),
    COLLECTION_NOT_HAS(3040,"您还没有收藏该歌单哦"),
    VIDEO_NOT_HAS(3050,"没有找到该视频资源"),
    USER_NOT_FOLLOWER(2060,"你还没有关注他哦"),
    NOT_FOND(4000,"您访问的资源不存在"),
    NOT_POWER(4010,"您没有操作权限");
    private int code;
    private String message;

    ResponseCode(Integer code,String message){
        this.code = code;
        this.message = message;
    }

    public int code(){
        return this.code;
    }

    public String message(){
        return this.message;
    }

}
