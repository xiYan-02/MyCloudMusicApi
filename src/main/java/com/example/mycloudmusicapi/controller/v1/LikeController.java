package com.example.mycloudmusicapi.controller.v1;

import com.example.mycloudmusicapi.annotation.Authorization;
import com.example.mycloudmusicapi.annotation.CurrentUser;
import com.example.mycloudmusicapi.domain.Like;
import com.example.mycloudmusicapi.domain.User;
import com.example.mycloudmusicapi.exception.MyException;
import com.example.mycloudmusicapi.mapper.CommonMapper;
import com.example.mycloudmusicapi.mapper.LikeMapper;
import com.example.mycloudmusicapi.response.Response;
import com.example.mycloudmusicapi.response.ResponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/v1")
@RestController
public class LikeController {

    @Autowired
    private CommonMapper commonMapper;

    @Autowired
    private LikeMapper likeMapper;

    @Authorization
    @PostMapping("/likes")
    public Object create(@Validated @RequestBody Like like, @CurrentUser User currentUser){
        like.setUserId(currentUser.getId());
//        判断是否已经点赞
        if(likeMapper.getCount(like.getCommentId(),currentUser.getId()) > 0){
            throw new MyException(ResponseCode.HAS_LIKES);
        }
//        点赞表增加一条记录
        if(likeMapper.create(like) != 1){
            throw new MyException(ResponseCode.UPDATE_FILED);
        }

//        评论表点赞次数加1
        if(commonMapper.increment("comment",like.getCommentId(),"likes_count") != 1){
            throw new MyException(ResponseCode.UPDATE_FILED);
        }
        return like.getId();
    }

    @Authorization
    @DeleteMapping("/likes/{id}")
    public Object destroy(@PathVariable("id")String comment_id,@CurrentUser User currentUser){
        //        点赞表减少一条记录
        if(likeMapper.destroy(comment_id,currentUser.getId()) != 1){
            throw new MyException(ResponseCode.UPDATE_FILED);
        }

//        评论表点赞次数减1
        if(commonMapper.decrement("comment",comment_id,"likes_count") != 1){
            throw new MyException(ResponseCode.UPDATE_FILED);
        }
        return Response.success(null);
    }

}
