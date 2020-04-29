package com.example.mycloudmusicapi.mapper;

import com.example.mycloudmusicapi.domain.Friend;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 粉丝/好友映射
 */
@Repository
public interface FriendMapper {

    /**
     * 关注用户
     * @param friend
     * @return
     */
    int create(Friend friend);

    /**
     * 取消关注用户
     * @param other_id 对方用户id
     * @param currentId 当前用户id
     */
    void destroy(@Param("other_id") String other_id,@Param("currentId") String currentId);

    /**
     * 判断是否存在
     * @param other_id
     * @param currentId
     * @return
     */
    int getCountByFollowerAndFollowed(@Param("other_id") String other_id,@Param("currentId") String currentId);
}
