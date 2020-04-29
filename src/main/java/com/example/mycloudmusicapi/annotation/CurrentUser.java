package com.example.mycloudmusicapi.annotation;

import java.lang.annotation.*;

/**
 * 在Controller方法的参数前使用该注解，会自动注入当前用户
 */
@Documented
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface CurrentUser {

}
