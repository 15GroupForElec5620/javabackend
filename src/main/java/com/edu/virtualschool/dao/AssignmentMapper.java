package com.edu.virtualschool.dao;

import com.edu.virtualschool.entity.Assignment;
import com.edu.virtualschool.entity.File;
import com.edu.virtualschool.entity.Score;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: JunyuLiang
 * @Date: 2022/10/29 - 10 - 29 -20:08
 */
@Mapper
public interface AssignmentMapper {

    void addAssignment(Assignment assignment);

    void deleteAssignment(int id);

    List<Assignment> searchAssignment();

    int uploadFile(int userId, String url, String contentType, String fileName);

    List<File> selectFile();

    void insertMark(int userId, float score);

    Score selectMark(int userId, int assignment_id);
}
