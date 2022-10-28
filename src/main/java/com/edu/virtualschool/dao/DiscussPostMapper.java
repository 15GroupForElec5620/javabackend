package com.edu.virtualschool.dao;

import com.edu.virtualschool.entity.DiscussPost;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: JunyuLiang
 * @Date: 2022/10/27 - 10 - 27 -22:07
 */
@Mapper
public interface DiscussPostMapper {

    void insertDiscussPost(DiscussPost discussPost);

    List<DiscussPost> selectDiscussPost();

}
