package com.pang.card.controller;

import com.pang.card.common.result.ResultEnum;
import com.pang.card.common.result.ResultJSON;
import com.pang.card.services.OnlineLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
}
