package com.pang.card.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author pang
 * @version V1.0
 * @ClassName: UserDAO
 * @Package com.pang.card.dao
 * @description:
 * @date 2019/10/28 10:25
 */
public interface UserDAO {
    /**
     * 用户注册
     *
     * @param userName 用户名
     * @param password 密码
     * @param mac      mac地址
     * @param realName 真实姓名
     * @param userMail 用户邮箱
     * @param stuId    学号
     * @return 注册成功返回1，否则出现异常
     */
    int register(@Param("userName") String userName,
                 @Param("password") String password,
                 @Param("mac") String mac,
                 @Param("realName") String realName,
                 @Param("userMail") String userMail,
                 @Param("stuId") String stuId);

    int selectUserByUserName(@Param("userName") String userName);

    int selectUserByMac(@Param("mac") String mac);

    int selectUserByUserMail(@Param("userMail") String userMail);

    int selectUserByStuId(@Param("stuId") String stuId);

    Map<String, Object> login(@Param("userName") String userName);

    Map<String, Object> selectUserInfoByMac(@Param("mac") String mac);

    Map<String, Object> selectUserInfoByUserId(@Param("userId") Long userId);

    List<Map<String, Object>> selectAllUserInfo();
}
