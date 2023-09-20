package com.codeup.codeupspringblog1.models;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "ads")
public class Ad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "int(11) UNSIGNED")
    private long id;

    @Column(length = 100, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String body;

    public Ad() {
    }

    public Ad(long id, String title, String body) {
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public Ad(String title, String body) {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }





}
