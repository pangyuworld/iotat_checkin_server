package com.pang.card.controller;

import com.pang.card.common.result.ResultEnum;
import com.pang.card.common.result.ResultJSON;
import com.pang.card.services.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * @author pang
 * @version V1.0
 * @ClassName: UpdateController
 * @Package com.pang.card.controller
 * @description: 更新控制器
 * @date 2019/11/23 12:35
 */
@RestController
public class UpdateController {

    @Autowired
    private UploadService uploadService;

    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public ResultJSON<Map<String,Object>> upload(MultipartFile file){
        return new ResultJSON<>(uploadService.upload(file), ResultEnum.SUCCESS_OPTION);
    }

    @RequestMapping(value = "/version/equal",method = RequestMethod.GET)
    public ResultJSON<Boolean> equal(String version){
        return new ResultJSON<>(uploadService.equalVersion(version),ResultEnum.SUCCESS_OPTION);
    }

    @RequestMapping(value = "/version",method = RequestMethod.GET)
    public ResultJSON<Map<String,Object>> lastVersion(){
        return new ResultJSON<>(uploadService.getLastVersion(),ResultEnum.SUCCESS_OPTION);
    }

    @RequestMapping(value = "/versions",method = RequestMethod.GET)
    public ResultJSON<List<Map<String,Object>>> getAllVersion(){
        return new ResultJSON<>(uploadService.getAllVersion(),ResultEnum.SUCCESS_OPTION);
    }
}
