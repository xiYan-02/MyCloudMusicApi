package com.example.mycloudmusicapi.controller.v1;

import com.example.mycloudmusicapi.annotation.Authorization;
import com.example.mycloudmusicapi.annotation.CurrentUser;
import com.example.mycloudmusicapi.domain.User;
import com.example.mycloudmusicapi.exception.MyException;
import com.example.mycloudmusicapi.response.Response;
import com.example.mycloudmusicapi.response.ResponseCode;
import com.example.mycloudmusicapi.service.MailService;
import com.example.mycloudmusicapi.service.UserService;
import com.example.mycloudmusicapi.util.Md5Util;
import com.example.mycloudmusicapi.util.TimeUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

/**
 * 邮件控制器
 * 这里用@Controller，不用@RestController，因为会生成一个HTML网页
 */
@Controller
@Slf4j
public class MailController {

    @Autowired
    private MailService mailService;

    @Autowired
    private UserService userService;

    @PostMapping("v1/mails/request_verification")
    @Authorization
    public @ResponseBody
    Object requestEmailVerification(@CurrentUser User currentUser){
//        判断是否已经验证
        if(currentUser.getConfirmedAt() != null){
            throw new MyException(ResponseCode.HAS_SEND_MAIL);
        }
        if(!mailService.requestEmailVerification(currentUser.getId(),currentUser.getNickname(),currentUser.getEmail())){
            throw new MyException(ResponseCode.ERROR_SEND_MAIL);
        }

        return Response.success(null);
    }

    /**
     * 显示邮箱验证结果界面
     *
     * 是一个html界面
     *
     * @param confirmationDigest
     * @param modelMap
     * @return
     */
    @RequestMapping("mails/{confirmationDigest}/confirm_verification")
    public String confirmVerification(@PathVariable String confirmationDigest, ModelMap modelMap){

//        加密
        confirmationDigest = Md5Util.encrypt(confirmationDigest);
//      根据邮箱验证taken查找这个用户
        User user = userService.findByConfirmationDigest(confirmationDigest);

        String message="";
        if(user == null){
//            没有找到用户
//            提示链接无效
            message = "链接无效，请重新发送！";
        }else if(!TimeUtil.plusDaysAfterNow(user.getConfirmationSendAt(),3)){
//            设置为三天后过期

//            清空ConfirmationDigest
            if (!userService.updateConfirmationDigest(user.getId(),null)){
                throw new MyException(ResponseCode.UPDATE_FILED);
            }
//            时间过期
            message = "链接过期，请重新发送！";
        }else{
//            清空数据库的ConfirmationDigest字段
            if(!userService.updateConfirmationSuccess(user.getId(),null)){
                throw new MyException(ResponseCode.UPDATE_FILED);
            }

            message = "邮箱验证成功！";
        }
        modelMap.addAttribute("message",message);

        return "emailVerification";
    }

    @GetMapping("testSendEmail/{email}")
    public Object testSendEmail(@PathVariable String email){
        mailService.sendSimpleMail(email);

        return Response.success("发送成功！");
    }



}
