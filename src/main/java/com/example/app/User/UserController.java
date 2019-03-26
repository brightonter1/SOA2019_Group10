package com.example.app.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
    @RequestMapping(value = "/user/register", method = RequestMethod.POST)
    public String register(@RequestBody User user){
        return userService.registerUser(user);
    }

    //Get All User
    @RequestMapping("/user")
    public List<User> getAllUser(){
        return userService.getAllUsers();
    }

}
