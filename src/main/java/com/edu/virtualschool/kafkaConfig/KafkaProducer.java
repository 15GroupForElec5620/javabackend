package com.edu.virtualschool.kafkaConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * @Author: JunyuLiang
 * @Date: 2022/10/26 - 10 - 26 -12:56
 */
@Component
public class KafkaProducer {
    @Autowired
    private KafkaTemplate kafkaTemplate;
    //处理事件
    public void addAnnouncement(String s){

        kafkaTemplate.send("announcement", s);
    }
    public void addDiscussPost(String s){

        kafkaTemplate.send("discussPost", s);
    }
}
