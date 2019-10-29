package com.pang.card.dao;

import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author pang
 * @version V1.0
 * @ClassName: OnlineLogDAO
 * @Package com.pang.card.dao
 * @description:
 * @date 2019/10/28 10:26
 */
public interface OnlineLogDAO {
    /**
     * 刷新在线状态
     *
     * @param logId     日志id
     * @param loginTime 登录时间
     * @param lastTime  最后在线时间
     * @param logWeek   本周周数
     */
    int online(@Param("logId") Long logId,
               @Param("loginTime") Date loginTime,
               @Param("lastTime") Date lastTime,
               @Param("logWeek") Long logWeek);

    /**
     * 根据mac地址获取登录日志
     *
     * @param mac mac地址
     * @return 日志
     */
    Map<String, Object> getOnlineLogByMac(@Param("mac") String mac);

    /**
     * 插入新的日志
     *
     * @param userId    用户id
     * @param loginTime
     * @param lastTime
     * @param logWeek
     * @return
     */
    int addOnlineLog(@Param("userId") Long userId,
                     @Param("loginTime") Date loginTime,
                     @Param("lastTime") Date lastTime,
                     @Param("logWeek") Integer logWeek);

    /**
     * 获取用户签到的周数
     *
     * @param userId 用户id
     * @return 返回的是用户在线过的周数列表，主要用于后面查询某一周的在线状态
     */
    List<Long> getWeekListByUserId(@Param("userId") Long userId);

    /**
     * 获取用户某周的在线表格
     *
     * @param userId  用户id
     * @param logWeek 要查询的周数
     * @return 得到的是周志列表
     */
    List<Map<String, Object>> getOnlineLogByWeek(@Param("userId") Long userId, @Param("logWeek") Long logWeek);
}
