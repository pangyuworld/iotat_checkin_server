package com.pang.card.dao;

import java.util.List;
import java.util.Map;

/**
 * @author pang
 * @version V1.0
 * @ClassName: UploadDAO
 * @Package com.pang.card.dao
 * @description: 上传文件DAO层接口
 * @date 2019/11/23 12:40
 */
public interface UploadDAO {
    /**
     * 上传新的文件时候的文件信息
     *
     * @param fileInfo 文件信息
     */
    int uploadFile(Map<String, Object> fileInfo);

    /**
     * 根据版本号查找文件信息
     *
     * @param version 版本号
     * @return 包含文件信息的map
     */
    Map<String, Object> getUploadFile(String version);

    /**
     * 查询全部的版本信息列表
     */
    List<Map<String, Object>> getAllUploadFile();

    Map<String, Object> getLastUploadVersion();
}
