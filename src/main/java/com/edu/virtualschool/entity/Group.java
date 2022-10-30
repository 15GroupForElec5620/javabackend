package com.edu.virtualschool.entity;

/**
 * @Author: JunyuLiang
 * @Date: 2022/10/29 - 10 - 29 -23:56
 */
public class Group {
    private int groupId;

    private int num;

    public Group() {
    }

    public Group(int groupId, int num) {
        this.groupId = groupId;
        this.num = num;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
