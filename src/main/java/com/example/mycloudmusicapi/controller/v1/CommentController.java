package com.example.mycloudmusicapi.controller.v1;

import com.example.mycloudmusicapi.annotation.Authorization;
import com.example.mycloudmusicapi.annotation.CurrentUser;
import com.example.mycloudmusicapi.domain.Comment;
import com.example.mycloudmusicapi.domain.Like;
import com.example.mycloudmusicapi.domain.PageData;
import com.example.mycloudmusicapi.domain.User;
import com.example.mycloudmusicapi.exception.MyException;
import com.example.mycloudmusicapi.mapper.*;
import com.example.mycloudmusicapi.response.ResponseCode;
import com.example.mycloudmusicapi.service.CommentServe;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 评论控制器
 */
@RestController
@RequestMapping("/v1")
public class CommentController {

    @Autowired
    private CommentServe commentServe;

    @Autowired
    private CommonMapper commonMapper;

    @Autowired
    private SongMapper songMapper;

    @Autowired
    private VideoMapper videoMapper;

    @Autowired
    private SheetMapper sheetMapper;

    @Autowired
    private LikeMapper likeMapper;

    @Authorization
    @PostMapping("/comment")
    public Object create(@RequestBody @Validated Comment data, @CurrentUser User currentUser){
        data.setUserId(currentUser.getId());
//        每增加一条评论，为对应对象的评论数加1
        if(StringUtils.isNotBlank(data.getSheetId())){
//            判断是否存在
            if(sheetMapper.find(data.getSheetId()) == null){
                throw new MyException(ResponseCode.SHEET_NOT_EXIT);
            }
//            评论数+1
            commonMapper.increment("sheet",data.getSheetId(),"comments_count");
        }else if(StringUtils.isNotBlank(data.getVideoId())){
//            判断是否存在
            if(videoMapper.findById(data.getVideoId()) == null){
                throw new MyException(ResponseCode.VIDEO_NOT_HAS);
            }
//            评论数+1
            commonMapper.increment("video",data.getVideoId(),"comments_count");
        }else if(StringUtils.isNotBlank(data.getSongId())){
//            判断是否存在
            if(songMapper.find(data.getSongId()) == null){
                throw new MyException(ResponseCode.SONG_NOT_EXITS);
            }
//            评论数+1
            commonMapper.increment("song",data.getSongId(),"comments_count");
        }
        if(commentServe.create(data) != 1){
            throw new MyException(ResponseCode.UPDATE_FILED);
        }
        return data.getId();
    }

    /**
     * 返回评论列表，分页、自定义排序
     * @param page 当前页数
     * @param size 每页的数量
     * @param order 排序规则，0:按发布时间，默认，10：按热度、点赞数
     * @return
     */
    @GetMapping("/comment")
    public Object index(@RequestParam(defaultValue = "1")int page,@RequestParam(defaultValue = "10")int size,
                          @RequestParam(defaultValue = "0")int order,
                        @RequestParam(required = false,name = "user_id")String userId,
                        @RequestParam(required = false,name = "song_id")String songId,
                        @RequestParam(required = false,name = "sheet_id")String sheetId,
                        @RequestParam(required = false,name = "video_id")String videoId,
                        @CurrentUser User currentUser){
        PageData pageData = commentServe.index(page,size,order,userId,songId,sheetId,videoId);

//        如果有登录就返回是否点赞
        if(currentUser != null){
            List<Comment> comments = pageData.getDatas();
            for (Comment comment:comments) {
                if(likeMapper.findByCommentIdAndUserId(comment.getId(),currentUser.getId()) !=null){
                    comment.setIsLike(1);
                }
            }
        }

        return pageData;
    }

}
