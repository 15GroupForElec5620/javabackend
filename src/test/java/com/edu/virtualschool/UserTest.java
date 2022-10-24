package com.edu.virtualschool;

import com.edu.virtualschool.dao.UserMapper;
import com.edu.virtualschool.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.Date;

@SpringBootTest
@ContextConfiguration(classes = VirtualschoolApplication.class)
public class UserTest {

    @Autowired
    UserMapper userMapper;

    @Test
    public void testUser(){
        User user = userMapper.selectById(101);
        System.out.println(user);

        User liubei = userMapper.selectByName("liubei");
        System.out.println(liubei);
    }

    @Test
    public void testUser1(){
        User user = new User();
        user.setUsername("test");
        user.setPassword("123456");
        user.setEmail("2128732478@qq.com");
        user.setCreateTime(new Date());
        int rows = userMapper.insertUser(user);
        System.out.println(rows);
        System.out.println(user.getId());
    }
}
