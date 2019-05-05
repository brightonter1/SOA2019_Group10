package com.example.WishlistService.Controller;

import com.example.WishlistService.Service.UserService;
import com.example.WishlistService.dto.CustomResponse;
import com.example.WishlistService.dto.TokenResponse;
import com.example.WishlistService.dto.UserDTO;
import com.example.WishlistService.dto.UsernamePasswordDTO;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class AuthenticationController {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<CustomResponse> userSignup(@RequestBody UserDTO userDTO) {
        return userService.signup(userDTO);
    }

    @PostMapping("/signin")
    public ResponseEntity<TokenResponse> userSignin(@RequestBody UsernamePasswordDTO usernamePasswordDTO) {
        return userService.signin(usernamePasswordDTO);
    }


}
