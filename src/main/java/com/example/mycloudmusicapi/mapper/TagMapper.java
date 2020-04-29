package com.example.mycloudmusicapi.mapper;

import com.example.mycloudmusicapi.domain.Tag;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 歌单标签映射
 */
@Repository
public interface TagMapper {

    /**
     * 查询全部歌单标签，也可以根据父级id查询
     * @param parent
     * @return
     */
    List<Tag> findAll(String parent);

}
