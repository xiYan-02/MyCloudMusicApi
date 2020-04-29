package com.example.mycloudmusicapi.controller.v1;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import com.example.mycloudmusicapi.annotation.Authorization;
import com.example.mycloudmusicapi.annotation.CurrentUser;
import com.example.mycloudmusicapi.domain.Ad;
import com.example.mycloudmusicapi.domain.User;
import com.example.mycloudmusicapi.exception.MyException;
import com.example.mycloudmusicapi.mapper.AdMapper;
import com.example.mycloudmusicapi.response.Response;
import com.example.mycloudmusicapi.response.ResponseCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/v1/ads")
public class AdController {

    @Autowired
    private AdMapper adMapper;

    /**
     * 创建广告
     * @param ad ad对象
     * @param currentUser 自动获取当前用户
     * @return
     */
    @Authorization
    @PostMapping("/create")
    public Object create(@Validated @RequestBody Ad ad, @CurrentUser User currentUser){

//        把接口中传递过来的对象中的user_id设置为当前用户的id，一般不用传这个id
        ad.setUserId(currentUser.getId());
//        添加
        if(adMapper.create(ad) != 1){
            throw new MyException(ResponseCode.UPDATE_FILED);
        }
//        成功返回广告id
        return Response.success(ad.getId());
    }

    /**
     * 查看所有广告
     * @return
     */
    @GetMapping
    public List<Ad> findAll(){
        return adMapper.findAll();
    }

    /**
     * 根据id查询唯一广告
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Ad find(@PathVariable("id") String id){
        Ad ad = adMapper.find(id);
        if(ad == null){
            throw new MyException(ResponseCode.AD_NOT_EXITS);
        }
        return ad;
    }

    /***
     * 更新广告字段
     * @param id
     * @param data
     * @param currentUser
     * @return
     */
    @PatchMapping("/{id}")
    @Authorization
    public Object update(@PathVariable("id") String id,@RequestBody Ad data,@CurrentUser User currentUser){
        Ad ad = adMapper.find(id);
        checkAdPower(ad,currentUser);

        //将要更新的值拷贝到原对象,并忽略空的字段和指定的字段
        BeanUtil.copyProperties(data,ad, CopyOptions.create().setIgnoreNullValue(true).setIgnoreProperties("id","userId","updatedAt,cratedAt"));
        if(adMapper.update(ad) != 1){
            throw new MyException(ResponseCode.UPDATE_FILED);
        }
        return id;
    }

    @Authorization
    @DeleteMapping("/{id}")
    public Object delete(@PathVariable("id") String id,@CurrentUser User user){
        Ad ad = adMapper.find(id);
        checkAdPower(ad,user);
        if(adMapper.delete(id) != 1){
            throw new MyException(ResponseCode.UPDATE_FILED);
        }
        return Response.success(null);
    }

    /**
     * 检查用户辅助方法
     * @param ad
     * @param currentUser
     */
    private void checkAdPower(Ad ad,User currentUser){
        if(ad == null){
            throw new MyException(ResponseCode.AD_NOT_EXITS);
        }

//        当前用户只能操作当前用户创建的广告
        if(!ad.getUser().getId().equals(currentUser.getId())){
            throw new MyException(ResponseCode.NOT_POWER);
        }
    }

}
