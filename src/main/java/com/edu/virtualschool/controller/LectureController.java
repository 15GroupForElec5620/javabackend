package com.edu.virtualschool.controller;

import com.edu.virtualschool.entity.Lecture;
import com.edu.virtualschool.service.LectureService;
import com.edu.virtualschool.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    public void insertLecture(@RequestBody Lecture lecture){
        System.out.println(lecture);
        searchService.insertLecture(lecture);
    }
}
