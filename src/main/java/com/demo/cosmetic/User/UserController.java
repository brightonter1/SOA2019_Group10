package com.demo.cosmetic.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

//    //Get all user
//    public List<User> getAllUsers(){
//        return userService.getAllUsers();
//    }

    //Login controller
    @RequestMapping(value = "/user/login", method = RequestMethod.GET)
    public String login(@RequestBody User user){
        return userService.loginUser(user);
    }

    //Register controller
    @RequestMapping(value = "/user/register", method = RequestMethod.GET)
    public String register(@RequestBody User user){
        return userService.registerUser(user);
    }

    //Get All User
    @RequestMapping("/user")
    public List<User> getAllUser(){
        return userService.getAllUsers();
    }

}
