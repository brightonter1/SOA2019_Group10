package com.demo.cosmetic.User;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

public class UserController {
    private UserService userService;

    //Get all user
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    //Login controller
    @RequestMapping(value = "user/login",method = RequestMethod.GET)
    public void login(String username, String password){
        userService.loginUser(username,password);
    }

    //Register controller
    @RequestMapping(value = "user/register" , method = RequestMethod.POST)
    public void register(String fname,String lname,String user,String pass){
        userService.registerUser(fname,lname,user,pass);
    }

}
