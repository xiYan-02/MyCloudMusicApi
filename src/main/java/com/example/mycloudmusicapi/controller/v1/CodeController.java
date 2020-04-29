package com.example.mycloudmusicapi.controller.v1;

import com.example.mycloudmusicapi.domain.User;
import com.example.mycloudmusicapi.exception.MyException;
import com.example.mycloudmusicapi.response.ResponseCode;
import com.example.mycloudmusicapi.service.MailService;
import com.example.mycloudmusicapi.service.SMSService;
import com.example.mycloudmusicapi.service.UserService;
import com.example.mycloudmusicapi.util.Md5Util;
import com.example.mycloudmusicapi.util.RandomUtil;
import com.example.mycloudmusicapi.util.TimeUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/v1/code")
public class CodeController {

    @Autowired
    private UserService userService;

    @Autowired
    private MailService mailService;

    @Autowired
    private SMSService smsServier;

    @PostMapping("/request_email_code")
    public Object requestEmailCode(@RequestBody User data){


        String codeString = getCodeString(data);
//        发送邮件
        if(StringUtils.isBlank(data.getEmail())){
            throw new MyException(ResponseCode.PARAM_IS_INVALID);
        }
            mailService.sendCodeEmail(data.getEmail(),codeString);
//        返回code，在真实项目中不需要返回，这里是为了测试
        return codeString;

    }

    @PostMapping("/request_sms_code")
    public Object requestSMSCode(@RequestBody User data){

        String codeString = getCodeString(data);
//        发送邮件
        if(StringUtils.isBlank(data.getPhone())){
            throw new MyException(ResponseCode.PARAM_IS_INVALID);
        }
        smsServier.sendCodePhone(data.getPhone(),codeString);
//        返回code，在真实项目中不需要返回，这里是为了测试
        return codeString;

    }

    private String getCodeString(User data){
        if(StringUtils.isBlank(data.getEmail()) && StringUtils.isBlank(data.getPhone())){
            throw new MyException(ResponseCode.PARAM_IS_INVALID);
        }
        User user;
        if(StringUtils.isNotBlank(data.getEmail())){
            user = userService.isExistEmail(data.getEmail());
        }else{
            user = userService.isExistPhone(data.getPhone());
        }
        //        判断用户是否存在
        if(user == null){
            throw new MyException(ResponseCode.USER_NOT_FIND);
        }
        //        判断时间间隔是否符合要求
        if(user.getCodeSendAt() != null && !TimeUtil.plusMinutesAfterNow(user.getCodeSendAt(),1)){
            throw new MyException(ResponseCode.ERROR_TOO_FAST);
        }
        int code = RandomUtil.Int4();
        String codeString = String.valueOf(code);
        log.info("requestEmailCode code {}", codeString);

//        加密后保存到数据库
        if(!userService.updateCode(user.getId(), Md5Util.encrypt(codeString))){
            throw new MyException(ResponseCode.UPDATE_FILED);
        }
        return codeString;
    }


}
