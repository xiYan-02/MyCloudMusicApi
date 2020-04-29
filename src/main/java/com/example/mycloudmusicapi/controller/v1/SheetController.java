package com.example.mycloudmusicapi.controller.v1;

import com.example.mycloudmusicapi.annotation.Authorization;
import com.example.mycloudmusicapi.annotation.CurrentUser;
import com.example.mycloudmusicapi.domain.Sheet;
import com.example.mycloudmusicapi.domain.Song;
import com.example.mycloudmusicapi.domain.Tag;
import com.example.mycloudmusicapi.domain.User;
import com.example.mycloudmusicapi.exception.MyException;
import com.example.mycloudmusicapi.mapper.*;
import com.example.mycloudmusicapi.response.Response;
import com.example.mycloudmusicapi.response.ResponseCode;
import com.example.mycloudmusicapi.util.TagUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/v1")
public class SheetController {

    @Autowired
    SheetMapper mapper;

    @Autowired
    private SongMapper songMapper;

    @Autowired
    private LabelMapper labelMapper;

    @Autowired
    private RelationMapper relationMapper;

    @Autowired
    private TagMapper tagMapper;

    @Autowired
    private CollectionMapper collectionMapper;

    /**
     * 新建歌单
     * @param data
     * @param currentUser
     * @return
     */
    @PostMapping("/sheets")
    @Authorization
    public Object create(@Validated @RequestBody Sheet data, @CurrentUser User currentUser){
        //更新id
        data.setUserId(currentUser.getId());

        if(mapper.create(data) != 1){
            throw new MyException(ResponseCode.UPDATE_FILED);
        }

//        保存歌单的标签
        saveTags(data.getTags(),data.getId(),currentUser.getId());

        return data.getId();
    }

    /**
     * 添加歌单时替换或添加标签
     * @param tags
     * @param id
     * @param userId
     */
    private void saveTags(List<Tag> tags, String id, String userId) {
        if(tags != null && tags.size() > 0){
            tags = Tag.fillData(tags,id,userId);
//            保存标签到数据库
            labelMapper.replace(tags);
        }
    }

    /**
     * 歌单列表
     * @return
     */
    @GetMapping("/sheets")
    public List<Sheet> getAll(){

        return mapper.getAll();

    }

    /**
     * 根据歌单id查询唯一歌单，并把歌单中的歌曲也返回
     * @param id
     * @return
     */
    @GetMapping("/sheets/{id}")
    public Sheet find(@PathVariable("id") String id,@CurrentUser User currentUser){

//        判断歌单是否存在
        Sheet data = checkSheet(id);
//        判断歌单中是否有音乐
        if(relationMapper.findBySheetId(id) > 0){
//        查询歌单中的所有歌曲
            List<Song> songs = songMapper.findBySheetId(id);
            data.setSongs(songs);
        }
//        返回两级标签
        TagUtil.findChildTag(data.getTags(),tagMapper);

//        判断用户是否收藏该歌单
        if(currentUser != null && collectionMapper.findByUserIdAndSheetId(currentUser.getId(),id) != null){
            data.setIsCollection(1);
        }

        return data;
    }

    /**
     * 更新歌单信息
     * @param id
     * @param data
     * @param currentUser
     * @return
     */
    @PatchMapping("/sheets/{id}")
    public Object updateByIdAndUserId(@PathVariable("id") String id,@RequestBody Sheet data,@CurrentUser User currentUser){
        checkSheet(id);
        data.setId(id);
        data.setUserId(currentUser.getId());
        if(mapper.updateByIdAndUserId(data) != 1){
            throw new MyException(ResponseCode.UPDATE_FILED);
        }

//        更新歌单的标签
        saveTags(data.getTags(),id,currentUser.getId());

        return id;

    }

    /**
     * 删除歌单
     * @param id
     * @param currentUser
     * @return
     */
    @Authorization
    @DeleteMapping("/sheets/{id}")
    public Object deleteByIdAndUserId(@PathVariable("id") String id,@CurrentUser User currentUser){
        checkSheet(id);
        if(mapper.deleteByIdAndUserId(id,currentUser.getId()) != 1){
            throw new MyException(ResponseCode.UPDATE_FILED);
        }
        return Response.success(null);
    }

    /**
     * 根据id判断歌单是否存在
     * @param id
     * @return
     */
    public Sheet checkSheet(String id){
        Sheet sheet = mapper.find(id);

        if(sheet == null){
            throw new MyException(ResponseCode.SHEET_NOT_EXIT);
        }
        return sheet;
    }

}
