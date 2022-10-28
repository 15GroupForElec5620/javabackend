package com.edu.virtualschool;

import com.edu.virtualschool.service.FileService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: JunyuLiang
 * @Date: 2022/10/26 - 10 - 26 -20:45
 */
@SpringBootTest
@ContextConfiguration(classes = VirtualschoolApplication.class)
public class FileTest {
    @Autowired
    FileService fileService;
    @Test
    public void test(){
        System.out.println(fileService.search() + "11111111111111111111111111111111111111111");
    }
    @Test
    protected void i(){
        System.out.println("2");
    }
}
