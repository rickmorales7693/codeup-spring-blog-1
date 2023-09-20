package com.codeup.codeupspringblog1.services;

import com.codeup.codeupspringblog1.repositories.AdRepository;
import com.codeup.codeupspringblog1.repositories.ContactRepository;
import org.springframework.stereotype.Service;


@Service
public class CountSvc {

    private ContactRepository contactsDao;
    private AdRepository adsDao;

    public CountSvc(ContactRepository contactsDao, AdRepository adsDao) {
        this.contactsDao = contactsDao;
        this.adsDao = adsDao;
    }

    public long returnAdsContactsCount() {
        return contactsDao.count() + adsDao.count();
    }

}
