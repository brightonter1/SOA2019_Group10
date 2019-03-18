package com.demo.cosmetic.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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
    @RequestMapping("/user/login")
    public String login(String username, String password){
        return userService.loginUser(username,password);
    }

    //Register controller
    @RequestMapping("/user/register")
    public void register(String fname,String lname,String user,String pass){
        userService.registerUser(fname,lname,user,pass);
    }

}
