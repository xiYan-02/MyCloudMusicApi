package com.example.mycloudmusicapi.controller.v1;

import com.example.mycloudmusicapi.domain.Video;
import com.example.mycloudmusicapi.exception.MyException;
import com.example.mycloudmusicapi.mapper.CommonMapper;
import com.example.mycloudmusicapi.mapper.VideoMapper;
import com.example.mycloudmusicapi.response.ResponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 视频相关接口控制器
 */
@RestController
@RequestMapping("/v1")
public class VideoController {

    @Autowired
    private VideoMapper videoMapper;

    @Autowired
    private CommonMapper commonMapper;

    @GetMapping("/video")
    public Object findAll(){
        return videoMapper.findAll();
    }

    @GetMapping("/video/{id}")
    public Object findById(@PathVariable("id") String id){
        Video video = videoMapper.findById(id);
        if(video == null){
            throw new MyException(ResponseCode.VIDEO_NOT_HAS);
        }
//        点击数+1
        if(commonMapper.increment("video",id,"clicks_count") != 1){
            throw new MyException(ResponseCode.UPDATE_FILED);
        }
        video.setClicksCount(video.getClicksCount()+1);
        return video;
    }

}
