package com.example.mycloudmusicapi.service;

import com.example.mycloudmusicapi.domain.User;
import com.example.mycloudmusicapi.mapper.UserMapper;
import com.example.mycloudmusicapi.util.BCryptUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SessionService {

    @Autowired
    private UserMapper mapper;

    public boolean saveUserSession(User user) {
        return mapper.updateSession(user.getId(),user.getSessionDigest()) == 1;
    }

    public User checkSession(String userId, String authorization) {
        User user = mapper.find(userId);
//        判断用户是否存在
        if(user!= null){
//            判断session是否匹配
            if(BCryptUtil.matchEncode(authorization,user.getSessionDigest())){
                return user;
            }
        }
        return null;
    }

    public boolean deleteSession(String id) {
        return mapper.updateSession(id,null) == 1;
    }
}
