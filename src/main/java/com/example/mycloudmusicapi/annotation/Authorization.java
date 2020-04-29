package com.example.mycloudmusicapi.annotation;

import java.lang.annotation.*;

/**
 * @Documented:该注解是否可以生成到 API文档中。
 * @Retention:这种类型的Annotations将被JVM保留,所以他们能在运行时被JVM或其他使用反射机制的代码所读取和使用
 * @Target:可以使用该注解的类型
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Authorization {

}
