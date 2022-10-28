package com.edu.virtualschool.dao;

import com.edu.virtualschool.entity.Announcement;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: JunyuLiang
 * @Date: 2022/10/26 - 10 - 26 -16:32
 */
@Mapper
public interface AnnouncementMapper {
    void insertAnnouncement(Announcement announcement);
    List<Announcement> selectAnnouncement();
}
