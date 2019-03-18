package com.demo.cosmetic.User;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private ArrayList<User> users = new ArrayList<>(Arrays.asList(
            new User( "Pim", "Jaidee", "pimJaidee", "123456"),
            new User("Tommy", "K", "ttk34", "123456")
    ));

    // Get all user
    public ArrayList<User> getAllUsers(){
        return users;
    }

    //Login Service
    public String loginUser(String username,String password) {
        for (User row : users) {
            if (row.getUsername().equals(username)) {
                if (row.getPassword().equals(password)) {
                    return "Login Complete";
                } else {
                    return "Password is wrong!";
                }
            } else {
                return "No Username in the system";
            }
        }
        return "";
    }

    //Register Service
    public void registerUser(String fn,String ln,String un,String pw){
        users.add(new User(fn,ln,un,pw));
    }


}
