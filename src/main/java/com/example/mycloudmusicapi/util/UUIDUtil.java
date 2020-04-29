package com.example.mycloudmusicapi.util;

import java.util.UUID;

public class UUIDUtil {

    public static String getUUID(){
        String uuid = UUID.randomUUID().toString();
//        去除uuid中生成的-
        return uuid.replace("-","");
    }

}
