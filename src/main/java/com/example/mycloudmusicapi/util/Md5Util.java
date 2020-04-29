package com.example.mycloudmusicapi.util;

import org.springframework.util.DigestUtils;

/**
 * md5工具类
 */
public class Md5Util {
    /**
     * md5签名
     * @param data
     * @return
     */
    public static String encrypt(String data) {
        //org.springframework.util
        return DigestUtils.md5DigestAsHex(data.getBytes());
    }
}
