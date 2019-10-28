package com.pang.card.services;

import cn.hutool.core.util.ReUtil;
import cn.hutool.crypto.digest.DigestUtil;
import com.pang.card.common.result.ResultEnum;
import com.pang.card.common.result.ResultException;
import com.pang.card.dao.UserDAO;
import com.pang.card.util.token.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author pang
 * @version V1.0
 * @ClassName: UserService
 * @Package com.pang.card.services
 * @description:
 * @date 2019/10/28 10:34
 */
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@Service
public class UserService {
    @Autowired
    private UserDAO userDAO;

    /**
     * 用户注册
     *
     * @param userName 用户名
     * @param password 密码
     * @param mac      mac地址
     * @param realName 真实姓名
     * @param userMail 用户邮箱
     * @param stuId    学号
     * @return 注册成功返回1，否则抛出异常
     */
    public int register(String userName, String password, String mac,
                        String realName, String userMail, String stuId) {
        // 检查各种参数
        if (!(checkUserName(userName) &&
                checkPassword(password) &&
                checkMail(userMail) &&
                checkMac(mac) &&
                checkStuId(stuId))) {
            throw new ResultException(ResultEnum.ILLEGAL_ARGUMENT);
        }
        // 检验账号是否存在
        if (userDAO.selectUserByUserName(userName) > 0) {
            throw new ResultException(ResultEnum.REPEAT_NAME);
        }
        // 检验mac是否存在
        if (userDAO.selectUserByMac(mac) > 0) {
            throw new ResultException(ResultEnum.REPEAT_MAC);
        }
        // 检验邮箱是否存在
        if (userDAO.selectUserByUserMail(userMail) > 0) {
            throw new ResultException(ResultEnum.REPEAT_EMAIL);
        }
        // 检验学号是否存在
        if (userDAO.selectUserByStuId(stuId) > 0) {
            throw new ResultException(ResultEnum.REPEAT_STU_ID);
        }
        // SHA256加密
        password = new String(DigestUtil.sha256(password));

        return userDAO.register(userName, password, mac, realName, userMail, stuId);
    }

    /**
     * 用户登录
     *
     * @param userName 用户名
     * @param password 密码
     * @return token字符串
     */
    public Map<String, Object> login(String userName, String password) {
        Map<String, Object> userInfo = userDAO.login(userName);
        if (userInfo == null || userInfo.size() <= 0) {
            throw new ResultException(ResultEnum.NO_USER_EXIST);
        }
        password = new String(DigestUtil.sha256(password));
        if (!password.equals(userInfo.get("password"))) {
            throw new ResultException(ResultEnum.NOT_MATCH);
        }
        // 得到token
        String token = TokenUtil.createJWT(1000 * 60 * 60 * 2, userName, "");

        Map<String, Object> result = new HashMap<>();
        result.put("token", token);
        result.put("userId", userInfo.get("userId"));
        return result;
    }

    /**
     * 根据用户id查询用户信息
     *
     * @param userId 用户id
     * @return
     */
    public Map<String, Object> getUserInfoByUserId(Long userId) {
        return userDAO.selectUserInfoByUserId(userId);
    }

    /**
     * 根据用户mac查询用户信息
     *
     * @param mac 用户mac地址
     * @return
     */
    public Map<String, Object> getUserInfoByUserMac(String mac) {
        if (!checkMac(mac)) {
            throw new ResultException(ResultEnum.ILLEGAL_ARGUMENT);
        }
        return userDAO.selectUserInfoByMac(mac);
    }

    /**
     * 检查用户名,用户名需要以 6到20个数字、英文字母、下划线组成
     *
     * @param userName 用户名
     */
    private boolean checkUserName(String userName) {
        return ReUtil.isMatch("^\\w{6,20}$", userName);
    }

    /**
     * 检查密码，密码需要以 6到20个数字、英文字母、下划线组成
     *
     * @param password 密码
     */
    private boolean checkPassword(String password) {
        return ReUtil.isMatch("^\\w{6,20}$", password);
    }

    /**
     * 检查油箱
     *
     * @param userMail 邮箱
     */
    private boolean checkMail(String userMail) {
        return ReUtil.isMatch("^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$", userMail);
    }

    /**
     * 检查mac
     *
     * @param mac mac地址
     */
    private boolean checkMac(String mac) {
        return ReUtil.isMatch("([A-Fa-f0-9]{2}-){5}[A-Fa-f0-9]{2}", mac);
    }

    /**
     * 检查学号
     *
     * @param stuId 学号
     */
    private boolean checkStuId(String stuId) {
        return ReUtil.isMatch("5120[0-9]{6}", stuId);
    }
}
