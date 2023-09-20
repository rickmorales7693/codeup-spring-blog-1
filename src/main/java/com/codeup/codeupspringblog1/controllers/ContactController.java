package com.codeup.codeupspringblog1.controllers;


import com.codeup.codeupspringblog1.models.Contact;
import com.codeup.codeupspringblog1.repositories.ContactRepository;
import com.codeup.codeupspringblog1.services.CountSvc;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ContactController {

    // Constructor Dependency Injection
    private ContactRepository contactDao;
    private CountSvc countSvc;

    public ContactController(ContactRepository contactDao, CountSvc countSvc) {
        this.contactDao = contactDao;
        this.countSvc = countSvc;
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


    @GetMapping("/contacts/ads/count")
    @ResponseBody
    public long returnContactsAdsCount(){
        return countSvc.returnAdsContactsCount();
    }


}
