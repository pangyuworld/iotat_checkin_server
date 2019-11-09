package com.pang.card.controller;

import com.pang.card.common.result.ResultEnum;
import com.pang.card.common.result.ResultJSON;
import com.pang.card.services.OnlineLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author pang
 * @version V1.0
 * @ClassName: OnlineLogController
 * @Package com.pang.card.controller
 * @description:
 * @date 2019/10/28 19:53
 */
@RestController
public class OnlineLogController {
    @Autowired
    private OnlineLogService service;

    @RequestMapping(value = "/online", method = RequestMethod.GET)
    public ResultJSON<Integer> onlineRequest(String selfMac, String commonMac) {
        return new ResultJSON<>(service.getOnlineRequest(selfMac, commonMac), ResultEnum.SUCCESS_OPTION);
    }

    @RequestMapping(value = "/week/{userId}", method = RequestMethod.GET)
    public ResultJSON<List<Long>> getWeekByUserId(@PathVariable Long userId) {
        return new ResultJSON<>(service.getWeekList(userId), ResultEnum.SUCCESS_OPTION);
    }

    @RequestMapping(value = "/week/log/{userId}", method = RequestMethod.GET)
    public ResultJSON<Map<String, Object>> getOnlineLog(@PathVariable Long userId, @Nullable Long logWeek) {
        return new ResultJSON<>(service.getOnlineLogByWeek(userId, logWeek), ResultEnum.SUCCESS_OPTION);
    }

    @RequestMapping(value = "/week/allLog", method = RequestMethod.GET)
    public ResultJSON<List<Map<String, Object>>> getAllUserOnlineLog(@Nullable Long logWeek) {
        return new ResultJSON<>(service.getAllUserOnlineLog(logWeek), ResultEnum.SUCCESS_OPTION);
    }
}
