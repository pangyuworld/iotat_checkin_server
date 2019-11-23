package com.pang.card;

import com.pang.card.controller.OnlineLogController;
import com.pang.card.controller.UserController;
import com.pang.card.dao.OnlineLogDAO;
import com.pang.card.services.MailService;
import com.pang.card.services.OnlineLogService;
import com.pang.card.services.UserService;
import com.pang.card.task.SendMailTask;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CardApplicationTests {

    @Autowired
    private OnlineLogController controller;
    @Autowired
    private OnlineLogDAO dao;
    @Autowired
    private MailService service;
    @Autowired
    private UserService userService;
    @Autowired
    private OnlineLogService onlineLogService;
    @Autowired
    private UserController userController;
    @Autowired
    private SendMailTask task;

    @Test
    public void contextLoads() {
        task.sendMail();
    }


}
