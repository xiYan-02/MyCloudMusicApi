package com.example.mycloudmusicapi.mapper;

import com.example.mycloudmusicapi.domain.Song;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongMapper {

    /**
     * 新建歌曲
     * @param song
     * @return
     */
    int create(Song song);

    /**
     * 歌曲详情
     * @param id
     * @return
     */
    Song find(String id);

    /**
     * 全部歌曲
     * @return
     */
//    List<Song> findAll(@Param("size") int size,@Param("offset") int offset);
    List<Song> findAll();

    /**
     * 获取全部歌曲的总数
     * @return
     */
    int getCount();

    /**
     * 更新数据
     * @param data
     * @return
     */
    int update(Song data);

    /**
     * 删除数据
     * @param id
     * @return
     */
    int delete(@Param("id") String id,@Param("userId") String userId);

    /**
     * 根据歌单id查询所有歌曲
     * @param sheetId
     * @return
     */
    List<Song> findBySheetId(String sheetId);
}
