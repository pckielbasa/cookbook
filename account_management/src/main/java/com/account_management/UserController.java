package com.account_management;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping( "/add")
    public String addUser(){
        userService.addUser();
        return "Dodano";
    }
    @GetMapping("/get")
    public String getString(){
        return "get";
    }
}

