package com.edu.virtualschool.dao;

import com.edu.virtualschool.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    User selectById( int id);
    User selectByName(String username);
    User selectByEmail(String email);
    int insertUser(User user);
    int updatePassword(int id, String password);

    void updateUserActivation(int id);
    int selectUserActivation(int id);
}
