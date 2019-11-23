package com.pang.card;

import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import org.junit.Test;

import java.util.Date;

/**
 * @author pang
 * @version V1.0
 * @ClassName: ReUtilTest
 * @Package com.pang.card
 * @description:
 * @date 2019/10/28 11:36
 */
public class ReUtilTest {
    @Test
    public void test() {
        String dateStr1 = "2017-04-02 23:59:58";
        Date date1 = DateUtil.parse(dateStr1);

        String dateStr2 = "2017-04-01 23:59:59";
        Date date2 = DateUtil.parse(dateStr2);

        //相差一个月，31天
        long betweenDay = DateUtil.between(date1, date2, DateUnit.DAY);
        System.out.println(betweenDay);
    }
}
