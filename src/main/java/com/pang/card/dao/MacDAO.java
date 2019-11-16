package com.pang.card.dao;

import java.util.Set;

/**
 * @author pang
 * @version V1.0
 * @ClassName: MacDAO
 * @Package com.pang.card.dao
 * @description:
 * @date 2019/11/16 14:25
 */
public interface MacDAO {
    /**
     * 添加新的mac地址
     * @param mac mac地址
     * @return 添加成功返回1
     */
    int addNewMac(String mac);

    Set<String> getAllMac();

    int deleteMac(String mac);
}
