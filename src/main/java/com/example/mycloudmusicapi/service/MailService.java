package com.example.mycloudmusicapi.service;

import com.example.mycloudmusicapi.util.Md5Util;
import com.example.mycloudmusicapi.util.UUIDUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
@Slf4j
public class MailService {

    @Autowired
    private UserService userService;

    /**
     * 本机地址，从配置文件中获取
     */
    @Value("${application.host}")
    private String host;

    /**
     * 注入模板引擎
     */
    @Autowired
    private TemplateEngine templateEngine;

    /**
     *  邮件发送器
     */
    @Autowired
    private JavaMailSender javaMailSender;

    /**
     * 发送邮箱激活邮件
     *
     * @param id
     * @param nickname
     * @param email
     */
    public boolean requestEmailVerification(String id, String nickname, String email) {

        //生成随机字符串
        String confirmation = UUIDUtil.getUUID();
        //邮件可能属于敏感信息
        //真实项目中根据实际情况打印，打印了未加密的邮箱token
        log.info("requestEmailVerification {} {} {} {}", id, nickname, email,confirmation);

        //保存到数据库
        if (!userService.updateConfirmationDigest(id, Md5Util.encrypt(confirmation))) {
            //保存失败
            return false;
        }

        // 发送邮件
//        thymeleaf.context
        Context context = new Context();
//        设置相关变量
        context.setVariable("nickname",nickname);
        context.setVariable("email",email);
        String configUrl = String.format("%s/mails/%s/confirm_verification",host,confirmation);
        context.setVariable("confirmUrl",configUrl);

//        处理模板
        String content = templateEngine.process("emailConfirm",context);
//        调用发送HTML邮件的方法
        sendHTMLMail(email,"【我的云音乐】邮箱确认通知",content);
        return true;
    }


    /**
     * 发送邮件的邮箱
     */
    private String from = "xiyan_cong@163.com";

    /**
     * 发送简单邮件
     * @param to 发送目标邮箱
     */
    public void sendSimpleMail(String to){
        String subject = "这是标题";
        String content = "这是内容";

        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject(subject);
        message.setText(content);
        message.setTo(to);
        message.setFrom(from);

        try {
            javaMailSender.send(message);
            log.info("send success {}",to);
        } catch (MailException e) {
            log.info("send filed {}",e);
        }
    }

    /**
     * 发送HTML邮件
     * @param to 发送给谁
     * @param subject 主题
     * @param content 内容
     */
    public void sendHTMLMail(String to,String subject,String content){
        try {
            MimeMessage message = javaMailSender.createMimeMessage();

//        创建helper
            MimeMessageHelper helper = new MimeMessageHelper(message,true);
            helper.setFrom(from);
            helper.setTo(to);
//            是否为HTML
            helper.setText(content,true);
            helper.setSubject(subject);
            javaMailSender.send(message);
            log.info("send success {}",to);
        } catch (MessagingException e) {
            log.error("send error {}",e);
        }

    }

    /**
     * 发送邮件验证码
     * @param to
     * @param codeString
     */
    public void sendCodeEmail(String to, String codeString) {

        Context context = new Context();
        context.setVariable("code",codeString);
//        拿到HTML字符串
        String content = templateEngine.process("emailCode",context);
        sendHTMLMail(to,"邮箱验证码【我的云音乐】",content);

    }
}
