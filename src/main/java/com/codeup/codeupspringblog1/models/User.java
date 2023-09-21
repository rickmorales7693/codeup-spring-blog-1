package com.codeup.codeupspringblog1.models;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;


@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id",columnDefinition = "int(11) UNSIGNED NOT NULL AUTO_INCREMENT", nullable = false)
    private Long id;


    @Column(name = "username", columnDefinition = "varchar(200) NOT NULL")
    private String username;


    @Column(name = "email", columnDefinition = "varchar(200) NOT NULL")
    private String email;


    @Column(name = "password", columnDefinition = "varchar(200) NOT NULL")
    private String password;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "user")
    private List<Post> post;


    public User() {
    }

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public User(Long id, String username, String email, String password) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public User(String username, String email, String password, List<Post> post) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.post = post;
    }

    public User(Long id, String username, String email, String password, List<Post> post) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.post = post;
    }

    public User(User copy){
        id = copy.id;
        email = copy.email;
        username = copy.username;
        password = copy.password;
    }








    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public List<Post> getPost() {
        return post;
    }

    public void setPost(List<Post> post) {
        this.post = post;
    }







}
