package com.codeup.codeupspringblog1.services;

import com.codeup.codeupspringblog1.repositories.AdRepository;
import com.codeup.codeupspringblog1.repositories.ContactRepository;

public class CountSvc {

    private ContactRepository contactsDao;
    private AdRepository adsDao;

    public CountSvc(ContactRepository contactsDao, AdRepository adsDao) {
        this.contactsDao = contactsDao;
        this.adsDao = adsDao;
    }

//    public long returnAdsContactsCount() {
//        return contactsDao.count() + adsDao.count();
//    }

}
