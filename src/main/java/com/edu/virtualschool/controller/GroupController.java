package com.edu.virtualschool.controller;

import com.edu.virtualschool.entity.User;
import com.edu.virtualschool.service.GroupService;
import com.edu.virtualschool.util.HostHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: JunyuLiang
 * @Date: 2022/10/29 - 10 - 29 -13:46
 */
@Controller
@CrossOrigin(origins = "*")
public class GroupController {
    @Autowired
    GroupService groupService;
    @Autowired
    HostHolder hostHolder;
    String joinGroup(int id){
        return groupService.joinGroup(hostHolder.getUser().getId(),id);
    }

    void exitGroup(){
        groupService.exitGroup(hostHolder.getUser().getId());
    }

    Map<String, Object> selectGroups(){
        Map<String, Object> map = new HashMap<>();
        for(int i = 1; i <= 3; i++){
            List<User> list = groupService.selectUsersById(i);
            map.put(String.valueOf(i), list);
        }
        return map;
    }
}
