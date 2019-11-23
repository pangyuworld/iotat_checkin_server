package com.pang.card.services;

import com.pang.card.dao.MacDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

import static com.pang.card.initialization.MacSetInit.macSet;

/**
 * @author pang
 * @version V1.0
 * @ClassName: MacService
 * @Package com.pang.card.services
 * @description:
 * @date 2019/11/16 14:29
 */
@Service
public class MacService {
    @Autowired
    private MacDAO macDAO;

    /**
     * 添加新的mac地址
     *
     * @param mac mac地址
     * @return 是否添加成功
     */
    public boolean addNewMac(String mac) {
        if (!UserService.checkMac(mac)) {
            return false;
        }
        int r = macDAO.addNewMac(mac);
        if (r > 0) {
            macSet.add(mac);
            return true;
        } else {
            return false;
        }
    }

    /**
     * 获取全部的mac地址
     *
     * @return 包含mac地址的列表
     */
    public Set<String> getAllMac() {
        Set<String> macList = macDAO.getAllMac();
        macSet.addAll(macList);
        return macList;
    }

    /**
     * 删除mac
     *
     * @param mac mac地址
     * @return 是否删除成功
     */
    public boolean deleteMac(String mac) {
        if (!UserService.checkMac(mac)) {
            return false;
        }
        int r = macDAO.deleteMac(mac);
        if (r > 0) {
            macSet.remove(mac);
            return true;
        }
        return false;
    }
}
