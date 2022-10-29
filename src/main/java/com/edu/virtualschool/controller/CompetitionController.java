package com.edu.virtualschool.controller;

import com.edu.virtualschool.entity.File;
import com.edu.virtualschool.service.CompetitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Author: JunyuLiang
 * @Date: 2022/10/29 - 10 - 29 -12:12
 */
@Controller
public class CompetitionController {
    @Autowired
    CompetitionService competitionService;
    @RequestMapping(path = "/getCompetitionFile", method = RequestMethod.GET)
    @ResponseBody
    public File searchFile(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String s = simpleDateFormat.format(new Date());
        File list = competitionService.searchFile(s);
        return list;
    }
}
