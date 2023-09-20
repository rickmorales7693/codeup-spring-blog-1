package com.codeup.codeupspringblog1.controllers;

import com.codeup.codeupspringblog1.models.Ad;
import com.codeup.codeupspringblog1.repositories.AdRepository;
import com.codeup.codeupspringblog1.services.EmailSvc;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class AdController {

    private AdRepository adsDao;
    private EmailSvc emailSvc;

    public AdController(AdRepository adsDao, EmailSvc emailSvc){
        this.adsDao = adsDao;
        this.emailSvc = emailSvc;
    }

    @GetMapping("/test")
    @ResponseBody
    public String returnTest() {
        return "Test";
    }

    @GetMapping("/ads")
    @ResponseBody
    public List<Ad> returnAds() {
        return adsDao.findAll();
    }

    @GetMapping("/ads/{id}")
    @ResponseBody
    public Ad returnAd(@PathVariable Long id) {
        return adsDao.findAdById(id);
    }

    @GetMapping("/ads/create")
    public String createAd(Model model) {
        // if we were editing an ad...
        // Ad adToEdit = adsDao.findById(1L).get();
        // model.addAttribute("ad", adToEdit);
        model.addAttribute("ad", new Ad());
        return "ads/create";
    }

    @PostMapping("/ads/create")
    public String insertAd(@ModelAttribute Ad ad) {
        Ad adToSave = new Ad(
                ad.getTitle(),
                ad.getBody()
        );
        adsDao.save(adToSave);
        emailSvc.prepareAndSend(adToSave, "You created an ad!!", "Here is some more information about the ad you created... yay.");
        return "redirect:/ads";
    }







}
