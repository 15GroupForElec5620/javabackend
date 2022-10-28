package com.edu.virtualschool;

import com.edu.virtualschool.dao.UserMapper;
import com.edu.virtualschool.dao.elasticsearch.UserRepository;
import com.edu.virtualschool.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;
import java.util.Set;

/**
 * @Author: JunyuLiang
 * @Date: 2022/10/25 - 10 - 25 -16:26
 */
@SpringBootTest
@ContextConfiguration(classes = VirtualschoolApplication.class)
public class ElasticsearchTest {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserRepository userRepository;
    //@Autowired
    //ElasticsearchTemplate elasticsearchTemplate;

    @Test
    public void testInsert(){
        userMapper.selectById(9);
        //userRepository.save(userMapper.selectById(9));
        userRepository.save(userMapper.selectById(1));
        userRepository.save(userMapper.selectById(2));
        userRepository.save(userMapper.selectById(3));
    }
    @Test
    public void testInsert2(){
        Set<User> s = userRepository.findByUsername("james");
        for(User u : s){
            System.out.println(u);
        }
    }
}
