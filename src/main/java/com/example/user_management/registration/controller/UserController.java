package com.example.user_management.registration.controller;

import com.example.user_management.registration.entity.User;
import com.example.user_management.registration.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
   @GetMapping
    private List<User> getAllUsers(){
        return userService.getAllUsers();
   }
  @GetMapping("/{userId}")
   private Optional<User> getUserById(@PathVariable Long userId){
        return userService.getUserById(userId);

   }
  @PostMapping
    private User createUser(@RequestBody User user){
        return userService.createUser(user);
  }

 @PutMapping("/{userId}")
    private User updateUser(@PathVariable Long userId, @RequestBody User user){
        return userService.updateUser(userId, user);
 }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
    }

}
