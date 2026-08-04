package com.blog.blogapi.controller;

import com.blog.blogapi.entity.User;
import com.blog.blogapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import com.blog.blogapi.repository.UserRepository;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

@RestController // Marks this class as a REST API controller
@RequestMapping("/users") // Base URL for all user endpoints
public class UserController {


    private final UserService userService;


    // Constructor injection for UserService
    public UserController(UserService userService) {
        this.userService = userService;
    }
    


    // GET /users
    // Returns all users from database
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
        
    }
     // GET user by id
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }



    /*  POST users and Creates a new user */
    @PostMapping
    public User createUser(@Valid @RequestBody User user) {
        return userService.createUser(user);
    }



   @PutMapping("/{id}")
public User updateUser(@PathVariable Long id,@Valid @RequestBody User user) {
    return userService.updateUser(id, user);
}


@DeleteMapping("/{id}")
public void deleteUser(@PathVariable Long id) {
    userService.deleteUser(id);
}
}