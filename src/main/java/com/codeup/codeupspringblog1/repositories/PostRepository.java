package com.codeup.codeupspringblog1.repositories;

import com.codeup.codeupspringblog1.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
