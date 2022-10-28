package com.edu.virtualschool.entity;

import java.util.Date;

/**
 * @Author: JunyuLiang
 * @Date: 2022/10/26 - 10 - 26 -16:24
 */
public class Announcement {
    public int id;
    public String title;
    public String content;
    public Date createTime;

    public Announcement() {
    }

    public Announcement(int assignment_id, String title, String content, Date create_time) {
        this.id = assignment_id;
        this.title = title;
        this.content = content;
        this.createTime = create_time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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
