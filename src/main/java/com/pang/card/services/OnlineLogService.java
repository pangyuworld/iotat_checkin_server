package com.pang.card.services;

import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import com.pang.card.common.result.ResultEnum;
import com.pang.card.common.result.ResultException;
import com.pang.card.dao.OnlineLogDAO;
import com.pang.card.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.*;

import static com.pang.card.initialization.MacSetInit.macSet;

/**
 * @author pang
 * @version V1.0
 * @ClassName: OnlineLogService
 * @Package com.pang.card.services
 * @description:
 * @date 2019/10/28 19:53
 */
@Service
public class OnlineLogService {
    @Autowired
    private OnlineLogDAO onlineLogDAO;
    @Autowired
    private UserDAO userDAO;

    /**
     * 在线请求
     *
     * @param selfMac   个人mac地址
     * @param commonMac 公共mac地址
     */
    public int getOnlineRequest(String selfMac, String commonMac) {
        if (!macSet.contains(commonMac)) {
            System.out.println(commonMac);
            throw new ResultException(400, "不在实验室环境");
        }
        Map<String, Object> userInfo = userDAO.selectUserInfoByMac(selfMac);
        if (userInfo == null || userInfo.size() <= 0) {
            throw new ResultException(ResultEnum.NO_USER_EXIST);
        }
        Map<String, Object> logMap = onlineLogDAO.getOnlineLogByMac(selfMac);
        if (logMap == null) {
            // 如果之前没有日志，那就直接插入
            return onlineLogDAO.addOnlineLog((Long) userInfo.get("userId"), new Date(), new Date(), getWeek());
        }
        if (judgeTimeOut((Date) logMap.get("lastTime"))) {
            // 如果超时了，那就重新插入一条新的
            return onlineLogDAO.addOnlineLog((Long) userInfo.get("userId"), new Date(), new Date(), getWeek());
        }
        // 最终，更新数据
        return onlineLogDAO.online((Long) logMap.get("logId"),
                (Date) logMap.get("loginTime"),
                new Date(),
                (Long) logMap.get("logWeek"));
    }

    /**
     * 查询用户所在过的周数
     *
     * @param userId 用户id
     */
    public List<Long> getWeekList(Long userId) {
        return onlineLogDAO.getWeekListByUserId(userId);
    }

    /**
     * 获取用户某周的在线状态
     *
     * @param userId  用户id
     * @param logWeek 周数
     * @return 日志列表
     */
    public Map<String, Object> getOnlineLogByWeek(Long userId, @Nullable Long logWeek) {
        if (logWeek == null || logWeek <= 0) {
            logWeek = (long) getWeek();
        }
        List<Map<String, Object>> logList = onlineLogDAO.getOnlineLogByWeek(userId, logWeek);
        if (logList == null) {
            throw new ResultException(400,"没有在线信息");
        }
        long totalMinutes = 0;
        // 汇总时间
        for (Map<String, Object> r : logList) {
            Long difference = DateUtil.between((Date) r.get("loginTime"), (Date) r.get("lastTime"), DateUnit.MINUTE);
            totalMinutes += difference;
        }
        Map<String, Object> result = new HashMap<>(10);
        // 添加结果
        result.put("total", getHour(totalMinutes));
        result.put("week", logWeek);
        result.put("data", logList);
        return result;
    }


    /**
     * 获取所有用户某周的日志
     *
     * @param logWeek 周id
     * @return 所有用户某周的日志
     */
    public List<Map<String, Object>> getAllUserOnlineLog(@Nullable Long logWeek) {
        if (logWeek == null || logWeek <= 0) {
            logWeek = (long) getWeek();
        }
        List<Map<String, Object>> result = new LinkedList<>();
        List<Map<String, Object>> userIdList = userDAO.selectAllUserInfo();
        for (Map<String, Object> m : userIdList) {
            Map<String, Object> onlineLog = this.getOnlineLogByWeek((Long) m.get("userId"), logWeek);
            onlineLog.put("userInfo", m);
            result.add(onlineLog);
        }
        return result;
    }


    /**
     * 计算参数日期是否与当前日期计算超时
     *
     * @param date 需要计算的日期
     * @return 是否超时
     */
    private boolean judgeTimeOut(Date date) {
        long difference = DateUtil.between(date, new Date(), DateUnit.MINUTE);
        Integer startDay = DateUtil.dayOfMonth(date);
        Integer endDay = DateUtil.dayOfMonth(new Date());
        return difference > 10 || (!startDay.equals(endDay));
    }

    /**
     * 获取年份周数
     *
     * @return 年份+周数的数字
     */
    private int getWeek() {
        Date date = DateUtil.date();
        // 获取周数
        int week = DateUtil.weekOfYear(date);
        // 获取年份
        int year = DateUtil.year(date);
        String str = "" + year + "" + week;
        return Integer.parseInt(str);
    }

    /**
     * 获取小时数
     *
     * @param minutes 分钟
     * @return 小时数，保留两位小数
     */
    public String getHour(Long minutes) {
        double totalMinutesF = minutes / 60.0;
        DecimalFormat df = new DecimalFormat("#0.00");
        return df.format(totalMinutesF);
    }
}
