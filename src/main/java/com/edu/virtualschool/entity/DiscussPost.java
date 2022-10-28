package com.edu.virtualschool.entity;

import java.util.Date;

/**
 * @Author: JunyuLiang
 * @Date: 2022/10/27 - 10 - 27 -22:08
 */
public class DiscussPost {
    private int id;
    private String username;
    private String title;
    private String content;
    private Date createTime;

    public DiscussPost(int id, String username, String title, String content, Date createTime) {
        this.id = id;
        this.username = username;
        this.title = title;
        this.content = content;
        this.createTime = createTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
