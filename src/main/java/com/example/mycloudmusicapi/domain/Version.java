package com.example.mycloudmusicapi.domain;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@Data   //要加get、set方法才可以访问到
public class Version extends Base{
    @Value("${application.code}")
    private int code;
    @Value("${application.name}")
    private String name;

    @Override
    public String toString() {
        return "Version{" +
                "code=" + code +
                ", name='" + name + '\'' +
                '}';
    }
}
