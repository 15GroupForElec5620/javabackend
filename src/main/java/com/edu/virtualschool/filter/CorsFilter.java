package com.edu.virtualschool.filter;

import org.apache.http.HttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Author: JunyuLiang
 * @Date: 2022/10/24 - 10 - 24 -23:08
 *
 */
@Component
public class CorsFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String contentType = httpServletRequest.getContentType();



        httpResponse.setHeader("Access-Control-Allow-Origin", "http://localhost:3000");//设置允许跨域的域名，需要发送cookie信息，所以此处需要指定具体的域名，
        httpResponse.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
        httpResponse.setHeader("Access-Control-Allow-Methods", "GET, PUT, DELETE, POST");//允许跨域的请求方式
        /**
         * ajax请求的时候如果带有xhrFields:{withCredentials:true}，
         * 那么服务器后台在配置跨域的时候就必须要把Access-Control-Allow-Credentials这个请求头加上去
         */
        httpResponse.setHeader("Access-Control-Allow-Credentials", "true");//允许发送Cookie信息
        httpResponse.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // 支持HTTP 1.1.
        httpResponse.setHeader("Pragma", "no-cache"); // 支持HTTP 1.0. response.setHeader("Expires", "0");
        chain.doFilter(request, response);

    }

    public void destroy() {
        // TODO Auto-generated method stub
    }

}
