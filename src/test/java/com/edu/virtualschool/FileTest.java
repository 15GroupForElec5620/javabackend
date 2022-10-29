package com.edu.virtualschool;

import com.edu.virtualschool.dao.CompetitionMapper;
import com.edu.virtualschool.entity.File;
import com.edu.virtualschool.service.FileService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
        List<File> list  = fileService.search();
                for(File file : list){
                    System.out.println(file);
                }
                ; }
    @Test
    protected void i(){
        System.out.println("2");
    }
    @Autowired
    CompetitionMapper competitionMapper;
    @Test
    public void test2(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String s = simpleDateFormat.format(new Date());
        System.out.println(s);
        competitionMapper.searchFile(s);
    }
}
