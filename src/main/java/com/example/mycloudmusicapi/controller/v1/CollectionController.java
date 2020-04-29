package com.example.mycloudmusicapi.controller.v1;

import com.example.mycloudmusicapi.annotation.Authorization;
import com.example.mycloudmusicapi.annotation.CurrentUser;
import com.example.mycloudmusicapi.domain.Collection;
import com.example.mycloudmusicapi.domain.User;
import com.example.mycloudmusicapi.exception.MyException;
import com.example.mycloudmusicapi.mapper.CollectionMapper;
import com.example.mycloudmusicapi.mapper.CommonMapper;
import com.example.mycloudmusicapi.mapper.SheetMapper;
import com.example.mycloudmusicapi.response.Response;
import com.example.mycloudmusicapi.response.ResponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 收藏歌单映射
 */
@RestController
@RequestMapping("/v1")
public class CollectionController {

    @Autowired
    private SheetMapper sheetMapper;

    @Autowired
    private CollectionMapper collectionMapper;

    @Autowired
    private CommonMapper commonMapper;

    /**
     * 收藏歌单
     * @param data 歌单id
     * @param currentUser 当前用户
     * @return
     */
    @Authorization
    @PostMapping("/collection")
    public Object create(@Validated @RequestBody Collection data, @CurrentUser User currentUser){

//        判断歌单是否存在
        if(sheetMapper.find(data.getSheetId()) == null){
            throw new MyException(ResponseCode.SHEET_NOT_EXIT);
        }
//        判断用户是否已经收藏了该歌单
        Collection collection = collectionMapper.findByUserIdAndSheetId(currentUser.getId(),data.getSheetId());
        if(collection != null){
            throw new MyException(ResponseCode.COLLECTION_HAS);
        }
//        添加数据
        if(collectionMapper.create(currentUser.getId(),data.getSheetId()) != 1){
            throw new MyException(ResponseCode.UPDATE_FILED);
        }
        commonMapper.increment("sheet",data.getSheetId(),"collections_count");
        return data.getSheetId();

    }

    /**
     * 取消收藏
     * @param sheetId
     * @param currentUser
     * @return
     */
    @Authorization
    @DeleteMapping("/collection/{id}")
    public Object destroy(@PathVariable("id") String sheetId,@CurrentUser User currentUser){
//        判断歌单是否存在
        if(sheetMapper.find(sheetId) == null){
            throw new MyException(ResponseCode.SHEET_NOT_EXIT);
        }

//        判断歌单是否收藏
        Collection collection = collectionMapper.findByUserIdAndSheetId(currentUser.getId(),sheetId);
        if(collection == null){
            throw new MyException(ResponseCode.COLLECTION_NOT_HAS);
        }

//        判断是否为自己的歌单
        if(!currentUser.getId().equals(collection.getUserId())){
            throw new MyException(ResponseCode.NOT_POWER);
        }
//        进行删除操作
        if(collectionMapper.destroy(currentUser.getId(),sheetId) != 1){
            throw new MyException(ResponseCode.UPDATE_FILED);
        }
        commonMapper.decrement("sheet",sheetId,"collections_count");
        return Response.success(null);

    }

}
