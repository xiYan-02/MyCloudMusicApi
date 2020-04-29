package com.example.mycloudmusicapi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
//开启事务
@EnableTransactionManagement
//@MapperScan:关联mapper存放的位置
@MapperScan("com.example.mycloudmusicapi.mapper")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
