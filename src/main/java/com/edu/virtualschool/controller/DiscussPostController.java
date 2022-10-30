package com.edu.virtualschool.controller;

import com.alibaba.fastjson.JSONObject;
import com.edu.virtualschool.entity.DiscussPost;
import com.edu.virtualschool.kafkaConfig.KafkaProducer;
import com.edu.virtualschool.service.DiscusspostService;
import com.edu.virtualschool.util.HostHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: JunyuLiang
 * @Date: 2022/10/27 - 10 - 27 -22:22
 */
@Controller
@CrossOrigin(origins = "*")
public class DiscussPostController {
    @Autowired
    private DiscusspostService discusspostService;
    @Autowired
    private HostHolder hostHolder;
    @Autowired
    private KafkaProducer kafkaProducer;
    @RequestMapping(path = "/addDiscussPost", method = RequestMethod.POST)
    @ResponseBody
    public String addDiscussPost(@RequestBody DiscussPost discussPost){
        System.out.println(discussPost);
        discussPost.setCreateTime(new Date());
        kafkaProducer.addDiscussPost(JSONObject.toJSONString(discussPost));
        return "success";
    }
    @RequestMapping(path = "/searchDiscussPost", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> searchDiscussPost(){
        Map<String, Object> map = new HashMap<>();
        map.put("discussPost", discusspostService.selectDiscussPost());
        for (Object obj : map.values()){
            System.out.println(obj);
        }
        return map;
    }
}
