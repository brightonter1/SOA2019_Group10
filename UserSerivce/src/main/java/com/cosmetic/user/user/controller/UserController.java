package com.cosmetic.user.user.controller;

import com.cosmetic.user.user.dto.UserDTO;
import com.cosmetic.user.user.dto.UsernameEmailDTO;
import com.cosmetic.user.user.dto.UsernamePasswordDTO;
import com.cosmetic.user.user.response.CustomResponse;
import com.cosmetic.user.user.response.TokenResponse;
import com.cosmetic.user.user.service.TokenService;
import com.cosmetic.user.user.service.UserService;
import org.apache.tomcat.util.http.parser.Authorization;
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

    @GetMapping
    public String SayHello(){
        return "Hello User-serive";
    }

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
