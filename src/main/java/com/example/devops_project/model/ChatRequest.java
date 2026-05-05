package com.example.devops_project.model;

public class ChatRequest {
    // define how input is taken
    // this class defines the shape of input data
    
    private String message;

    public ChatRequest() {
        // Jackson needs this
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
