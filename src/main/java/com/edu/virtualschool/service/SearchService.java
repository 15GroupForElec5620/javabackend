package com.edu.virtualschool.service;

import com.edu.virtualschool.dao.LectureMapper;
import com.edu.virtualschool.dao.UserMapper;
import com.edu.virtualschool.dao.elasticsearch.LectureRepository;
import com.edu.virtualschool.dao.elasticsearch.UserRepository;
import com.edu.virtualschool.entity.Lecture;
import com.edu.virtualschool.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.ws.Action;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Author: JunyuLiang
 * @Date: 2022/10/25 - 10 - 25 -21:54
 */
@Service
public class SearchService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    LectureRepository lectureRepository;
    @Autowired
    private LectureMapper lectureMapper;
    public void insertLecture(Lecture lecture){
        lectureMapper.insertLecture(lecture);
        lectureRepository.save(lecture);
    }
    public Map<String, Object> searchName(String name){
        Set<User> s = userRepository.findByUsername(name);
        Map<String, Object> map = new HashMap<>();
//        for(User u : s){
//            System.out.println(u);
//        }
        map.put("users", s);
        return map;
    }

    public void insertUser(User user){
        if(user != null){
            userRepository.save(user);
        }

    }
}
