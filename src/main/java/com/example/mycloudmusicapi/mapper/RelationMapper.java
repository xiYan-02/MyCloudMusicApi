package com.example.mycloudmusicapi.mapper;

import com.example.mycloudmusicapi.domain.Relation;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RelationMapper {

    /**
     * 往歌单中添加歌曲
     * @param relation
     * @return
     */
    int create(Relation relation);

    /**
     * 判断歌单中是否有音乐
     * @param sheetId
     * @return
     */
    int findBySheetId(String sheetId);

    int findBySongId(String songId);

    int removeSongBySongIdAndSheetId(@Param("songId") String songId,@Param("sheetId")  String sheetId);
}
