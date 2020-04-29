package com.example.mycloudmusicapi.controller.v1;

import com.example.mycloudmusicapi.annotation.Authorization;
import com.example.mycloudmusicapi.annotation.CurrentUser;
import com.example.mycloudmusicapi.domain.Feed;
import com.example.mycloudmusicapi.domain.User;
import com.example.mycloudmusicapi.exception.MyException;
import com.example.mycloudmusicapi.mapper.ResourceMapper;
import com.example.mycloudmusicapi.response.ResponseCode;
import com.example.mycloudmusicapi.service.FeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
public class FeedController {

    @Autowired
    private FeedService feedService;

    @Autowired
    private ResourceMapper resourceMapper;

    @Authorization
    @PostMapping("/feeds")
    @Transactional
    public Object create(@RequestBody @Validated Feed feed, @CurrentUser User currentUser){
        feed.setUserId(currentUser.getId());
//        保存动态内容
        if(feedService.create(feed) != 1){
            throw new MyException(ResponseCode.UPDATE_FILED);
        }
//        保存动态图片
        if(feed.getImages() != null&&feed.getImages().size() > 0){
            if(resourceMapper.create(feed.getImages(),feed.getId(),currentUser.getId()) <= 0){
                throw new MyException(ResponseCode.UPDATE_FILED);
            }
        }
        return feed;
    }

    @GetMapping("/feeds")
    public Object findAll(@RequestParam(name = "page",defaultValue = "1")int page,
                          @RequestParam(name = "size",defaultValue = "20")int size){

        return feedService.findAll(page,size);
    }

}
