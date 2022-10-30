package com.edu.virtualschool.entity;

import java.util.Date;

/**
 * @Author: JunyuLiang
 * @Date: 2022/10/29 - 10 - 29 -21:45
 */
public class AssignmentAnswer {
    private int id;
    private String comment;
    private int score;
    private int userId;
    private String answer;
    public AssignmentAnswer() {
    }

    public AssignmentAnswer(int id, String comment, int score, int userId, String answer) {
        this.id = id;
        this.comment = comment;
        this.score = score;
        this.userId = userId;
        this.answer = answer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
