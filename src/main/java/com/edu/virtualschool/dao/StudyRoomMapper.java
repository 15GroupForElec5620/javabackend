package com.edu.virtualschool.dao;

import com.edu.virtualschool.entity.File;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: JunyuLiang
 * @Date: 2022/10/30 - 10 - 30 -10:07
 */
@Mapper
public interface StudyRoomMapper {

    int uploadImage(int userId, String url1, String contentType, String fileName, int assignmentId);

    List<File> searchFile(int id);
}
