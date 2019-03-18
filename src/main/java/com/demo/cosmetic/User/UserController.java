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

    // Search User by Key
    @RequestMapping("cosmetic/search/{keyword}")
    public List<User> searchKeyword(@PathVariable String keyword){
        return userService.searchUsersByKeyword(keyword.toLowerCase());
    }
}
