package com.example.mycloudmusicapi.mapper;

import com.example.mycloudmusicapi.domain.Collection;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 收藏歌单映射
 */
@Repository
public interface CollectionMapper {

    int create(@Param("userId") String userId,@Param("sheetId") String sheetId);

    Collection findByUserIdAndSheetId(@Param("userId") String userId, @Param("sheetId") String sheetId);

    int destroy(@Param("userId") String userId,@Param("sheetId") String sheetId);
}
