package com.example.mycloudmusicapi.controller.v1;

import com.example.mycloudmusicapi.annotation.Authorization;
import com.example.mycloudmusicapi.annotation.CurrentUser;
import com.example.mycloudmusicapi.domain.Account;
import com.example.mycloudmusicapi.domain.Common;
import com.example.mycloudmusicapi.domain.Sheet;
import com.example.mycloudmusicapi.domain.User;
import com.example.mycloudmusicapi.exception.MyException;
import com.example.mycloudmusicapi.mapper.FriendMapper;
import com.example.mycloudmusicapi.mapper.RelationMapper;
import com.example.mycloudmusicapi.mapper.SheetMapper;
import com.example.mycloudmusicapi.mapper.UserMapper;
import com.example.mycloudmusicapi.response.Response;
import com.example.mycloudmusicapi.response.ResponseCode;
import com.example.mycloudmusicapi.service.MailService;
import com.example.mycloudmusicapi.service.UserService;
import com.example.mycloudmusicapi.util.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(description = "用户接口")
@RequestMapping("/v1")
@RestController
@Slf4j
public class UserController {

    @Autowired
    private UserService service;

    @Autowired
    private MailService mailService;

    @Autowired
    private SheetMapper sheetMapper;
    @Autowired
    private RelationMapper relationMapper;

    @Autowired
    private FriendMapper friendMapper;

    @ApiOperation(value = "新建用户")
    @PostMapping("/users")
    public Common create(@RequestBody @Validated User user){
//        加密数据
        user.encryptData();

//        判断数据是否已经存在
        if(service.isExistPhone(user.getPhone()) != null){
            throw new MyException(ResponseCode.USER_HAS_PHONE);
        }
        if(service.isExistEmail(user.getEmail()) != null){
            throw new MyException(ResponseCode.USER_HAS_EMAIL);
        }
        if(service.isExistQQid(user.getQqId()) != null){
            throw new MyException(ResponseCode.USER_HAS_QQID);
        }
        if(service.isExistWeiBo(user.getWeiboId()) != null){
            throw new MyException(ResponseCode.USER_HAS_WEIBOID);
        }
        if(service.isExistWechat(user.getWechatId()) != null){
            throw new MyException(ResponseCode.USER_HAS_WECHATID);
        }

//        再次判断是否添加成功
        if(!service.create(user)) {
            throw new MyException(ResponseCode.ADD_EXCEPTION);
        }


        try {
            //发送邮件验证
            //可以根据业务调整
            mailService.requestEmailVerification(user.getId(), user.getNickname(), user.getEmail());
        } catch (Exception e) {
            log.error("request email verification failed {}", e);
        }


//        若注册成功，只返回用户注册的id
        Common common = new Common();
        common.setId(user.getId());
        return common;
    }

    @ApiOperation(value = "查看所有用户")
    @GetMapping("/users")
    public List<User> findAll(){
        return service.findAll();
    }


    @ApiOperation(value = "用户详情")
    @GetMapping("/users/{id}")
    public User find(@PathVariable("id") String id,@CurrentUser User currentUser){
        User user = service.find(id);
        if(currentUser != null){
//            返回当前用户是否关注了所查看的用户
            if(friendMapper.getCountByFollowerAndFollowed(id,currentUser.getId()) > 0){
                user.setFollowing(1);
            }
        }
        return user;
    }

    @GetMapping("/error")
    public Object errorNull(){
        Integer integer = null;
        String ss = integer.toString();
        return ss;
    }

    /**
     * 更新用户基本信息
     * @param id
     * @param user
     * @param currentUser
     * @return
     */
    @Authorization
    @PatchMapping(path = "/users/{id}")
    public Object update(@PathVariable("id") String id, @RequestBody User user, @CurrentUser User currentUser){
//        对用户传递过来的id是不信任的，所以要重新设置
        user.setId(currentUser.getId());
        if(!service.update(user)){
//            更新失败
            throw new MyException(ResponseCode.UPDATE_FILED);
        }
        return user;
    }

    /**
     * 绑定第三方账号
     * @param account
     * @param bindingResult
     * @param currentUser
     * @return
     */
    @PostMapping("/users/bind")
    @Authorization
    public Object bindAccount(@Valid @RequestBody Account account, BindingResult bindingResult,@CurrentUser User currentUser){
        if(bindingResult.hasErrors()){
            throw new MyException(ResponseCode.PARAM_IS_INVALID);
        }

        String accountField = "";
        if(account.getPlatform() == Constant.PLATFORM_QQ){
            accountField = "qq_id";
        }else if(account.getPlatform() == Constant.PLATFORM_WECHAT){
            accountField = "wechat_id";
        }else if(account.getPlatform() == Constant.PLATFORM_WEIBO){
            accountField = "weibo_id";
        }else{
            throw new MyException(ResponseCode.PARAM_IS_INVALID);
        }

        String accountDigest = BCryptUtil.encrypt(account.getAccount());
        if(!service.updateAccount(currentUser.getId(), SHAUtil.sha1(account.getAccount()),accountField,accountDigest)){
            throw new MyException(ResponseCode.UPDATE_FILED);
        }
        return currentUser.getId();
    }

