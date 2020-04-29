package com.example.mycloudmusicapi.service;

import com.example.mycloudmusicapi.domain.User;
import com.example.mycloudmusicapi.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper mapper;

    public User isExistPhone(String phone) {
        return mapper.isExistPhone(phone);
    }

    public User isExistEmail(String email) {
        return mapper.isExistEmail(email);
    }

    public User isExistQQid(String qqId) {
        return mapper.isExistQQid(qqId);
    }

    public User isExistWeiBo(String weiboId) {
        return mapper.isExistWeiBo(weiboId);
    }

    public User isExistWechat(String wechatId) {
        return mapper.isExistWechat(wechatId);
    }

    public boolean create(User user) {
        return mapper.create(user) > 0;
    }

    public List<User> findAll() {
        return mapper.findAll();
    }

    public User find(String id) {
        return mapper.find(id);
    }

    /**
     * 更新用户基本信息
     * @param user
     * @return
     */
    public boolean update(User user) {
        int res =  mapper.update(user);

        return res == 1;
    }

    /**
     * 绑定第三方账号
     * @param id 用户id
     * @param accountId sha1加密后的第三方id
     * @param accountField 数据库字段
     * @param accountDigest Bcrypt加密后的第三方id
     * @return 是否成功
     */
    public boolean updateAccount(String id, String accountId, String accountField, String accountDigest) {
        return mapper.updateAccount(id,accountId,accountField,accountDigest) == 1;
    }

    public boolean updateConfirmationDigest(String id, String encrypt) {
        return mapper.updateConfirmationDigest( id, encrypt) == 1;
    }

    /**
     * 根据邮箱的digest查询唯一用户
     * @param confirmationDigest
     * @return
     */
    public User findByConfirmationDigest(String confirmationDigest) {
        return mapper.findByConfirmationDigest(confirmationDigest);
    }

    /**
     * 清空数据库中ConfirmationDigest字段
     * @param id
     * @param str
     * @return
     */
    public boolean updateConfirmationSuccess(String id, String str) {
        return mapper.updateConfirmationSuccess(id,str) == 1;
    }

    /**
     * 更新验证码字段
     * @param id
     * @param codeString
     * @return
     */
    public boolean updateCode(String id, String codeString) {
        return mapper.updateCode(id,codeString) == 1;
    }

    /**
     * 更新密码
     * @param id
     * @param data
     * @return
     */
    public boolean updatePassword(String id, String data) {
        return mapper.updatePassword(id,data) == 1;
    }
}
