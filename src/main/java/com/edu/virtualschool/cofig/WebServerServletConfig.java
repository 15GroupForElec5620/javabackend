package com.edu.virtualschool.cofig;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.MultipartConfigElement;

/**
 * @Author: JunyuLiang
 * @Date: 2022/10/27 - 10 - 27 -8:26
 */
//@Configuration
//public class WebServerServletConfig {
//    private String serviceApiPath = "localhost:8080/virtualschool";
//
//    private final MultipartConfigElement multipartConfig;
//
//    public WebServerServletConfig(ObjectProvider<MultipartConfigElement> multipartConfigProvider) {
//        this.multipartConfig = multipartConfigProvider.getIfAvailable();
//    }
//
//    @Bean
//    public ServletRegistrationBean<DispatcherServlet> webServletBean(WebApplicationContext wac) {
//        String servletName = serviceApiPath.replaceAll("/", "") + "Servlet";
//
//        String servletMappings = serviceApiPath + (serviceApiPath.endsWith("/") ? "*" : "/*");
//        DispatcherServlet ds = new DispatcherServlet(wac);
//        ServletRegistrationBean<DispatcherServlet> bean = new ServletRegistrationBean<>(ds,servletMappings);
//        bean.setName(servletName);
//        if (this.multipartConfig != null) {
//            bean.setMultipartConfig(this.multipartConfig);
//        }
//        return bean;
//    }
//}
