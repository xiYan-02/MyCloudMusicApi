package com.example.mycloudmusicapi.config;


import com.example.mycloudmusicapi.interceptor.AuthorizationInterceptor;
import com.example.mycloudmusicapi.resolver.CurrentUserArgumentResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;

/**
 * bean相关配置，主要用来注入bean层
 */
@Configuration
public class BeanConfig {

    @Bean
    AuthorizationInterceptor authorizationInterceptor(){
        return new AuthorizationInterceptor();
    }

    @Bean
    CurrentUserArgumentResolver currentUserArgumentResolver(){
        return new CurrentUserArgumentResolver();
    }


}
