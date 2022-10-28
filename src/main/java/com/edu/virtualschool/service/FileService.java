package com.edu.virtualschool.service;

import com.edu.virtualschool.dao.FileMapper;
import com.edu.virtualschool.entity.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: JunyuLiang
 * @Date: 2022/10/26 - 10 - 26 -17:47
 */
@Service
public class FileService {
    @Autowired
    private FileMapper fileMapper;
    public int uploadFile(int userId, String url, String contentType){
        return fileMapper.uploadFile(userId, url, contentType);
    }
    public List<String> search(){
        return fileMapper.searchFile();
    }
}
