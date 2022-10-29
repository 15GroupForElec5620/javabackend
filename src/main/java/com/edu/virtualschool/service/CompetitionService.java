package com.edu.virtualschool.service;

import com.edu.virtualschool.dao.CompetitionMapper;
import com.edu.virtualschool.entity.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: JunyuLiang
 * @Date: 2022/10/29 - 10 - 29 -12:11
 */
@Service
public class CompetitionService {
    @Autowired
    private CompetitionMapper competitionMapper;

    public File searchFile(String date){
        return competitionMapper.searchFile(date);
    }

}
