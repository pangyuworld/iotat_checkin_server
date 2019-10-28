package com.pang.card.controller;

import com.pang.card.common.result.ResultEnum;
import com.pang.card.common.result.ResultJSON;
import com.pang.card.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author pang
 * @version V1.0
 * @ClassName: UserController
 * @Package com.pang.card.controller
 * @description:
 * @date 2019/10/28 10:56
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResultJSON<Integer> register(String userName, String password, String mac,
                                        String realName, String userMail, String stuId) {
        return new ResultJSON<>(userService.register(userName, password, mac, realName, userMail, stuId), ResultEnum.SUCCESS_OPTION);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResultJSON<Map> login(String userName, String password) {
        return new ResultJSON<>(userService.login(userName, password), ResultEnum.LOGIN_SUCCESS);
    }

    @RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
    public ResultJSON<Map> getUserByUserId(@PathVariable Long userId) {
        return new ResultJSON<>(userService.getUserInfoByUserId(userId));
    }
}
