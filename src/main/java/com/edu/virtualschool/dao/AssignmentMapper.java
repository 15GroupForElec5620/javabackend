package com.edu.virtualschool.dao;

import com.edu.virtualschool.entity.Assignment;
import com.edu.virtualschool.entity.AssignmentAnswer;
import org.apache.ibatis.annotations.Mapper;

import java.util.Set;

/**
 * @Author: JunyuLiang
 * @Date: 2022/10/29 - 10 - 29 -20:08
 */
@Mapper
public interface AssignmentMapper {

    void addAssignment(Assignment assignment);
    Assignment showAssignment();

    void insertAssignmentAnswer(AssignmentAnswer assignmentAnswer);

    Set<AssignmentAnswer> showAssignmentAnswers();

    void markAnswers(AssignmentAnswer assignmentAnswer);

    AssignmentAnswer showAssignmentResult(int userId);
}
