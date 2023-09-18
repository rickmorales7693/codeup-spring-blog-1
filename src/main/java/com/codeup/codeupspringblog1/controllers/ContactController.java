package com.codeup.codeupspringblog1.controllers;


import com.codeup.codeupspringblog1.models.Contact;
import com.codeup.codeupspringblog1.repositories.ContactRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ContactController {

    // Constructor Dependency Injection
    private ContactRepository contactDao;

    public ContactController(ContactRepository contactDao) {
        this.contactDao = contactDao;
    }

    @GetMapping("/contact")
    @ResponseBody
    public List<Contact> returnContacts() {
        return contactDao.findAll();
    }

    @GetMapping("/contact/view")
    public String viewContacts(Model model) {
        model.addAttribute("contacts", contactDao.findAll());
        return "contacts/index";
    }



}
