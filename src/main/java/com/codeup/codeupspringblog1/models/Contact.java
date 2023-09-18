package com.codeup.codeupspringblog1.models;


import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name = "contacts")
public class Contact {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String email;

    public Contact() {
    }

    public Contact(long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
