package com.pang.card.task;

import com.pang.card.services.MailService;
import com.pang.card.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author pang
 * @version V1.0
 * @ClassName: SendMailTask
 * @Package com.pang.card.task
 * @description: 发送邮件任务调度器
 * @date 2019/10/29 13:02
 */
@Component
public class SendMailTask {
    @Autowired
    private MailService mailService;
    @Autowired
    private UserService userService;

    // @Scheduled(cron = "0 00 21 ? * SUN")
    @Scheduled(cron = "0 0 0 */1 * ?")
    public void sendMail() {
        List<Map<String, Object>> userInfoList = userService.getAllUserInfo();
        for (Map<String, Object> map : userInfoList) {
            mailService.sendSimpleMail(map);
        }
    }
}
