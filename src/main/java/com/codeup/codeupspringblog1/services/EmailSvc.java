package com.codeup.codeupspringblog1.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service("mailService")
public class EmailSvc {

@Autowired
    public JavaMailSender emailSender;

@Value("${spring.mail.from}")
    private String from;

}
