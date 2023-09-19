package com.codeup.codeupspringblog1.repositories;

import com.codeup.codeupspringblog1.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
