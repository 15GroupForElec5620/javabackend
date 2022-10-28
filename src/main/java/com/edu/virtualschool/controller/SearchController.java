package com.edu.virtualschool.controller;

import com.edu.virtualschool.dao.elasticsearch.LectureRepository;
import com.edu.virtualschool.entity.Lecture;
import com.edu.virtualschool.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 * @Author: JunyuLiang
 * @Date: 2022/10/25 - 10 - 25 -22:04
 */
@Controller
@CrossOrigin(origins = "*")
public class SearchController {
    @Autowired
    private SearchService searchService;
    @Autowired
    private LectureRepository lectureRepository;
    @RequestMapping(path = "/search", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> search(String username){
        System.out.println("11111111111111111111111");
        return searchService.searchName(username);
    }

    @RequestMapping(path = "/searchLectureByTitle", method = RequestMethod.GET)
    @ResponseBody
    public List<Lecture> searchLecture(String title){
        return lectureRepository.findByTitle(title);
    }
}
