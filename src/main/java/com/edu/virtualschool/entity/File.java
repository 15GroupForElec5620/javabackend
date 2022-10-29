package com.edu.virtualschool.entity;

import org.springframework.web.multipart.MultipartFile;

/**
 * @Author: JunyuLiang
 * @Date: 2022/10/26 - 10 - 26 -17:53
 */
public class File {
    private int id;
    private int usrId;
    private String url1;
    public String contentType;
    public String fileName;
    public File() {
    }

    public File(int id, int usrId, String url1, String contentType, String fileName) {
        this.id = id;
        this.usrId = usrId;
        this.url1 = url1;
        this.contentType = contentType;
        this.fileName = fileName;
    }

    @Override
    public String toString() {
        return "File{" +
                "id=" + id +
                ", usrId=" + usrId +
                ", url1='" + url1 + '\'' +
                ", contentType='" + contentType + '\'' +
                '}';
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
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

    public String getUrl1() {
        return url1;
    }

    public void setUrl1(String url1) {
        this.url1 = url1;
    }

}
