package com.blog.blogapi.service;

import com.blog.blogapi.entity.User;
import com.blog.blogapi.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service   //Marks this class as a Service layer component managed by Spring
public class UserService {

// Dependency on UserRepository to communicate with the database
    private final UserRepository userRepository;



    // Constructor injection: Spring automatically provides UserRepository object
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

public User updateUser(Long id, User updatedUser) {

    User user = userRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("User not found"));

    user.setName(updatedUser.getName());
    user.setEmail(updatedUser.getEmail());
    user.setPassword(updatedUser.getPassword());

    return userRepository.save(user);
}
     
public void deleteUser(Long id) {
    userRepository.deleteById(id);
}
    public List<User> getAllUsers() {
        return userRepository.findAll(); 
        /* Retrieves all users from the database
         Calls JpaRepository's built-in findAll() method
         Equivalent SQL: SELECT * FROM users;
        */ 
    }


    public User createUser(User user) {
        return userRepository.save(user);
        /*Creates a new user and saves it in the database
         Calls JpaRepository's save() method
         Equivalent SQL: INSERT INTO users VALUES (...);*/
    }
}