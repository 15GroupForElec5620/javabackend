package com.edu.virtualschool.service;

import com.edu.virtualschool.dao.GroupMapper;
import com.edu.virtualschool.entity.User;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: JunyuLiang
 * @Date: 2022/10/29 - 10 - 29 -13:22
 */
@Service
public class GroupService {
    @Autowired
    GroupMapper groupMapper;

    public String joinGroup(int userId, int id){
        if(groupMapper.searchIfExits(id) != null){
            return "you have already in a group";
        }
        int count = groupMapper.searchGroup(id);
        if(count > 5){
            return "group is full";
        }else{
            groupMapper.insertGroup(userId, id);
            return "success";
        }
    }

    public void exitGroup(int userId){
        groupMapper.exitGroup(userId);
    }
    public List<User> selectUsersById(int groupId){
        return groupMapper.selectUsersById(groupId);
    }
}
