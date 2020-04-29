package com.example.mycloudmusicapi.util;

public class RandomUtil {

    /**
     * 生成四位数验证码
     * @return
     */
    public static int Int4() {
//        Math.random() 产生0-1之间的随机数
        return (int) ((Math.random() * 9 + 1)*1000);
    }
}
