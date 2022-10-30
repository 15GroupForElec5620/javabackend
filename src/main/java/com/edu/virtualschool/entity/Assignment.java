package com.edu.virtualschool.entity;

/**
 * @Author: JunyuLiang
 * @Date: 2022/10/29 - 10 - 29 -20:09
 */
public class Assignment {
    private int id;
    private String title;
    private String content;

    public Assignment() {
    }

    public Assignment(int id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
