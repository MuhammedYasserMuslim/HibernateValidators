package com.spring.controller;

import com.spring.model.Person;
import com.spring.model.User;
import com.spring.services.PersonServices;
import com.spring.services.UserServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Validated // in class to valid pattern (request param)
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserServices userServices;

    @GetMapping("/count")
    public long count() {
        return userServices.count();
    }

    @GetMapping("/users")
    public List<User> findAll() {
        return userServices.findAll();
    }

    @GetMapping("/user")
    public Optional<User> findById(@RequestParam Long id) {
        return userServices.findById(id);
    }

    @PostMapping("/users")
    public User save(@RequestBody @Valid User user) {
        userServices.save(user);
        return user;
    }
    @PutMapping("/users")
    public User update(@RequestBody @Valid User user) {
        userServices.save(user);
        return user;
    }

    @DeleteMapping("/user")
    public User deleteById(@RequestParam Long id) {
        User user;
        user = userServices.findById(id).get();
        userServices.deleteById(id);
        return user;
    }
}
