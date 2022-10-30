package com.edu.virtualschool.entity;

/**
 * @Author: JunyuLiang
 * @Date: 2022/10/29 - 10 - 29 -20:09
 */
public class Assignment {
    private int id;
    private String name;

    public Assignment() {
    }

    public Assignment(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
