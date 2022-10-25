package com.edu.virtualschool.controller;

import com.sun.deploy.net.HttpResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/login")
@CrossOrigin(origins = "*")
public class TestController {
    @RequestMapping("/register")
    public String sayHello(HttpResponse response){
        return "true";
    }
}
