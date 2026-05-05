package com.example.devops_project.model;

public class ChatResponse {
    // define how response is given
    // this class defines the shape of output data

    private String reply;

    public ChatResponse(String reply) {
        this.reply = reply;
    }

    public String getReply() {
        return reply;
    }
}
