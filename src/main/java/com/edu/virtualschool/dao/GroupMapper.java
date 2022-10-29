package com.edu.virtualschool.dao;

import com.edu.virtualschool.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: JunyuLiang
 * @Date: 2022/10/29 - 10 - 29 -13:02
 */
@Mapper
public interface GroupMapper {

    int searchGroup(int id);

    int insertGroup(int userId, int groupId);

    Integer searchIfExits(int id);

    void exitGroup(int userId);

    List<User> selectUsersById(int groupId);
}
