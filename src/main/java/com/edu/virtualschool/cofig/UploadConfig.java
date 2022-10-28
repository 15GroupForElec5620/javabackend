package com.edu.virtualschool.cofig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

/**
 * @Author: JunyuLiang
 * @Date: 2022/10/26 - 10 - 26 -22:12
 */
//@Configuration
//public class UploadConfig {
//    @Bean(name="multipartResolver")
//    public MultipartResolver multipartResolver(){
//        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
//        resolver.setDefaultEncoding("UTF-8");
//
//        resolver.setResolveLazily(true);
//        resolver.setMaxInMemorySize(40960);
//        //上传文件大小 50M 50*1024*1024
//        resolver.setMaxUploadSize(50 * 1024 * 1024);
//        return resolver;
//    }
//}