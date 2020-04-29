package com.example.mycloudmusicapi.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {
    private static ObjectMapper mapper = new ObjectMapper();

    /**
     * 将一个普通的对象转为json对象
     * @param con
     * @return
     */
    public static Object stringtoJson(Object con){
        if(con == null){
            return null;
        }
        String ss = null;
        try {
            ss = mapper.writeValueAsString(con);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return ss;
    }


}
