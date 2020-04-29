package com.example.mycloudmusicapi.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 通用点击数、点赞数等映射
 */
@Repository
public interface CommonMapper {

    /**
     * 增加数量，动态SQL
     * @param table 表名
     * @param id id
     * @param filed 字段
     * @return
     */
    int increment(@Param("table") String table,@Param("id") String id,@Param("filed") String filed);

    int decrement(@Param("table") String table,@Param("id") String id,@Param("filed") String filed);

}
