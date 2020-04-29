package com.example.mycloudmusicapi.interceptor;

import com.example.mycloudmusicapi.annotation.Authorization;
import com.example.mycloudmusicapi.domain.User;
import com.example.mycloudmusicapi.service.SessionService;
import com.example.mycloudmusicapi.util.Constant;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * 处理Authorization注解--拦截器
 */
@Slf4j
public class AuthorizationInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private SessionService sessionService;
    /**
     * 在执行@Authorization注解的方法执行之前执行
     * @param request
     * @param response
     * @param handler
     * @return 返回true：表示不拦截，被@Authorization注解标注的方法可以正常执行，返回false：表示拦截本次请求，被标注的方法则不执行
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//      判断是否为方法拦截
        if(!(handler instanceof HandlerMethod)){
            return true;
        }

//        判断在方法上是否标注了@Authorization注解
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        if(method.getAnnotation(Authorization.class) == null){
            return true;
        }

        try {
//        获取传递的请求头，判断是否认证成功
            String userId = request.getHeader(Constant.USER);
            String authorization  = request.getHeader(Constant.AUTHORIZATION);
//        判断是否有请求头
            if(StringUtils.isNotBlank(userId) && StringUtils.isNotBlank(authorization)){
    //            检查是否正确
                User data = sessionService.checkSession(userId,authorization);
    //            认证成功，可以进行后续操作
                if(data != null){
    //                将此次的data进行缓存，避免每次都重复请求数据库
                    request.setAttribute(Constant.CURRENT_USER,data);
                    return true;
                }
            }
        } catch (Exception e) {
//            发生异常，打印错误信息
            log.error("proHandle: {}",e);
        }

        //设置响应码为401
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

        return false;
    }
}
