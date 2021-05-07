package com.PWS.user.controller;

import com.PWS.user.VO.ResponseTemplateVO;
import com.PWS.user.entity.User;
import com.PWS.user.service.UserService;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public User saveUser(@RequestBody User user) {
        log.info("Inside saveUser of UserController");
        return userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public ResponseTemplateVO getUserWithDepartment(@PathVariable("id") Long userId) {
        log.info("Inside getUserWithDepartment of UserController");
        return userService.getUserWithDepartment(userId);
    }
    
    @GetMapping("/all")
    public List<User> getAllUserWithDepartment() {
        log.info("Inside getUserWithDepartment of UserController");
        return userService.getAllUserWithDepartment();
    }


    }
   
