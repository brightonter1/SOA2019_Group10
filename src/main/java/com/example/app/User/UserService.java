package com.example.app.User;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UserService {
    private List<User> users = new ArrayList<>(Arrays.asList(
            new User( "Pim", "Jaidee", "pimJaidee", "123456"),
            new User( "minmin", "adminmin", "admin", "123456")
    ));

    // Get all user
    public List<User> getAllUsers(){
        return users;
    }

    //Login Service
    public String loginUser(User user) {
        boolean state = false;
        for (int i = 0 ; i < users.size() ; i++){
            if ((users.get(i).getUsername().toLowerCase().equals(user.getUsername().toLowerCase()))
            && (users.get(i).getPassword().toLowerCase().equals(user.getPassword().toLowerCase()))
            ){
                state = true;
            }else{
                state = false;
            }
        }
        return state ? "Login Complete" : "Login Failed";
    }

    //Register Service
    public String registerUser(User user){
        users.add(user);
        return "Register Complete";
    }


}
