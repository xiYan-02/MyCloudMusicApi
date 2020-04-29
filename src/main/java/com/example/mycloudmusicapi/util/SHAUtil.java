package com.example.mycloudmusicapi.util;

import org.apache.commons.codec.digest.DigestUtils;

public class SHAUtil {

    /**
     * sha1加密
     * @param data
     * @return
     */
    public static String sha1(String data){
//        加盐
        data = BCryptUtil.format(data);
//        加密
        return DigestUtils.sha1Hex(data);
    }


}
