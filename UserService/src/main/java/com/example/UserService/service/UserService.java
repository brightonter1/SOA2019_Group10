package com.example.UserService.service;

import com.example.UserService.domain.UserDomain;
import com.example.UserService.dto.UserDTO;
import com.example.UserService.repository.UserRepository;
import com.example.UserService.response.CustomException;
import com.example.UserService.response.CustomResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public ResponseEntity<CustomResponse> signup(UserDTO userDTO) {
        if (!userRepository.existsByUsername(userDTO.getUsername())) {
            UserDomain userDomain = new UserDomain(userDTO.getUsername(), userDTO.getEmail());
            userDomain.setPassword(passwordEncoder.encode(userDTO.getPassword()));

            userRepository.save(userDomain);

            return new ResponseEntity<CustomResponse>(new CustomResponse("created"), HttpStatus.CREATED);
        } else {
            throw new CustomException("username was exists", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

}
