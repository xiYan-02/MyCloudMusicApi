package com.example.mycloudmusicapi.config;

import com.example.mycloudmusicapi.interceptor.AuthorizationInterceptor;
import com.example.mycloudmusicapi.resolver.CurrentUserArgumentResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * WebMvc配置类
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    private AuthorizationInterceptor authorizationInterceptor;

    @Autowired
    private CurrentUserArgumentResolver currentUserArgumentResolver;

//    添加拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        多个拦截器组成一个拦截器类
//        addPathPatterns 用于添加拦截规则
//        excludePathPatterns 用于排除拦截规则
        registry.addInterceptor(authorizationInterceptor)
        .addPathPatterns("/**");//表示拦截所有的接口，"/v1/**" --> 表示只拦截v1下面的所有接口
    }

//    添加参数解析器
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(currentUserArgumentResolver);
    }
}
