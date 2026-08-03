package com.blog.blogapi.repository;

import com.blog.blogapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    /* Repository layer responsible for database operations
 JpaRepository provides ready-made methods like:save(), findAll(), findById(), delete(), etc. */ 

}