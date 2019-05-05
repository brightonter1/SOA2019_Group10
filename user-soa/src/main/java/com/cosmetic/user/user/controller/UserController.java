package com.cosmetic.user.user.controller;

import com.cosmetic.user.user.domain.UserDomain;
import com.cosmetic.user.user.dto.UserDTO;
import com.cosmetic.user.user.dto.UsernamePasswordDTO;
import com.cosmetic.user.user.response.CustomResponse;
import com.cosmetic.user.user.response.TokenResponse;
import com.cosmetic.user.user.service.TokenService;
import com.cosmetic.user.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/{username}")
    public String getUser(@RequestHeader (value = "Authorization") String token){
        System.out.println(tokenService.getUsernameFromToken(token) + "okay");
        return tokenService.getUsernameFromToken(token);

    }

}
