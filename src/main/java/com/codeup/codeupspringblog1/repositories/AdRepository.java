package com.codeup.codeupspringblog1.repositories;

import com.codeup.codeupspringblog1.models.Ad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AdRepository extends JpaRepository <Ad, Long>{
    List<Ad> findByOrderByTitle();

    // example of derived query
    Ad findByTitle(String title);

    // examples using JPQL / HQL
    Ad findAdById(long id);

    @Query("select title from Ad where LENGTH(title) < 10")
    List<String> getAdsOfCertainTitleLength();

    // using a native query
    @Query(nativeQuery = true, value = "SELECT title FROM ads WHERE LENGTH(title) < 10")
    List<String> getAdsOfCertainTitleLengthNative();


}
