package com.edu.virtualschool.kafkaConfig;

import com.alibaba.fastjson.JSONObject;
import com.edu.virtualschool.entity.Announcement;
import com.edu.virtualschool.entity.DiscussPost;
import com.edu.virtualschool.service.AnnouncementService;
import com.edu.virtualschool.service.DiscusspostService;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @Author: JunyuLiang
 * @Date: 2022/10/26 - 10 - 26 -13:04
 */
@Component
public class KafkaConsumer {
    @Autowired
    private AnnouncementService announcementService;
    @Autowired
    private DiscusspostService discusspostService;
    @KafkaListener(topics = {"announcement"})
    public void handleCommentMessage(ConsumerRecord record){
        if(record == null || record.value() == null){
            return;
        }
        Announcement announcement = JSONObject.parseObject(record.value().toString(), Announcement.class) ;
        if(announcement == null){
            return;
        }
        System.out.println(("-------------------------------------------------"));
        announcementService.insertAnnouncement(announcement);
    }
    @KafkaListener(topics = {"discussPost"})
    public void handleCommentMessage2(ConsumerRecord record){
        if(record == null || record.value() == null){
            return;
        }
        DiscussPost discussPost = JSONObject.parseObject(record.value().toString(), DiscussPost.class) ;
        if(discussPost == null){
            return;
        }
        System.out.println(("-------------------------------------------------"));
        discusspostService.insertDiscussPost(discussPost);
    }
}
