package com.edu.virtualschool;

import com.edu.virtualschool.dao.UserMapper;
import com.edu.virtualschool.dao.elasticsearch.UserRepository;
import com.edu.virtualschool.entity.Assignment;
import com.edu.virtualschool.entity.User;
import com.edu.virtualschool.service.AssignmentService;
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
        userRepository.save(userMapper.selectById(15));
       // userRepository.save(userMapper.selectById(2));
       // userRepository.save(userMapper.selectById(3));
    }
    @Test
    public void testInsert2(){
        Set<User> s = userRepository.findByUsername("111");
        for(User u : s){
            System.out.println(u);
        }
    }
    @Autowired
    AssignmentService assignmentService;
    @Test
    public void test3(){
        assignmentService.addAssignment(new Assignment(1, "1", "1"));
    }
}
