package com.example.mycloudmusicapi.controller.v1;

import com.example.mycloudmusicapi.domain.Tag;
import com.example.mycloudmusicapi.mapper.TagMapper;
import com.example.mycloudmusicapi.util.TagUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 标签控制器
 */
@RestController
@RequestMapping("/v1")
public class TagController {

    @Autowired
    private TagMapper mapper;

    /**
     * 获取全部歌单标签，可通过查询字符串返回指定的标签
     * 默认返回两层
     * @param parent
     * @return
     */
    @GetMapping("/tags")
    public Object getAll(@RequestParam(required = false) String parent){
        //查询第一层标签
        List<Tag> datum = mapper.findAll(parent);

        //默认只查询第二层标签
        //如果项目中是无限层级
        //那么一般都会通过parentId一层一层获取
/*        List<Tag> tags;
        for (Tag tag : datum) {
//            把这个id当做parentID来查下一级
            tags = mapper.findAll(tag.getId());
            if (tags != null && tags.size() > 0) {
                tag.setData(tags);
            }
        }*/
        TagUtil.findChildTag(datum,mapper);
        //返回
        return datum;

    }

}
