package com.cosmetic.user.user.controller;

import com.cosmetic.user.user.dto.UserDTO;
import com.cosmetic.user.user.dto.UsernamePasswordDTO;
import com.cosmetic.user.user.response.CustomResponse;
import com.cosmetic.user.user.response.TokenResponse;
import com.cosmetic.user.user.service.UserService;
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
        return userService.signupService(userDTO);
    }

    @PostMapping("/signin")
    private ResponseEntity<TokenResponse> signin(@RequestBody UsernamePasswordDTO usernamePasswordDTO){
        return userService.signinService(usernamePasswordDTO);
    }

    @GetMapping()
}
