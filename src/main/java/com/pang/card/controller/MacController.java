package com.pang.card.controller;

import com.pang.card.common.result.ResultEnum;
import com.pang.card.common.result.ResultJSON;
import com.pang.card.services.MacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

/**
 * @author pang
 * @version V1.0
 * @ClassName: MacController
 * @Package com.pang.card.controller
 * @description:
 * @date 2019/11/16 14:37
 */
@RestController
public class MacController {
    @Autowired
    private MacService macService;

    @RequestMapping(value = "/mac",method = RequestMethod.POST)
    public ResultJSON<Boolean> addNewMac(String mac){
        return new ResultJSON<>(macService.addNewMac(mac), ResultEnum.SUCCESS_OPTION);
    }

    @RequestMapping(value = "/mac",method = RequestMethod.GET)
    public ResultJSON<Set<String>> getAllMac(){
        return new ResultJSON<>(macService.getAllMac(),ResultEnum.SUCCESS_OPTION);
    }

    @RequestMapping(value = "/mac",method = RequestMethod.DELETE)
    public ResultJSON<Boolean> deleteMac(String mac){
        return new ResultJSON<>(macService.deleteMac(mac),ResultEnum.SUCCESS_OPTION);
    }
}
