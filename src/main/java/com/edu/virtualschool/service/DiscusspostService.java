package com.edu.virtualschool.service;

import com.edu.virtualschool.dao.DiscussPostMapper;
import com.edu.virtualschool.entity.DiscussPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: JunyuLiang
 * @Date: 2022/10/27 - 10 - 27 -22:19
 */
@Service
public class DiscusspostService {
    @Autowired
    private DiscussPostMapper discussPostMapper;
    public void insertDiscussPost(DiscussPost discussPost){
        discussPostMapper.insertDiscussPost(discussPost);
    }
    public List<DiscussPost> selectDiscussPost(){
        return discussPostMapper.selectDiscussPost();
    }
}
