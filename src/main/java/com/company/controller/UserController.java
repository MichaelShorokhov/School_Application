package com.company.controller;

import com.company.entities.UserDetails;
import com.company.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@CrossOrigin
public class UserController {
    @Autowired
    UserServiceImpl service;


    @GetMapping(value = "/login")
    public Principal login(Principal user){
        return user;
    }
}
