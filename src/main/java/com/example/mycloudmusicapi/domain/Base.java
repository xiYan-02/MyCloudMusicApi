package com.example.mycloudmusicapi.domain;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.io.Serializable;

/**
 * 继承Serializable实现序列化
 *
 * 便于存储
 * 便于传输
 */
//整个实体返回的json字段格式转换为下划线格式，同时传递过来的json也必须时这种格式
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Base implements Serializable  {
}
