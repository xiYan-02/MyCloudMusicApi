package com.example.mycloudmusicapi.mapper;

import com.example.mycloudmusicapi.domain.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户mapper,这个类在UserMapper中关联了的
 * @repository:实现dao访问
 */
@Repository
public interface UserMapper {
    /**
     * 保存用户
     * @param data
     * @return
     */
    int create(User data);

    /**
     * 查询所有用户
     * @return
     */
    List<User> findAll();

    /**
     * 根据id查询单一用户
     * @return
     */
    User find(String id);

//    判断某个参数是否存在
    User isExistPhone(@Param("data") String phone);

    User isExistEmail(@Param("data") String email);

    User isExistQQid(@Param("data") String qqId);

    User isExistWeiBo(@Param("data") String weiboId);

    User isExistWechat(@Param("data") String wechatId);

    int updateSession(@Param("id") String id,@Param("data") String sessionDigest);

    /**
     * 更新用户基本信息
     * @param data
     * @return
     */
    int update(User data);

    /**
     * 绑定第三方账号
     * @param id
     * @param accountId
     * @param accountField
     * @param accountDigest
     * @return
     */
    int updateAccount(@Param("id") String id,@Param("accountId") String accountId,@Param("field") String accountField,@Param("accountDigest") String accountDigest);

    /**
     * 更新邮箱确认信息
     * @param id
     * @param encrypt
     * @return
     */
    int updateConfirmationDigest(@Param("id") String id,@Param("encrypt") String encrypt);

    /**
     * 根据邮箱的digest查询唯一用户
     * @param confirmationDigest
     * @return
     */
    User findByConfirmationDigest(String confirmationDigest);

    /**
     * 清空数据库中ConfirmationDigest字段
     * @param id
     * @param str
     * @return
     */
    int updateConfirmationSuccess(@Param("id") String id,@Param("str") String str);

    /**
     * 更新验证码字段
     * @return
     */
    int updateCode(@Param("id")String id,@Param("codeString") String codeString);

    /**
     * 更新密码
     * @param id
     * @param data
     * @return
     */
    int updatePassword(@Param("id") String id,@Param("data") String data);
}
