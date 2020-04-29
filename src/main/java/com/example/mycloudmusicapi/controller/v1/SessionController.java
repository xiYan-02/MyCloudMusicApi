package com.example.mycloudmusicapi.controller.v1;

import com.example.mycloudmusicapi.annotation.Authorization;
import com.example.mycloudmusicapi.annotation.CurrentUser;
import com.example.mycloudmusicapi.domain.Session;
import com.example.mycloudmusicapi.domain.User;
import com.example.mycloudmusicapi.exception.MyException;
import com.example.mycloudmusicapi.response.Response;
import com.example.mycloudmusicapi.response.ResponseCode;
import com.example.mycloudmusicapi.service.SessionService;
import com.example.mycloudmusicapi.service.UserService;
import com.example.mycloudmusicapi.util.BCryptUtil;
import com.example.mycloudmusicapi.util.SHAUtil;
import com.example.mycloudmusicapi.util.UUIDUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(description = "登录相关")
@RestController
@RequestMapping("/v1")
@Slf4j
public class SessionController {

    @Autowired
    private UserService userService;
    @Autowired
    private SessionService sessionService;


    @ApiOperation("用户登录")
    @PostMapping("/sessions")
    public Object login(@RequestBody User data){
        User user = null;
        String pwd = "";
        String encryptPwd = "";

        if(StringUtils.isNotBlank(data.getEmail()) && StringUtils.isNotBlank(data.getPassword())){
//            邮箱 + 密码 登录
//            判断邮箱是否存在
            user = userService.isExistEmail(data.getEmail());
            checkNull(user);
            pwd = data.getPassword();
            encryptPwd = user.getPassword();
        }else if(StringUtils.isNotBlank(data.getPhone()) && StringUtils.isNotBlank(data.getPassword())){
//            手机 + 密码 登录
//            判断手机号是否存在
            user = userService.isExistPhone(data.getPhone());
            checkNull(user);
            pwd = data.getPassword();
            encryptPwd = user.getPassword();
        }else if(StringUtils.isNotBlank(data.getQqId())){
//            qq登录
//            你用qq登录为什么要判断它存不存在？
            user = userService.isExistQQid(SHAUtil.sha1(data.getQqId()));
            checkNull(user);
//            qq_id：对qq进行sha1加密
//            qq_id_digest：对qq进行BCrypt加密，
//            判断的时候你只要根据sha1(qq)从数据库中拿到qq_id_digest，然后把这个digest和传过来的qq进行对比即可
            pwd = data.getQqId();
            encryptPwd = user.getQqIdDigest();
//            微信、微博后期再实现
        }
        else{
//            抛出参数错误
                throw new MyException(ResponseCode.PARAM_IS_INVALID);
            }


//        判断密码是否相等
        if(!BCryptUtil.matchEncode(pwd,encryptPwd)){
            throw new MyException(ResponseCode.PWD_ERROR);
        }
//        登录成功的操作
//        生成session
        String session = UUIDUtil.getUUID();
//        对session进行加密
        String sessEncrypt = BCryptUtil.encrypt(session);
//        将加密后的session设置到user对象中
        user.setSessionDigest(sessEncrypt);

//        更新数据库
        if(!sessionService.saveUserSession(user)){
            throw new MyException(ResponseCode.LOGIN_FILED);
        }

//        返回session对象
        Session session1 = new Session();
        session1.setId(user.getId());
        session1.setSession(session);
        return session1;

    }

    private void checkNull(Object o) {
        if(o == null){
            throw new MyException(ResponseCode.USER_NOT_FIND);
        }
    }


    @ApiOperation("退出登录")
    @DeleteMapping("/destroy/{id}")
    @Authorization
    public Object destroy(@PathVariable("id") String id, @CurrentUser User user){
        log.info("SessionController:id:{},name:{}",id,user.getNickname());
//        清除用户登录的session
        if(!sessionService.deleteSession(user.getId())){
//            清除失败，抛异常
            throw new MyException(ResponseCode.EXIT_ERROR);
        }
        return Response.success(null);

    }

}
