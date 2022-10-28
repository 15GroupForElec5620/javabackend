package com.edu.virtualschool.entity;

import org.springframework.web.multipart.MultipartFile;

/**
 * @Author: JunyuLiang
 * @Date: 2022/10/26 - 10 - 26 -17:53
 */
public class File {
    private int id;
    private int usrId;
    private String url;
    public String contentType;


    public File(int id, int usrId, String url, String contentType) {
        this.id = id;
        this.usrId = usrId;
        this.url = url;
        this.contentType = contentType;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUsrId() {
        return usrId;
    }

    public void setUsrId(int usrId) {
        this.usrId = usrId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
