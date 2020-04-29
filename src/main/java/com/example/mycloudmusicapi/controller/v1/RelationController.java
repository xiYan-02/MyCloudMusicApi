package com.example.mycloudmusicapi.controller.v1;

import com.example.mycloudmusicapi.annotation.Authorization;
import com.example.mycloudmusicapi.annotation.CurrentUser;
import com.example.mycloudmusicapi.domain.Common;
import com.example.mycloudmusicapi.domain.Relation;
import com.example.mycloudmusicapi.domain.User;
import com.example.mycloudmusicapi.exception.MyException;
import com.example.mycloudmusicapi.mapper.RelationMapper;
import com.example.mycloudmusicapi.mapper.SheetMapper;
import com.example.mycloudmusicapi.mapper.SongMapper;
import com.example.mycloudmusicapi.response.Response;
import com.example.mycloudmusicapi.response.ResponseCode;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 歌单和歌曲关系控制器
 */

@RestController
@RequestMapping("/v1")
public class RelationController {

    @Autowired
    private SheetMapper sheetMapper;

    @Autowired
    private SongMapper songMapper;

    @Autowired
    private RelationMapper relationMapper;

    /**
     * 将歌曲添加到歌单中---中间表，在url中传递歌单id
     * @param id 歌单id
     * @param data 歌曲
     * @param currentUser 当前用户
     * @return
     */
    @PostMapping("/relation/{id}")
    @Authorization
    public Object create(@PathVariable("id")String id, @RequestBody Common data, @CurrentUser User currentUser){

        checkData(id,data.getId(),currentUser.getId());
//        判断在歌单中是否存在这首歌曲
        if(relationMapper.findBySongId(data.getId()) > 0){
            throw new MyException(ResponseCode.RELATION_HAS);
        }
//        封装对象进行保存
        Relation relation = new Relation();
        relation.setSheetId(id);
        relation.setSongId(data.getId());
        relation.setUserId(currentUser.getId());
        if(relationMapper.create(relation) != 1){
            throw new MyException(ResponseCode.UPDATE_FILED);
        }
        return relation.getId();
    }

    /**
     * 在歌单中删除歌曲，歌单id在url中传递
     * @param id 歌单id
     * @param currentUser 当前用户
     * @return
     */
    @Authorization
    @DeleteMapping("/relation/{id}")
    public Object destroy(@PathVariable("id") String id,@RequestBody Common data, @CurrentUser User currentUser){
        checkData(id,data.getId(),currentUser.getId());
        //        判断在歌单中是否存在这首歌曲
        if(relationMapper.findBySongId(data.getId()) == 0){
            throw new MyException(ResponseCode.RELATION_NOT_SONG);
        }
//        进行删除操作
        if(relationMapper.removeSongBySongIdAndSheetId(data.getId(),id) != 1){
            throw new MyException(ResponseCode.UPDATE_FILED);
        }
        return Response.success(null);
    }

    /**
     * 检查参数辅助方法
     * @param sheetId
     * @param songId
     * @param userId
     */
    public void checkData(String sheetId,String songId,String userId){
        //        判断id是否为空
        if(StringUtils.isBlank(songId) || StringUtils.isBlank(sheetId)){
            throw new MyException(ResponseCode.PARAM_IS_INVALID);
        }
//        判断歌单是否存在
        if(sheetMapper.find(sheetId) == null){
            throw new MyException(ResponseCode.SHEET_NOT_EXIT);
        }
//        判断歌曲是否存在
        if(songMapper.find(songId) == null){
            throw new MyException(ResponseCode.SONG_NOT_EXITS);
        }
//        每个人只能操作到自己的歌单
        if(sheetMapper.findByIdAndUserId(sheetId,userId) == null){
            throw new MyException(ResponseCode.NOT_POWER);
        }
    }

}
