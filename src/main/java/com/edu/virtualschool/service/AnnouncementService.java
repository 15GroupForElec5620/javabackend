package com.edu.virtualschool.service;

import com.edu.virtualschool.dao.AnnouncementMapper;
import com.edu.virtualschool.entity.Announcement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: JunyuLiang
 * @Date: 2022/10/26 - 10 - 26 -16:37
 */
@Service
public class AnnouncementService {
    @Autowired
    private AnnouncementMapper announcementMapper;
    public void insertAnnouncement(Announcement announcement){
        announcementMapper.insertAnnouncement(announcement);
    }
    public List<Announcement> selectAnnouncement(){
        return announcementMapper.selectAnnouncement();
    }
}
