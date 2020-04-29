package com.example.mycloudmusicapi.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptUtil {


    /**
     * 加密
     *
     * @param data
     * @return
     */
    public static String encrypt(String data) {
//        加盐
        data = format(data);
//        加密
        return getEncoder().encode(data);
    }

    /**
     * 是否匹配
     *
     * @param raw    未加密的数据
     * @param encode 加密后的数据
     * @return
     */
    public static boolean matchEncode(String raw, String encode) {
//        先对未加密的字符串进行加盐
        raw = format(raw);
//        调用BCryptPasswordEncoder中的比较方法
//        会自动给你把加密后的字符串解密后再进行比较
        return getEncoder().matches(raw,encode);
    }

    /**
     * 获取密码加密器
     * @return
     */
    public static BCryptPasswordEncoder getEncoder(){
        return new BCryptPasswordEncoder();
    }


    /**
     * 加盐
     * @param data 未加盐的字符串
     * @return  返回加盐后的字符串
     */
    public static String format(String data){
        return String.format(Constant.FORMAT_SALT,data);
    }

}
