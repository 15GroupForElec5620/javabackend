package com.edu.virtualschool.controller;

import com.edu.virtualschool.entity.Assignment;
import com.edu.virtualschool.entity.AssignmentAnswer;
import com.edu.virtualschool.entity.File;
import com.edu.virtualschool.service.AssignmentService;
import com.edu.virtualschool.service.CompetitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Author: JunyuLiang
 * @Date: 2022/10/30 - 10 - 30 -15:47
 */
@Controller
@CrossOrigin(origins = "*")

public class AssignmentController {

    @Autowired
    AssignmentService assignmentService;
    @RequestMapping(path = "/addAssignment", method = RequestMethod.POST)
    @ResponseBody
    public void assAssignment(@RequestBody  Assignment assignment){

        assignmentService.addAssignment(assignment);
    }
    @RequestMapping(path = "/showAssignment", method = RequestMethod.GET)
    @ResponseBody
    public Assignment showAssignment(){
       return  assignmentService.showAssignment();
    }

    @RequestMapping(path = "/addAssignmentAnswer", method = RequestMethod.POST)
    @ResponseBody
    public void addAssignmentAnswer(@RequestBody AssignmentAnswer assignmentAnswer){
        assignmentService.insertAssignmentAnswer(assignmentAnswer);
    }

    @RequestMapping(path = "/showAssignmentAnswers", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> showAssignmentAnswers(){
        Map<String, Object> map = new HashMap<>();
        Set<AssignmentAnswer> set = assignmentService.showAssignmentAnswers();
        map.put("showAssignmentAnswers", set);
        return map;
    }

    @RequestMapping(path = "/markAssignmentAnswers", method = RequestMethod.POST)
    @ResponseBody
    public void markAnswers(int userId, int score, String comment, int id){
        System.out.println(userId);
        System.out.println(score);
        System.out.println(comment);
        AssignmentAnswer assignmentAnswer = new AssignmentAnswer(id, comment, score, userId, null);
        assignmentService.markAnswers(assignmentAnswer);
    }

    @RequestMapping(path = "/showAssignmentResults", method = RequestMethod.GET)
    @ResponseBody
    public AssignmentAnswer showAssignmentResults(int id){
        System.out.println(id);
        return assignmentService.showAssignmentResult(id);
    }
}
