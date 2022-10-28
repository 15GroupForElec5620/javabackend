package com.edu.virtualschool.controller;

import com.edu.virtualschool.entity.Lecture;
import com.edu.virtualschool.service.LectureService;
import com.edu.virtualschool.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author: JunyuLiang
 * @Date: 2022/10/26 - 10 - 26 -21:18
 */
@Controller
@CrossOrigin(origins = "*")

public class LectureController {
    @Autowired
    private LectureService lectureService;
    @Autowired
    private SearchService searchService;
    @RequestMapping(path = "/searchLecture", method = RequestMethod.GET)
    @ResponseBody
    public List<Lecture> searchLecture(){
        return lectureService.searchLecture();
    }

    @RequestMapping(path = "/insertLecture", method = RequestMethod.POST)
    @ResponseBody
    public void insertLecture(Lecture lecture){
        searchService.insertLecture(lecture);
    }
}
