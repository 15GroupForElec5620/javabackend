package com.edu.virtualschool.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * @Author: JunyuLiang
 * @Date: 2022/10/26 - 10 - 26 -21:11
 */
@Document(indexName = "lecture")
public class Lecture {
    @Id
    private int id;
    @Field(type = FieldType.Text)
    private String title;
    @Field(type = FieldType.Text)
    private String zoomLink;

    public Lecture() {
    }

    @Override
    public String toString() {
        return "Lecture{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", zoomLink='" + zoomLink + '\'' +
                '}';
    }

    public Lecture(int id, String title, String zoomLink) {
        this.id = id;
        this.title = title;
        this.zoomLink = zoomLink;
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

    public String getZoomLink() {
        return zoomLink;
    }

    public void setZoomLink(String zoomLink) {
        this.zoomLink = zoomLink;
    }
}
