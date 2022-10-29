package com.edu.virtualschool.dao;

import com.edu.virtualschool.entity.File;
import org.apache.ibatis.annotations.Mapper;

import java.text.SimpleDateFormat;
import java.util.List;

@Mapper
public interface CompetitionMapper {
    File searchFile(String date);
}
