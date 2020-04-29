package com.example.mycloudmusicapi.mapper;

import com.example.mycloudmusicapi.domain.Sheet;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 歌单映射对象
 */
@Repository
public interface SheetMapper {

    /**
     * 创建歌单
     * @param data
     * @return
     */
    int create(Sheet data);

    /**
     * 返回所有歌单列表
     * @return
     */
    List<Sheet> getAll();

    /**
     * 根据id查询唯一歌单
     * @param id
     * @return
     */
    Sheet find(String id);

    /**
     * 更新歌单
     * @param data
     * @return
     */
    int updateByIdAndUserId(Sheet data);

    /**
     * 根据歌单id和用户id删除一个歌单
     * @param id
     * @param userId
     * @return
     */
    int deleteByIdAndUserId(@Param("id") String id,@Param("userId") String userId);

    /**
     * 根据歌单id和用户id查询歌单id
     * @param id
     * @param userId
     * @return
     */
    Sheet findByIdAndUserId(@Param("id") String id,@Param("userId") String userId);

    /**
     * 返回用户创建的所有歌单
     * @param id
     * @return
     */
    List<Sheet> findByUserId(String id);

    /**
     * 返回用户收藏的歌单
     * @param id
     * @return
     */
    List<Sheet> findCollectionByUserId(String id);
}
