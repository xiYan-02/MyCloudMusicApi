package com.example.mycloudmusicapi.service;

import com.example.mycloudmusicapi.domain.Feed;
import com.example.mycloudmusicapi.domain.PageData;
import com.example.mycloudmusicapi.mapper.FeedMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 动态服务类
 */
@Service
public class FeedService {

    @Autowired
    private FeedMapper feedMapper;

    public int create(Feed feed){
        return feedMapper.created(feed);
    }

    public PageData findAll(int page, int size) {
//        开始分页
        PageHelper.startPage(page,size);
//        获取数据
        List<Feed> feeds = feedMapper.findAll();
//        获取分页信息
        PageInfo<Feed> pageInfo = new PageInfo<>(feeds);
        return new PageData<Feed>(page,pageInfo.getPages(), (int) pageInfo.getTotal(),pageInfo.getList());
    }
}
