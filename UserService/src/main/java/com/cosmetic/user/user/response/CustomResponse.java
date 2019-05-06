package com.cosmetic.user.user.response;

public class CustomResponse {
    private String message;

    public CustomResponse(String message) {
        this.message = message;
    }

    public CustomResponse() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
