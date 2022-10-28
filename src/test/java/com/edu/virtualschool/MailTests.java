package com.edu.virtualschool;

import com.edu.virtualschool.dao.AnnouncementMapper;
import com.edu.virtualschool.entity.Announcement;
import com.edu.virtualschool.util.MailClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @Auther: Junyu Liang
 * @Date: 2022/9/16 - 09 - 16 - 17:20
 * @Description(package): com.newcoder.community
 * version: 1.0
 */
@SpringBootTest
@ContextConfiguration(classes = VirtualschoolApplication.class)
public class MailTests {
    @Autowired
    private MailClient mailClient;

    @Autowired
    private TemplateEngine templateEngine;

    @Test
    public void testTextMail(){
        mailClient.sendMail("2128732478@qq.com", "Test", "hello");
    }
    @Test
    public void testHtmlMail(){
        Context context = new Context();
        context.setVariable("username", "sunday");
        String content = templateEngine.process("/mail/demo", context);
        System.out.println(content);
        mailClient.sendMail("n10889671@qut.edu.au", "Test1", content);
    }
    @Autowired
    AnnouncementMapper announcementMapper;
    @Test
    public void t(){
        Announcement announcement = new Announcement();
        announcement.title = "2";
        announcement.createTime = new Date();
        announcementMapper.insertAnnouncement(announcement);
    }
}
