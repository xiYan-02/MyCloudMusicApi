package com.example.mycloudmusicapi.advice;

import com.example.mycloudmusicapi.response.Response;
import com.example.mycloudmusicapi.response.ResponseCode;
import com.example.mycloudmusicapi.util.JsonUtil;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * 全局返回对象封装
 */
@ControllerAdvice(basePackages = "com.example.mycloudmusicapi")
public class ResponseAdvice implements ResponseBodyAdvice {


    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
       if(body instanceof Response){
           return body;
       }else  if(body instanceof String){
            return JsonUtil.stringtoJson(Response.success(body));
       }else if(body == null){
           return Response.filaed(ResponseCode.NOT_FOND);
       }
        return Response.success(body);
    }
}
