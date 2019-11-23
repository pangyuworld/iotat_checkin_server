package com.pang.card.services;

import com.pang.card.common.result.ResultEnum;
import com.pang.card.common.result.ResultException;
import com.pang.card.dao.UploadDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author pang
 * @version V1.0
 * @ClassName: UploadService
 * @Package com.pang.card.services
 * @description:
 * @date 2019/11/23 12:56
 */
@Service
public class UploadService {
    @Autowired
    private UploadDAO uploadDAO;
    @Value("${upload.server.base-url}")
    private String baseUrl;
    @Value("${upload.directory}")
    private String directory;
    @Value("${upload.enable-type}")
    private String enabledType;


    /**
     * 上传文件
     *
     * @param file 要上传的文件
     * @return 上传成功的基本信息
     */
    public Map<String, Object> upload(MultipartFile file) {
        if (file == null) {
            throw new ResultException(ResultEnum.UPLOAD_FAILED);
        }
        Map<String, Object> result = new HashMap<>();
        String fileName = file.getOriginalFilename();
        if (!fileName.endsWith(enabledType)) {
            throw new ResultException(ResultEnum.UPLOAD_FALSE_TYPE);
        }
        String filePath = baseUrl + directory + fileName;
        String fileVersion = getVersion(fileName);
        String fileSize = String.valueOf(file.getSize());
        File tFile = new File(filePath);
        try {
            file.transferTo(tFile);
            result.put("uploadFileName", fileName);
            result.put("uploadFileUrl", directory + fileName);
            result.put("uploadVersion", fileVersion);
            result.put("uploadFileSize", fileSize);
            result.put("uploadTime", new Date());
        } catch (IOException e) {
            e.printStackTrace();
        }
        uploadDAO.uploadFile(result);
        return result;
    }

    /**
     * 比对最新版本号
     *
     * @param version 要比对的版本号
     * @return 是否为最新版本
     */
    public boolean equalVersion(String version) {
        return version.endsWith(getLastVersion().get("uploadVersion").toString());
    }

    /**
     * 获取最新版本号
     *
     * @return 最新版本号
     */
    public Map<String, Object> getLastVersion() {
        return uploadDAO.getLastUploadVersion();
    }

    /**
     * 获取全部的版本信息
     *
     * @return 版本信息列表
     */
    public List<Map<String, Object>> getAllVersion() {
        return uploadDAO.getAllUploadFile();
    }

    private String getVersion(String fileName) {
        int startIndex = fileName.indexOf('@');
        int endIndex = fileName.indexOf(".exe");
        return fileName.substring(startIndex, endIndex);
    }


}
