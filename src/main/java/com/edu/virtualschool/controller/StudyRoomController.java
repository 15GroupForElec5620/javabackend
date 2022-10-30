package com.edu.virtualschool.controller;

import com.edu.virtualschool.service.StudyRoomService;
import com.edu.virtualschool.util.CommunityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: JunyuLiang
 * @Date: 2022/10/30 - 10 - 30 -10:40
 */
@Controller
public class StudyRoomController {
    @Autowired
    private StudyRoomService studyRoomService;
    @Value("${community.path.upload}")
    private String uploadPath;

    @RequestMapping(path = "/uploadImage", method = RequestMethod.POST)
    @ResponseBody
    public String uploadFile(MultipartFile file){
        System.out.println("11111111111111111111111111111111111111111111111111111111111");
        if(file == null){
            System.out.println("null");
            return "null";
        }

        String originalFilename = file.getOriginalFilename();
        System.out.println(originalFilename);
        String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
        if(suffix == null || " ".equals(suffix) ){
            System.out.println("formate error");
            return "formate error";
        }
        if(!suffix.equals(".png")){
            System.out.println("formate error");
            return "formate error";
        }
        //50 mb
        if(file.getSize() > 1024 * 1024 * 50){
            System.out.println("too large");
            return "too large";
        }
        File destDir = new File(uploadPath + File.separator);
        if(!destDir.exists()){
            destDir.mkdirs();
        }
        //random name
        originalFilename = CommunityUtil.generateUUID() + suffix;
        System.out.println("22222222222222222222222222222222222222222222222222222");
        //file path
        File dest = new File(uploadPath + File.separator + originalFilename);

        //hostHolder.getUser().getId()
        studyRoomService.uploadFile(1, uploadPath + File.separator + originalFilename, file.getContentType(), file.getOriginalFilename(), 0);
        try {
            file.transferTo(dest);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return "success";
    }
}
