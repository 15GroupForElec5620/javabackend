package com.edu.virtualschool.dao;

import com.edu.virtualschool.entity.File;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: JunyuLiang
 * @Date: 2022/10/26 - 10 - 26 -17:50
 */
@Mapper
public interface FileMapper {

    int uploadFile(int userId, String url, String contentType);

    List<String> searchFile();
}
