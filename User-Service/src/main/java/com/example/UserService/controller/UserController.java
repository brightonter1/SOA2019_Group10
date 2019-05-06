package com.example.UserService.controller;


import com.example.UserService.dto.UserDTO;
import com.example.UserService.dto.UsernameEmailDTO;
import com.example.UserService.dto.UsernamePasswordDTO;
import com.example.UserService.response.CustomResponse;
import com.example.UserService.response.TokenResponse;
import com.example.UserService.service.TokenService;
import com.example.UserService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    TokenService tokenService;

    @PostMapping("/signup")
    public ResponseEntity<CustomResponse> signup(@RequestBody UserDTO userDTO) {
        return userService.signupService(userDTO);
    }

    @PostMapping("/signin")
    public ResponseEntity<TokenResponse> signin(@RequestBody UsernamePasswordDTO usernamePasswordDTO){
        return userService.signinService(usernamePasswordDTO);
    }

    @GetMapping("/information")
    public UsernameEmailDTO getUser(@RequestHeader (value = "Authorization") String token){
        return userService.getUserInfo(token);

    }

    @GetMapping("/signout")
    public ResponseEntity<CustomResponse> signoutServixe(){

        return new ResponseEntity<CustomResponse>(new CustomResponse("signed out"), HttpStatus.OK);
    }

}
