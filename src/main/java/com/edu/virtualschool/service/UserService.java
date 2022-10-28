package com.edu.virtualschool.service;

import com.edu.virtualschool.dao.UserMapper;
import com.edu.virtualschool.dao.elasticsearch.UserRepository;
import com.edu.virtualschool.entity.User;
import com.edu.virtualschool.util.CommunityUtil;
import com.edu.virtualschool.util.MailClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: Junyu Liang
 * version: 1.0
 */
@Service
public class UserService {
    @Autowired
    private TemplateEngine engine;

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private MailClient mailClient;

    @Value("${community.path.domain}")
    private String domain;
    @Value("${server.servlet.context-path}")
    private String contextPath;


    public User findUserById(int id){
        return userMapper.selectById(id);
    }

    public String register(User user){

        User u = userMapper.selectByEmail(user.getEmail());
        if(u != null){
            return  "account has already exists";
        }

        user.setPassword(CommunityUtil.md5(user.getPassword()));
        user.setType(1);
        user.setCreateTime(new Date());
        userMapper.insertUser(user);


        Context context = new Context();
        context.setVariable("email", user.getEmail());
        String url = domain + contextPath + "/activation/" + user.getId();
        context.setVariable("url", url);
        String content = engine.process("/mail/activation", context);
        System.out.println(user.getEmail()+"_------------------------------------------");
        mailClient.sendMail(user.getEmail(), "activate account", content);

        return "success";
    }
    public void activation(int userId){
        userMapper.updateUserActivation(userId);
    }
    public Map<String, Object> login(String email, String password){
        Map<String, Object> map = new HashMap<>();
        //account
        User user = userMapper.selectByEmail(email);
        if(user == null){
            map.put("errcode", "email is not correct");
            return map;
        }
        if(user.getActivationCode() == 0){
            map.put("errcode", "account is not activate please see your email");
            return map;
        }
        //valid password
        password = CommunityUtil.md5(password);
        if(!user.getPassword().equals(password)){
            map.put("errcode", "password is not correct");
            return map;
        }

        map.put("errcode", "success");
        map.put("userid", user.getId());
        map.put("type", user.getType());
        return map;
    }

    public User findUserByName(String username){
        return userMapper.selectByName(username);
    }
}
