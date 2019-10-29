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

/**
 * @author pang
 * @version V1.0
 * @ClassName: OnlineLogService
 * @Package com.pang.card.services
 * @description:
 * @date 2019/10/28 19:53
 */
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@Service
public class OnlineLogService {
    @Autowired
    private OnlineLogDAO onlineLogDAO;
    @Autowired
    private UserDAO userDAO;

    private final Set<String> MAC_SET = new HashSet<>();

    {
        MAC_SET.add("f0-79-59-c6-22-80");
        MAC_SET.add("58-69-6c-5f-b2-32");
    }

    /**
     * 在线请求
     * @param selfMac 个人mac地址
     * @param commonMac 公共mac地址
     */
    public int getOnlineRequest(String selfMac, String commonMac) {
        if (!MAC_SET.contains(commonMac)) {
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
     * @param userId 用户id
     */
    public List<Long> getWeekList(Long userId){
        return onlineLogDAO.getWeekListByUserId(userId);
    }

    /**
     * 获取用户某周的在线状态
     * @param userId 用户id
     * @param logWeek 周数
     * @return 日志列表
     */
    public Map<String,Object> getOnlineLogByWeek(Long userId, @Nullable Long logWeek){
        if (logWeek==null||logWeek<=0){
            logWeek= Long.valueOf(getWeek());
        }
        List<Map<String,Object>> logList=onlineLogDAO.getOnlineLogByWeek(userId, logWeek);
        long totalMinutes=0;
        // 汇总时间
        for (Map<String,Object> r:logList){
            Long difference=DateUtil.between((Date) r.get("loginTime"),(Date) r.get("lastTime"),DateUnit.MINUTE);
            totalMinutes+=difference;
        }
        Map<String,Object> result=new HashMap<>(10);
        // 格式化为小时数
        double totalMinutesF=totalMinutes/60.0;
        DecimalFormat df =new DecimalFormat("#0.00");
        // 添加结果
        result.put("total",df.format(totalMinutesF));
        result.put("data",logList);
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
        return difference > 30 || (!startDay.equals(endDay));
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
}
