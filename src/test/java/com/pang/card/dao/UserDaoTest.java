package com.pang.card.dao;

import cn.hutool.http.HttpUtil;
import cn.hutool.http.Method;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author pang
 * @version V1.0
 * @ClassName: UserDaoTest
 * @Package com.pang.card.dao
 * @description:
 * @date 2019/10/31 19:18
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTest {
    @Autowired
    private UserDAO userDAO;


    @Test
    public void selectAllUserInfoTest(){
        // Assert.assertEquals("[{realName=张星宇, stuId=5120170586, userMail=a904237539@qq.com, userName=zxy, userId=1, userMac=00-00-00-00-00-00}, {realName=张星宇, stuId=5120170582, userMail=3282125008@qq.com, userName=zxy2222, userId=11, userMac=70-1C-E7-87-33-09}, {realName=何腾洋, stuId=5120164263, userMail=904237539@qq.com, userName=5120164263, userId=12, userMac=F8-28-19-6A-1A-A3}, {realName=ppp, stuId=5120170002, userMail=5616516@qq.com, userName=admins, userId=13, userMac=F0-79-59-C6-22-80}, {realName=zxzxzx, stuId=5120170005, userMail=a9555665@qq.com, userName=zxzxzx, userId=14, userMac=F0-79-59-C6-22-81}, {realName=zzxzxzx, stuId=5120176666, userMail=a90412156@qq.com, userName=zxzxzxx, userId=15, userMac=F0-79-59-C6-22-86}]",userDAO.selectAllUserInfo().toString());
        System.out.println(userDAO.selectAllUserInfo());
    }

}
