package com.edu.virtualschool.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;
@Document(indexName = "user")
public class User {
    @Id
    public int id;
    @Field(type = FieldType.Text, analyzer = "ik_max_word", searchAnalyzer = "ik_smart")
    public String username;

    public String password;

    public String email;

    public Date createTime;

    public int type;
    private int activationCode;
    public User() {
    }

    public User(int id, String username, String password, String email, Date createTime, int type, int activationCode) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.createTime = createTime;
        this.type = type;
        this.activationCode = activationCode;
    }



    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", createTime=" + createTime +
                ", type=" + type +
                '}';
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


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getActivationCode() {
        return activationCode;
    }

    public void setActivationCode(int activationCode) {
        this.activationCode = activationCode;
    }
}
