package com.edu.virtualschool.dao;

import com.edu.virtualschool.entity.Lecture;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: JunyuLiang
 * @Date: 2022/10/26 - 10 - 26 -21:10
 */
@Mapper
public interface LectureMapper {
    List<Lecture> selectLecture();

    void insertLecture(Lecture lecture);
}
