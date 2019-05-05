package com.example.WishlistService.Service;

import com.example.WishlistService.Model.UserDomain;
import com.example.WishlistService.Repository.UserRepository;
import com.example.WishlistService.dto.*;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserService {
    private Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public static final String SECERT_KEY = "bright";

    public ResponseEntity<CustomResponse> signup(UserDTO userDTO) {
        if (!userRepository.existsByUsername(userDTO.getUsername())) {
            UserDomain userDomain = new UserDomain(userDTO.getUsername(), userDTO.getEmail());
            userDomain.setPassword(passwordEncoder.encode(userDTO.getPassword()));
            userRepository.save(userDomain);

            return new ResponseEntity<CustomResponse>(new CustomResponse("just created"), HttpStatus.CREATED);
        } else {
            return new ResponseEntity<CustomResponse>(new CustomResponse("username already exist"), HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    public ResponseEntity<TokenResponse> signin(UsernamePasswordDTO usernamePasswordDTO) {
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

    public String generateToken(String username) {
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

}
