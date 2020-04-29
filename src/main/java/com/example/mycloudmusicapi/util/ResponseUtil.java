package com.example.mycloudmusicapi.util;

import com.example.mycloudmusicapi.response.PageData;
import com.example.mycloudmusicapi.response.Response;

import java.util.List;

public class ResponseUtil {

    /**
     * 包装对象
     * 可能是失败响应
     *
     * @param data
     * @return
     */
    public static Object wrap(Object data) {
        if (data instanceof List) {
            //没有分页包裹
            //就对列表包裹
            data = PageData.init(data);
        }

        data = new Response(data);

        return data;
    }

}
