package com.edu.virtualschool.service;

import com.edu.virtualschool.dao.AssignmentMapper;
import com.edu.virtualschool.entity.Assignment;
import com.edu.virtualschool.entity.AssignmentAnswer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @Author: JunyuLiang
 * @Date: 2022/10/30 - 10 - 30 -15:46
 */
@Service
public class AssignmentService {
    @Autowired
    AssignmentMapper assignmentMapper;

    public void addAssignment(Assignment assignment){
        assignmentMapper.addAssignment(assignment);
    }
    public Assignment showAssignment(){
        return assignmentMapper.showAssignment();
    }

    public void insertAssignmentAnswer(AssignmentAnswer assignmentAnswer){
        assignmentMapper.insertAssignmentAnswer(assignmentAnswer);
    }
    public Set<AssignmentAnswer> showAssignmentAnswers(){
        return assignmentMapper.showAssignmentAnswers();
    }

    public void markAnswers(AssignmentAnswer assignmentAnswer){
        assignmentMapper.markAnswers(assignmentAnswer);
    }
    public AssignmentAnswer showAssignmentResult(int userId){
        return assignmentMapper.showAssignmentResult(userId);
    }
}
