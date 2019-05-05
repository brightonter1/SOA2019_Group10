package com.example.UserService.controller;


import com.example.UserService.model.User;
import com.example.UserService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/login")
    public String login(User user) throws  NoSuchAlgorithmException{

        return userService.login(new User("game", "game"));
    }

    @GetMapping("/user/register/{message}")
    public String getEncode(@PathVariable String message) throws NoSuchPaddingException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, InvalidKeyException, ClassNotFoundException {
        return userService.getEncode(message);
    }


}