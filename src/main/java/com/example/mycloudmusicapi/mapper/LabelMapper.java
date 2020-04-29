package com.example.mycloudmusicapi.mapper;

import com.example.mycloudmusicapi.domain.Tag;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LabelMapper {

    /**
     * 添加歌单时替换或添加标签
     * @param tags
     * @return
     */
    int replace(@Param("tags") List<Tag> tags);

}
