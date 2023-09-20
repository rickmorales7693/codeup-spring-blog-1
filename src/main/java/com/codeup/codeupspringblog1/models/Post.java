package com.codeup.codeupspringblog1.models;

import com.codeup.codeupspringblog1.repositories.PostRepository;
import jakarta.persistence.*;
import lombok.Getter;


@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "int(11) UNSIGNED NOT NULL AUTO_INCREMENT", nullable = false)
    private Long id;

    @Column(name = "title", columnDefinition = "varchar(200) NOT NULL")
    private String title;

    @Column(name = "body", columnDefinition = "TEXT NOT NULL")
    private String body;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    public Post() {
    }

    public Post(String title, String body, User user) {
        this.title = title;
        this.body = body;
        this.user = user;
    }

    public Post(Long id, String title, String body, User user) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.user = user;
    }

    public Post(String title, String body) {
        this.title = title;
        this.body = body;
    }

    public Post(Long id, String title, String body) {
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBody(String body) {
        this.body = body;
    }


    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
