package com.edu.virtualschool.entity;

import java.util.Date;

/**
 * @Author: JunyuLiang
 * @Date: 2022/10/29 - 10 - 29 -21:45
 */
public class Score {
    private int assignmentId;
    private String content;
    private float score;
    private Date createTime;
    private int userId;

    public Score() {
    }

    public Score(int assignmentId, String content, float score, Date createTime, int userId) {
        this.assignmentId = assignmentId;
        this.content = content;
        this.score = score;
        this.createTime = createTime;
        this.userId = userId;
    }

    public int getAssignmentId() {
        return assignmentId;
    }

    public void setAssignmentId(int assignmentId) {
        this.assignmentId = assignmentId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
