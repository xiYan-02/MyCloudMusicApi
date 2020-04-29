package com.example.mycloudmusicapi.service;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.google.gson.JsonObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SMSService {

    @Value("${aliyun.ak}")
    private String ak;
    @Value("${aliyun.sk}")
    private String sk;
    @Value("${aliyun.sms.region}")
    private String region;

    /**
     * 发送短信验证码
     * @param to
     * @param codeString
     */
    public void sendCodePhone(String to, String codeString) {
        //创建配置
        DefaultProfile profile = DefaultProfile.getProfile(region, ak, sk);

        //创建客户端
        DefaultAcsClient client = new DefaultAcsClient(profile);

        //创建通用请求
        CommonRequest request = new CommonRequest();

        //以下是固定写法
        request.setSysMethod(MethodType.POST);
        request.setSysDomain("dysmsapi.aliyuncs.com");
        request.setSysVersion("2017-05-25");
        request.setSysAction("SendSms");
        request.putQueryParameter("RegionId", region);

        //手机号
        request.putQueryParameter("PhoneNumbers", to);

        //设置短信模板
        //在阿里云后台查看
        request.putQueryParameter("TemplateCode", "SMS_185840720");

        //短信签名
        request.putQueryParameter("SignName", "我的云音乐");

        //设置验证码
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("code", codeString);
        request.putQueryParameter("TemplateParam", jsonObject.toString());

        try {
            //发送验证码
            CommonResponse response = client.getCommonResponse(request);
            //这里就不处理错误了
            //真实项目中，可能会把状态保存到数据库
            log.info("requestSMSCode success {} --> {}", to,response.getData());
        } catch (ClientException e) {
            log.error("requestSMSCode failed {} {}", to, e);
        }
    }
}
