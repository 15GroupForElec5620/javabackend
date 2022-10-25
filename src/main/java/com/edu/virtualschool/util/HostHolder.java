package com.edu.virtualschool.util;

import com.edu.virtualschool.entity.User;
import org.springframework.stereotype.Component;

/**
 * @Auther: Junyu Liang
 * @Date: 2022/9/18 - 09 - 18 - 17:03
 * @Description(package): com.newcoder.community.util
 * version: 1.0
 */

/**
 * 持有用户信息， 代替session对象
 */
@Component
public class HostHolder {
    private ThreadLocal<User> users = new ThreadLocal<>();

    public void setUser(User user){
        users.set(user);
    }
    public User getUser(){
        return users.get();
    }
    public void clear(){
        users.remove();
    }
}
