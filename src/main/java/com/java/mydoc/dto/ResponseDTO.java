package com.java.mydoc.dto;

public class ResponseDTO {
    private String token;

    public ResponseDTO() {
    }

    public ResponseDTO(String token) {
        this.token = token;
    }

    // Getter and setter for the token
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
