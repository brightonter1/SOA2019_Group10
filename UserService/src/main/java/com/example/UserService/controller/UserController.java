package com.example.UserService.controller;


import com.example.UserService.dto.UserDTO;
import com.example.UserService.response.CustomResponse;
import com.example.UserService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<CustomResponse> signup(@RequestBody UserDTO userDTO) {
        return userService.signup(userDTO);
    }
}