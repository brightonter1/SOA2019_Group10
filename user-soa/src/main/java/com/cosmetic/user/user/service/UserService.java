package com.cosmetic.user.user.service;

import com.cosmetic.user.user.domain.UserDomain;
import com.cosmetic.user.user.dto.UserDTO;
import com.cosmetic.user.user.dto.UsernamePasswordDTO;
import com.cosmetic.user.user.repository.UserRepository;
import com.cosmetic.user.user.response.CustomException;
import com.cosmetic.user.user.response.CustomResponse;
import com.cosmetic.user.user.response.TokenResponse;
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
}
