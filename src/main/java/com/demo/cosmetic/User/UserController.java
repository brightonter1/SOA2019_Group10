package com.demo.cosmetic.User;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

public class UserController {
    private UserService userService;

    //Get all user
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    //Login
    @RequestMapping("user/login")
    public void login(@RequeastBody String username,@RequeastBody  String password){

    }

}
