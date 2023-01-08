package com.example.demo.controller;

import com.example.demo.model.Info;
import com.example.demo.model.UserDetails;
import com.example.demo.model.UserLogin;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserInfoController {
    @Autowired
    private UserService service;

    @PostMapping("/add")
    public void add(@RequestBody Info info){
        service.add(info);
    }

    @PostMapping("/get")
    public Info getUser(@RequestBody UserLogin user){
     Info info =  service.getUser(user);
     return info;
    }
}
