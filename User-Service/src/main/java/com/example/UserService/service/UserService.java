package com.example.UserService.service;


import com.example.UserService.domain.UserDomain;
import com.example.UserService.dto.UserDTO;
import com.example.UserService.dto.UsernameEmailDTO;
import com.example.UserService.dto.UsernamePasswordDTO;
import com.example.UserService.repository.UserRepository;
import com.example.UserService.response.CustomException;
import com.example.UserService.response.CustomResponse;
import com.example.UserService.response.TokenResponse;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    TokenService tokenService;

    private static final String SECERT_KEY = "bright";

    public ResponseEntity<CustomResponse> signupService(UserDTO userDTO) {
        if (!userRepository.existsByUsername(userDTO.getUsername())) {
            UserDomain userDomain = new UserDomain(userDTO.getUsername(), userDTO.getEmail());
            userDomain.setPassword(passwordEncoder.encode(userDTO.getPassword()));
            userRepository.save(userDomain);

            return new ResponseEntity<CustomResponse>(new CustomResponse("just created"), HttpStatus.CREATED);
        } else {
            throw new CustomException("invalid username or password", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    public ResponseEntity<TokenResponse> signinService(UsernamePasswordDTO usernamePasswordDTO){
        try {
            UserDomain userDomain = userRepository.findByUsername(usernamePasswordDTO.getUsername());

            if (passwordEncoder.matches(usernamePasswordDTO.getPassword(), userDomain.getPassword())) {
                TokenResponse tokenResponse = new TokenResponse(generateToken(usernamePasswordDTO.getUsername()));
                return new ResponseEntity<TokenResponse>(tokenResponse, HttpStatus.OK);
            } else {
                throw new CustomException("invalid username or password", HttpStatus.UNPROCESSABLE_ENTITY);
            }
        } catch (Exception e) {
            throw new CustomException("invalid username or password", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    private String generateToken(String username) {
        Claims claims = Jwts.claims().setSubject(username);

        Date now = new Date();
        Date expiration = new Date(now.getTime() + 86400000);

        return Jwts
                .builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(expiration)
                .signWith(SignatureAlgorithm.HS256, SECERT_KEY)
                .compact();
    }

    public UsernameEmailDTO getUserInfo(String token){
        UsernameEmailDTO usernameEmailDTO;
        UserDomain userDomain;
        if(tokenService.validateToken(token)){
            userDomain = userRepository.findByUsername(tokenService.getUsernameFromToken(token));
            usernameEmailDTO = new UsernameEmailDTO(userDomain.getUsername(), userDomain.getEmail());

        }else {
            usernameEmailDTO = null;
        }
        return usernameEmailDTO;
    }
}
