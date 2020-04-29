package com.example.mycloudmusicapi.service;

import com.example.mycloudmusicapi.domain.Comment;
import com.example.mycloudmusicapi.domain.PageData;
import com.example.mycloudmusicapi.mapper.CommentMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 评论服务类
 */
@Service
public class CommentServe {

    @Autowired
    private CommentMapper commentMapper;

    public int create(Comment data) {
        return commentMapper.create(data);
    }

    public PageData index(int page, int size, int order,String userId,String songId,String sheetId,String videoId) {
        Map<String,String> map = new HashMap<>();
        if(StringUtils.isNotBlank(userId)){
            map.put("c.user_id",String.format("'%s'",userId));
        }
        if(StringUtils.isNotBlank(songId)){
            map.put("c.song_id",String.format("'%s'",songId));
        }
        if(StringUtils.isNotBlank(sheetId)){
            map.put("c.sheet_id",String.format("'%s'",sheetId));
        }
        if(StringUtils.isNotBlank(videoId)){
            map.put("c.video_id",String.format("'%s'",videoId));
        }
//        开始分页
        PageHelper.startPage(page,size);
        String orderFiled;
        if(order == 0){
            orderFiled = "c.created_at";
        }else {
            orderFiled = "c.likes_count";
        }
//        查询数据
        List<Comment> comments = commentMapper.findAll(orderFiled,map);
//        创建pageInfo
        PageInfo<Comment> pageInfo = new PageInfo<>(comments);

        return new PageData<Comment>(pageInfo.getPageNum(),pageInfo.getPages(), (int) pageInfo.getTotal(), comments);
    }
}
