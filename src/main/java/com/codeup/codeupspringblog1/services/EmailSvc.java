package com.codeup.codeupspringblog1.services;


import com.codeup.codeupspringblog1.models.Ad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service("mailService")
public class EmailSvc {

    private JavaMailSender javaMailSender;

    public EmailSvc(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Value("${spring.mail.from}")
    private String from;

    public void prepareAndSend(Ad ad, String subject, String body){
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setFrom(from);
        msg.setTo("user@email.com");
        msg.setSubject(subject);
        msg.setText(body);
        try{
            this.javaMailSender.send(msg);
        } catch (MailException ex){
            System.err.println(ex.getMessage());
        }
    }



}
