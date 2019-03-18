package com.demo.cosmetic.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UserService {

    private User user;

    private List<User> users = new ArrayList<>(Arrays.asList(
            new User( "Pim", "Jaidee", "pimJaidee", "123456"),
            new User("Tommy", "K", "ttk34", "123456")
    ));

    // Get all user
    public List<User> getAllUsers(){
        return users;
    }

    //Login Service
    public void loginUser(String username,String password) {

    }
    //Register Service
    public void registerUser(){

    }
}
