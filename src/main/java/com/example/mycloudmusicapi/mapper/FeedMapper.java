package com.example.mycloudmusicapi.mapper;

import com.example.mycloudmusicapi.domain.Feed;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 动态相关映射
 */
@Repository
public interface FeedMapper {

    int created(Feed feed);

    List<Feed> findAll();
}
