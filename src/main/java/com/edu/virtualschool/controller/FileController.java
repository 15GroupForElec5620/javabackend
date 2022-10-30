package com.edu.virtualschool.controller;

import com.edu.virtualschool.entity.FileUtil;
import com.edu.virtualschool.service.FileService;
import com.edu.virtualschool.service.UserService;
import com.edu.virtualschool.util.CommunityUtil;
import com.edu.virtualschool.util.HostHolder;
//import org.apache.commons.io.IOUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.activation.MimetypesFileTypeMap;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Author: JunyuLiang
 * @Date: 2022/10/26 - 10 - 26 -17:53
 */
@Controller
@CrossOrigin(origins = "*")
public class FileController {
    @Autowired
    private FileService fileService;
    @Value("${community.path.upload}")
    private String uploadPath;
    @Value("${community.path.domain}")
    private String doamin;
    @Value("${server.servlet.context-path}")
    private String contextPath;
    @Autowired
    private HostHolder hostHolder;


    @RequestMapping(path = "/uploadFile", method = RequestMethod.POST)
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
        if(!suffix.equals(".pdf") && !suffix.equals(".docx") && !suffix.equals(".doc")){
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
        //
        if(originalFilename.contains("competition")){
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            suffix = suffix + simpleDateFormat.format(new Date());
        }
        //
        //hostHolder.getUser().getId()
        fileService.uploadFile(1, uploadPath + File.separator + originalFilename, file.getContentType(), file.getOriginalFilename(), 0);
        try {
            file.transferTo(dest);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return "success";
    }
    @RequestMapping(path = "/downFile", method = RequestMethod.GET)
    @ResponseBody
    public void downFile(@RequestParam("url1") String url1, String fileName, String filetype, HttpServletResponse response, HttpServletRequest req) throws UnsupportedEncodingException {
//        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        // 设置信息给客户端不解析
//        String type = "application/pdf";
//        // 设置contenttype，即告诉客户端所发送的数据属于什么类型
//        response.setHeader("Content-type",type);
//        file = "d:\\work\\2.pdf";
//        // 设置编码
//        String hehe = new String(file.getBytes("utf-8"), "utf-8");
//        // 设置扩展头，当Content-Type 的类型为要下载的类型时 , 这个信息头会告诉浏览器这个文件的名字和类型。
//        response.setHeader("Content-Disposition", "attachment;filename=" + hehe);
//        response.setHeader("Access-Control-Expose-Headers",hehe);
//        try {
//            FileUtil.download(file, response);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
////        }
        System.out.println(fileName);
        System.out.println(filetype);
        System.out.println(url1+"33333333333333333333333333333333333333333333333");

        response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName,"UTF-8"));
        response.setHeader("Access-Control-Expose-Headers","filename");
        response.setContentType(filetype);
        System.out.println(fileName);
        try {
            //uploadPath + File.separator + file
            InputStream inputStream = new URL( "file:///" + url1).openStream();
            ServletOutputStream outputStream = response.getOutputStream();
            IOUtils.copy(inputStream, outputStream);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
    @RequestMapping(path = "/getFiles", method = RequestMethod.GET)
    @ResponseBody
    public List<com.edu.virtualschool.entity.File> searchFile(){
        System.out.println(1111);
        List<com.edu.virtualschool.entity.File> list = fileService.search();
        for(com.edu.virtualschool.entity.File file : list){
            System.out.println(file);
        }
        return list;
    }
}
