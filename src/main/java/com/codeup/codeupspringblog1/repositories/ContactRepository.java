package com.codeup.codeupspringblog1.repositories;

import com.codeup.codeupspringblog1.models.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {
}
