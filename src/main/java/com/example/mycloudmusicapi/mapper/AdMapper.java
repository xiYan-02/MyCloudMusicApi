package com.example.mycloudmusicapi.mapper;

import com.example.mycloudmusicapi.domain.Ad;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 广告映射
 */
@Repository
public interface AdMapper {

    /**
     * 创建广告
     * @param ad
     * @return
     */
    int create(Ad ad);

    /**
     * 查询所有广告
     * @return
     */
    List<Ad> findAll();

    /**
     * 根据id查询广告
     * @param id
     * @return
     */
    Ad find(String id);

    /**
     * 更新广告
     * @param data
     * @return
     */
    int update(Ad data);

    /**
     * 删除广告
     * @param id
     * @return
     */
    int delete(String id);
}
