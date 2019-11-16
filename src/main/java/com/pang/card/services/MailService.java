package com.pang.card.services;

import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import com.pang.card.common.result.ResultEnum;
import com.pang.card.common.result.ResultException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author pang
 * @version V1.0
 * @ClassName: MailService
 * @Package com.pang.card.services
 * @description:
 * @date 2019/10/29 13:16
 */
@Service
public class MailService {
    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private OnlineLogService onlineLogService;

    /**
     * 发送邮件
     *
     * @param userInfo 从数据库中提取的用户信息列表
     */
    @Async
    public void sendSimpleMail(Map<String, Object> userInfo) {
        try {
            javaMailSender.send(generateMail((String) userInfo.get("realName"),
                    (String) userInfo.get("userMail"),
                    (Long) userInfo.get("userId")));
        } catch (MessagingException e) {
            throw new ResultException(ResultEnum.SEND_MAIL_FAILED);
        }
    }


    /**
     * 生成邮件
     *
     * @param userName 用户名
     * @param userMail 用户邮箱
     * @param userId   用户id
     * @return
     * @throws MessagingException
     */
    private MimeMessage generateMail(String userName, String userMail, Long userId) throws MessagingException {
        // 获取签到信息
        Map<String, Object> onlineLogByWeek = onlineLogService.getOnlineLogByWeek(userId, null);
        // 获取签到日志列表
        List<Map<String, Object>> logList = (List) onlineLogByWeek.get("data");
        // 初始化message
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        // 设置往来地址
        helper.setFrom("xiaopangemm@163.com");
        helper.setTo(userMail);
        // 设置标题
        helper.setSubject("IOTAT:" + userName + "第" + onlineLogByWeek.get("week") + "周签到情况");
        // 如果本周没有签到情况
        if (onlineLogByWeek == null) {
            helper.setText("<h1>本周没有任何签到信息</h1>");
            return message;
        }
        // 下面是拼接邮件内容
        StringBuffer sb = new StringBuffer();
        sb.append("<h1>本周在线总时长：" + onlineLogByWeek.get("total") + "</h1>");
        sb.append("<table border=\"1\" class=\"gridtable\">");
        sb.append("<tr>" +
                "  <th>id</th>" +
                "  <th>签到时间</th>" +
                "  <th>离线时间</th>" +
                "  <th>时长（单位：h）</th>" +
                "</tr>");
        for (Map<String, Object> map : logList) {
            Date loginTime = (Date) map.get("loginTime");
            Date lastTime = (Date) map.get("lastTime");
            sb.append("<tr>");
            sb.append("<td>" + map.get("logId") + "</td>");
            sb.append("<td>" + DateUtil.format(loginTime, "yyyy-MM-dd HH:mm:ss") + "</td>");
            sb.append("<td>" + DateUtil.format(lastTime, "yyyy-MM-dd HH:mm:ss") + "</td>");
            sb.append("<td>" + onlineLogService.getHour(DateUtil.between(loginTime, lastTime, DateUnit.MINUTE)) + "</td>");
            sb.append("</tr>");
        }
        sb.append("</table>");
        sb.append("<style type=\"text/css\">" +
                "table.gridtable {" +
                "font-family: verdana,arial,sans-serif;" +
                "font-size:11px;" +
                "color:#333333;" +
                "border-width: 1px;" +
                "border-color: #666666;" +
                "border-collapse: collapse;" +
                "}" +
                "table.gridtable th {" +
                "border-width: 1px;" +
                "padding: 8px;" +
                "border-style: solid;" +
                "border-color: #666666;" +
                "background-color: #dedede;" +
                "}" +
                "table.gridtable td {" +
                "border-width: 1px;" +
                "padding: 8px;" +
                "border-style: solid;" +
                "border-color: #666666;" +
                "background-color: #ffffff;" +
                "}" +
                "</style>");

        helper.setText(sb.toString(), true);
        return message;
    }
}
