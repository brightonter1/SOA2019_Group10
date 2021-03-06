package com.example.UserService.dto;

public class UsernameEmailDTO {

    private String username;
    private String email;

    public UsernameEmailDTO(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public UsernameEmailDTO() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
