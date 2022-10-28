package com.edu.virtualschool;

import com.alibaba.fastjson.JSONObject;
import com.edu.virtualschool.entity.Announcement;
import com.edu.virtualschool.event.KafkaProducer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;

import java.util.Date;

/**
 * @Author: JunyuLiang
 * @Date: 2022/10/26 - 10 - 26 -12:21
 */
@SpringBootTest
@ContextConfiguration(classes = VirtualschoolApplication.class)
public class KafkaTest {
    @Autowired
    private KafkaProducer kafkaProducer;
    @Test
    public void testKafka(){
        Announcement announcement = new Announcement();
        announcement.content = "3";
        announcement.title = "3";
        announcement.createTime = new Date();
        kafkaProducer.addAnnouncement(JSONObject.toJSONString(announcement));
        try {
            Thread.sleep(1000*10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
//@Component
//class KafkaProducer{
//    @Autowired
//    private KafkaTemplate kafkaTemplate;
//    public void sendMessage(String topic, String content){
//        kafkaTemplate.send(topic, content);
//    }
//
//}
//@Component
//class KafkaConsumer{
//    @KafkaListener(topics = {"test"})
//    public void handleMessage(ConsumerRecord record){
//        System.out.println(record.value());
//    }
//
//
//}