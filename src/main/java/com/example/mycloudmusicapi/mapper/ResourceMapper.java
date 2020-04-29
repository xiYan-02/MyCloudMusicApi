package com.example.mycloudmusicapi.mapper;

import com.example.mycloudmusicapi.domain.Resource;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 资源表映射
 */
@Repository
public interface ResourceMapper {

    /**
     * 将资源添加到数据库
     * @param res
     * @return
     */
    int create(@Param("res") List<Resource> res,@Param("feedId")String feedId,@Param("userId")String userId);

}
