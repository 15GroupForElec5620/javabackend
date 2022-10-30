package com.edu.virtualschool.controller;

import com.alibaba.fastjson.JSONObject;
import com.edu.virtualschool.entity.Announcement;
import com.edu.virtualschool.kafkaConfig.KafkaProducer;
import com.edu.virtualschool.service.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: JunyuLiang
 * @Date: 2022/10/26 - 10 - 26 -16:46
 */
@Controller
@CrossOrigin(origins = "*")
public class AnnouncementController {
    @Autowired
    private KafkaProducer kafkaProducer;
    @Autowired
    private AnnouncementService announcementService;

    @RequestMapping(path = "/addAnnouncement", method = RequestMethod.POST)
    @ResponseBody
    public String insertAnnouncement(@RequestBody Announcement announcement){
        announcement.createTime = new Date();
        kafkaProducer.addAnnouncement(JSONObject.toJSONString(announcement));
        return "success";
    }
    @RequestMapping(path = "/searchAnnouncement", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> searchAnnouncement(){
        System.out.println("11111111111111111111111111111111");
        Map<String, Object> map = new HashMap<>();
        map.put("announcements", announcementService.selectAnnouncement());
        for (Object obj : map.values()){
            System.out.println(obj);
        }
        return map;
    }
}
