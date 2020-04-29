package com.example.mycloudmusicapi.controller.v1;

import com.example.mycloudmusicapi.annotation.Authorization;
import com.example.mycloudmusicapi.annotation.CurrentUser;
import com.example.mycloudmusicapi.domain.Friend;
import com.example.mycloudmusicapi.domain.User;
import com.example.mycloudmusicapi.exception.MyException;
import com.example.mycloudmusicapi.mapper.CommonMapper;
import com.example.mycloudmusicapi.mapper.FriendMapper;
import com.example.mycloudmusicapi.mapper.UserMapper;
import com.example.mycloudmusicapi.response.Response;
import com.example.mycloudmusicapi.response.ResponseCode;
import com.example.mycloudmusicapi.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 粉丝/好友控制器
 */
@RestController
@RequestMapping("/v1")
public class FriendController {

    @Autowired
    private UserService userService;

    @Autowired
    private FriendMapper friendMapper;

    @Autowired
    private CommonMapper commonMapper;

    /**
     * 关注用户
     * @param data
     * @param currentUser
     * @return
     */
    @Authorization
    @PostMapping("/friends")
    public Object create(@RequestBody User data, @CurrentUser User currentUser){
//        检查
        checked(data.getId(),currentUser.getId());
//        判断是否已经关注
        if(friendMapper.getCountByFollowerAndFollowed(data.getId(),currentUser.getId()) > 0){
            throw new MyException(ResponseCode.USER_HAS_FOLLOWER);
        }
//        封装对象并保存
        Friend friend = new Friend();
        friend.setFollowerId(currentUser.getId());
        friend.setFollowedId(data.getId());
        if(friendMapper.create(friend) != 1){
            throw new MyException(ResponseCode.UPDATE_FILED);
        }
//        被关注者粉丝数量加 1
        commonMapper.increment("user",data.getId(),"followers_count");
//        我的好友数 +1
        commonMapper.increment("user",currentUser.getId(),"followings_count");
        return friend.getId();
    }

    /**
     * 取消关注
     * @param id
     * @param currentUser
     * @return
     */
    @Authorization
    @DeleteMapping("/friends/{id}")
    public Object destroy(@PathVariable("id")String id,@CurrentUser User currentUser){
//        检查
        checked(id,currentUser.getId());
//        判断用户是否关注
        if(friendMapper.getCountByFollowerAndFollowed(id,currentUser.getId()) == 0){
            throw new MyException(ResponseCode.USER_NOT_FOLLOWER);
        }
        friendMapper.destroy(id,currentUser.getId());
//        取消关注者粉丝数量 -1
        commonMapper.decrement("user",id,"followers_count");
//        我的好友数 -1
        commonMapper.decrement("user",currentUser.getId(),"followings_count");
        return Response.success(null);
    }

    private void checked(String id,String currentId){
        //        判断id是否存在
        if(StringUtils.isBlank(id)){
            throw new MyException(ResponseCode.PARAM_IS_INVALID);
        }
//        判断要关注的用户是否存在
        if(userService.find(id) == null){
            throw new MyException(ResponseCode.USER_NOT_FIND);
        }
//        自己不能关注自己
        if(id.equals(currentId)){
            throw new MyException(ResponseCode.PARAM_IS_INVALID);
        }
    }

}
