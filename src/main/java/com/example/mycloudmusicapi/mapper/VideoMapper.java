package com.example.mycloudmusicapi.mapper;

import com.example.mycloudmusicapi.domain.Video;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 视频相关接口映射
 */
@Repository
public interface VideoMapper {
    List<Video> findAll();

    Video findById(String id);
}
