package com.edu.virtualschool.controller;

import com.edu.virtualschool.entity.Group;
import com.edu.virtualschool.entity.User;
import com.edu.virtualschool.service.GroupService;
import com.edu.virtualschool.util.HostHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.HashSet;
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

    @RequestMapping(path = "/joinGroup", method = RequestMethod.GET)
    @ResponseBody
    String joinGroup(int id, int userId){
        //System.out.println(id+"11111111111111");
        System.out.println(userId);
        //System.out.println(hostHolder.getUser().getId());
        return groupService.joinGroup(userId,id);
    }
    @RequestMapping(path = "/quitGroup", method = RequestMethod.GET)
    @ResponseBody
    String exitGroup(int userId){
        groupService.exitGroup(userId);
        return "success";
    }

    @RequestMapping(path = "/showGroups", method = RequestMethod.GET)
    @ResponseBody
    Map<String, Object> selectGroups(){
        Map<String, Object> map = new HashMap<>();
        HashSet set = new HashSet();
        for(int i = 1; i <= 3; i++){
            int num = groupService.selectUsersById(i);
            if(i == 1){
                set.add(new Group(1, num));
            }
            if(i == 2){
                set.add(new Group(2, num));
            }
            if(i == 3){
                set.add(new Group(3, num));
            }
        }
        map.put("groups", set);
        return map;
    }
}