    /**
     * 解绑第三方账号
     * @param platform
     * @param currentUser
     * @return
     */
    @Authorization
    @DeleteMapping("/users/{platform}/unbind")
    public Object unbindAccount(@PathVariable("platform") String platform,@CurrentUser User currentUser){
//        在url传递的都是字符串
        Integer platformInt = Integer.valueOf(platform);

        String field = "";
        if(platformInt == Constant.PLATFORM_QQ){
//            判断是否有绑定第三方账号
            if(currentUser.getQqId() == null){
                throw new MyException(ResponseCode.PARAM_IS_INVALID);
            }
            field = "qq_id";
        }else if(platformInt == Constant.PLATFORM_WECHAT){
            if(currentUser.getQqId() == null){
                throw new MyException(ResponseCode.PARAM_IS_INVALID);
            }
            field = "wechat_id";
        }else if(platformInt == Constant.PLATFORM_WEIBO){
            if(currentUser.getQqId() == null){
                throw new MyException(ResponseCode.PARAM_IS_INVALID);
            }
            field = "weibo_id";
        }else{
            throw new MyException(ResponseCode.PARAM_IS_INVALID);
        }
        if(!service.updateAccount(currentUser.getId(),null,field,null)){
            throw new MyException(ResponseCode.UPDATE_FILED);
        }
        return Response.success(null);
    }

    /**
     * 重置密码
     * @param data
     * @return
     */
    @Authorization
    @PostMapping("/users/reset_password")
    public Object resetPassword(@RequestBody User data){

//        判断字段是否缺少
        if((StringUtils.isBlank(data.getEmail()) && StringUtils.isBlank(data.getPhone()))||StringUtils.isBlank(data.getPassword())){
           throw new MyException(ResponseCode.PARAM_IS_INVALID);
        }
        if(StringUtils.isBlank(data.getCode())){
            throw new MyException(ResponseCode.PARAM_IS_INVALID);
        }

//        通过手机号或邮箱找到用户
        User user;
        if(StringUtils.isBlank(data.getEmail())){
            user = service.isExistPhone(data.getPhone());
        }else{
            user = service.isExistEmail(data.getEmail());
        }
        if(user == null){
            throw new MyException(ResponseCode.USER_NOT_FIND);
        }
//        判断验证码是否匹配
        if(!Md5Util.encrypt(data.getCode()).equals(user.getCode())){
            throw new MyException(ResponseCode.ERROR_CODE);
        }
//        判断验证码是否过期，5分钟过期
        if(TimeUtil.plusMinutesAfterNow(user.getCodeSendAt(),5)){
            throw new MyException(ResponseCode.ERROR_CODE_OUTTIME);
        }
//        判断是否和上次的密码一致
        if(BCryptUtil.matchEncode(data.getPassword(),user.getPassword())){
            throw new MyException(ResponseCode.ERROR_PWD_ALIGN);
        }
//        加密
        data.encryptData();
//        更新数据库，并清空验证码，验证码发送时间可以不清除
        if(!service.updatePassword(user.getId(),data.getPassword())&&!service.updateCode(user.getId(),null)){
//            更新失败
            throw new MyException(ResponseCode.UPDATE_FILED);
        }
//        更新数据成功
        return Response.success(null);

    }


    /**
     * 获取用户创建的歌单
     * @param id 用户id
     * @return
     */
    @GetMapping("users/{id}/create")
    public Object getUserSheet(@PathVariable("id")String id){
//        判断用户使用存在
        if(service.find(id) == null){
            throw new MyException(ResponseCode.USER_NOT_FIND);
        }
        return sheetMapper.findByUserId(id);
    }

    /**
     * 获取用户收藏的歌单
     * @param id
     * @return
     */
    @GetMapping("/users/{id}/collection")
    public Object getUserCollection(@PathVariable("id")String id){
        //        判断用户使用存在
        if(service.find(id) == null){
            throw new MyException(ResponseCode.USER_NOT_FIND);
        }
        return sheetMapper.findCollectionByUserId(id);
    }

}
