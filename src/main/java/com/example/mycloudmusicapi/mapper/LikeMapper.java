package com.example.mycloudmusicapi.mapper;

import com.example.mycloudmusicapi.domain.Like;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 评论点赞映射
 */
@Repository
public interface LikeMapper {

    int create(Like like);

    int destroy(@Param("id")String id,@Param("userId")String userId);

    int getCount(@Param("id")String id,@Param("userId")String userId);

    Like findByCommentIdAndUserId(@Param("commentId") String commentId,@Param("userId") String userId);
}
