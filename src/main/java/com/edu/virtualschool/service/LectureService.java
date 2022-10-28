package com.edu.virtualschool.service;

import com.edu.virtualschool.dao.LectureMapper;
import com.edu.virtualschool.dao.elasticsearch.UserRepository;
import com.edu.virtualschool.entity.Lecture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: JunyuLiang
 * @Date: 2022/10/26 - 10 - 26 -21:15
 */
@Service
public class LectureService {
    @Autowired
    private LectureMapper lectureMapper;

    public List<Lecture> searchLecture(){
        return lectureMapper.selectLecture();
    }
    public void insertLecture(Lecture lecture){
        lectureMapper.insertLecture(lecture);
    }
}
