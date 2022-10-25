
package com.edu.virtualschool.controller;
import com.edu.virtualschool.entity.User;

import com.edu.virtualschool.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: Junyu Liang
 * @Date: 2022/9/16 - 09 - 16 - 22:41
 * version: 1.0
 */
@Controller
@CrossOrigin(origins = "*")
public class LoginController {
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
    @Autowired
    private UserService userService;

    @RequestMapping(path = "/register", method = RequestMethod.POST)
    @ResponseBody
    public String register(@RequestBody  User user){
        return  userService.register(user);
    }

    @RequestMapping(path = "/activation/{userId}", method = RequestMethod.GET)
    @ResponseBody
    public String activation(@PathVariable("userId") int userId){
        userService.activation(userId);
        return "active success";
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> login(@RequestBody  User user){
        return userService.login(user.getEmail(), user.getPassword());
    }

}

