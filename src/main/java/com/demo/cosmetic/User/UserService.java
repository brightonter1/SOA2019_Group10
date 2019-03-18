package com.demo.cosmetic.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UserService {

    private User user;

    private List<User> users = new ArrayList<>(Arrays.asList(
            new User(001, "Pim", "Jaidee", "pimJaidee", "123456"),
            new User(001, "Tommy", "K", "ttk34", "123456")
    ));

    // Get all user
    public List<User> getAllUsers(){
        return users;
    }

    //Login
    public void loginUser(String userKey,String passwordKey){
        List<User> password =  users.stream()
                .filter(c -> c.getPassword().toLowerCase().equals(userKey))
                .collect(Collectors.toList());
        if (passwordKey.equals(password)){
            
        }
    }
    //Register
    public void registerUser(String user){

    }
}
