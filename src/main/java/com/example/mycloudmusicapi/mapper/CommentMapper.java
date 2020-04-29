package com.example.mycloudmusicapi.mapper;

import com.example.mycloudmusicapi.domain.Comment;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 评论映射接口
 */
@Repository
public interface CommentMapper {

    int create(Comment data);

    List<Comment> findAll(@Param("filed") String filed,@Param("map") Map<String,String> map);
}
