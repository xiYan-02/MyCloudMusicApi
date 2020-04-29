package com.example.mycloudmusicapi.util;

import com.example.mycloudmusicapi.domain.Tag;
import com.example.mycloudmusicapi.mapper.TagMapper;

import java.util.List;

public class TagUtil {
    public static void findChildTag(List<Tag> tags, TagMapper tagMapper){
        List<Tag> teps;
        for (Tag tag :
                tags) {
//            把这个id当做parentID来查下一级
            teps = tagMapper.findAll(tag.getId());
            if(teps != null && teps.size() > 0){
                tag.setData(teps);
            }
        }

    }
}
