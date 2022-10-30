package com.edu.virtualschool.service;

import com.edu.virtualschool.dao.StudyRoomMapper;
import com.edu.virtualschool.entity.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: JunyuLiang
 * @Date: 2022/10/30 - 10 - 30 -10:34
 */
@Service
public class StudyRoomService {
    @Autowired
    StudyRoomMapper studyRoomMapper;

    public int uploadFile(int userId, String url, String contentType, String fileName, int assignmentId){
        return studyRoomMapper.uploadImage(userId, url, contentType, fileName, assignmentId);
    }
    public List<File> search(int id){
        return studyRoomMapper.searchFile(id);
    }
}
