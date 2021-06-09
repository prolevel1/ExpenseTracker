package com.expense.Expensetracker.controller;

import com.expense.Expensetracker.model.User;
import com.expense.Expensetracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/users")
    public List<User> getAll()
    {
        return this.userService.getUser();
    }

    @GetMapping("/users/{id}")
    public User getById(int id)
    {
        User user=this.userService.getUserById(id);
        return user;
    }
    @PostMapping("/adduser")
    public ResponseEntity<String> addUser(@RequestBody User user)
    {
        this.userService.addUser(user);
        return new ResponseEntity<>("Added",HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") int id)
    {
        this.userService.deleteUser(id);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }
}
