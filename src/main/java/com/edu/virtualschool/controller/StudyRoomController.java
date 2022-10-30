package com.edu.virtualschool.controller;

import com.edu.virtualschool.service.StudyRoomService;
import com.edu.virtualschool.util.CommunityUtil;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.SQLOutput;
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
    private String originalFileName = null;
    private String imageUrl = null;
    private String fileType = null;

    private long startTimeLong;
    @RequestMapping(path = "/uploadImage", method = RequestMethod.POST)
    @ResponseBody
    public String uploadFile(MultipartFile file){
        System.out.println("11111111111111111111111111111111111111111111111111111111111");

        if(file == null){
            File destDir = new File("C:/Users/admin/Desktop/py/animegan2-pytorch-main/animegan2-pytorch-main/samples/inputs"+File.separator);
            deleteFile(destDir);
            System.out.println("null");
            return "null";
        }
        startTimeLong = new Date().getTime();

        String originalFilename = file.getOriginalFilename();
        System.out.println(originalFilename);
        String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
        if(suffix == null || " ".equals(suffix) ){
            System.out.println("formate error");
            return "formate error";
        }
        if(!suffix.equals(".png") && !suffix.equals(".jpeg")){//png and jpeg is allowed
            System.out.println("formate error");
            return "formate error";
        }
        //50 mb
        if(file.getSize() > 1024 * 1024 * 50){
            System.out.println("too large");
            return "too large";
        }
        //C:/Users/admin/Desktop/py/animegan2-pytorch-main/animegan2-pytorch-main/samples/inputs
        File destDir = new File("D:/work/data/test"+File.separator);
        deleteFile(destDir);
        if(!destDir.exists()){
            destDir.mkdirs();
        }
        //
        originalFileName = originalFilename;
        fileType = file.getContentType();
        imageUrl = "D:/work/data/test"+File.separator+originalFilename;
        //
        //file path
        File dest = new File("D:/work/data/test"+File.separator+originalFilename);

        //hostHolder.getUser().getId()
//        studyRoomService.uploadFile(1, originalFilename, file.getContentType(), file.getOriginalFilename(), 0);
        try {
            file.transferTo(dest);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return "success";
    }
    @RequestMapping(path = "/downloadImageFile", method = RequestMethod.GET)
    @ResponseBody
    public void downFile(HttpServletResponse response, HttpServletRequest req) throws UnsupportedEncodingException {

//        System.out.println(fileName);
//        System.out.println(filetype);
//        System.out.println(url1+"33333333333333333333333333333333333333333333333");

        response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(originalFileName,"UTF-8"));
        response.setHeader("Access-Control-Expose-Headers","filename");
        response.setContentType(fileType);
        try {
            //uploadPath + File.separator + file
            InputStream inputStream = new URL( "file:///" + imageUrl).openStream();
            ServletOutputStream outputStream = response.getOutputStream();
            IOUtils.copy(inputStream, outputStream);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
    @RequestMapping(path = "/exitStudyRoom", method = RequestMethod.GET)
    @ResponseBody
    public double exitStudyRoom() {
        long currentTime = new Date().getTime();
        double hour = (currentTime - startTimeLong) / (1000);
        System.out.println(hour);
        return hour;
    }




    public void test(){
        Process proc;
        try {
            proc = Runtime.getRuntime().exec("python C:\\Users\\admin\\Desktop\\py\\animegan2-pytorch-main\\animegan2-pytorch-main\\img2ani2.py");// human
//            proc = Runtime.getRuntime().exec("python C:\\Users\\admin\\Desktop\\py\\AnimeGANv2-master\\AnimeGANv2\\img2anime.py");//scene
            //用输入输出流来截取结果
            BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream()));
            String line = null;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
            in.close();
            proc.waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    public Boolean deleteFile(File file) {
        //判断文件不为null或文件目录存在
        if (file == null || !file.exists()) {
            System.out.println("文件删除失败,请检查文件是否存在以及文件路径是否正确");
            return false;
        }
        //获取目录下子文件
        File[] files = file.listFiles();
        //遍历该目录下的文件对象
        for (File f : files) {
            //判断子目录是否存在子目录,如果是文件则删除
            if (f.isDirectory()) {
                //递归删除目录下的文件
                deleteFile(f);
            } else {
                //文件删除
                f.delete();
                //打印文件名
                System.out.println("文件名：" + f.getName());
            }
        }
        //文件夹删除
        file.delete();
        System.out.println("目录名：" + file.getName());
        return true;
    }
}
