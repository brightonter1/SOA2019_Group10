package com.example.UserService.service;

import com.example.UserService.model.User;
import com.example.UserService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.util.Optional;

@Service
public class UserService extends HttpServlet {

    @Autowired
    private UserRepository userRepository;

    public String login(User user) throws NoSuchAlgorithmException {

        Optional<User> userFromDB = userRepository.findById(user.getUsername());

        String encodePassword = encode(user.getPassword());

        if(encodePassword.equals(userFromDB.get().getPassword())){
            return "login complete";
        }else{
            return "failed to login";
        }
    }

    public String getEncode(String message) throws NoSuchAlgorithmException {

        return encode(message);

    }

    public String encode(String text) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        byte[] hash = messageDigest.digest(text.getBytes(StandardCharsets.UTF_8));
        BigInteger bigInteger = new BigInteger(1, hash);
        String hashText = bigInteger.toString(16);
        while(hashText.length() < 64){
            hashText = "0" + hashText;
        }
        return hashText;
    }



}
