package com.example.devops_project.service;

import org.springframework.stereotype.Service;

@Service
public class ChatService {

    public ChatService() {
    }

    public String generateReply(String message) {
        // Hardcoded responses as requested
        String[] responses = {
                "That's an interesting perspective! Tell me more.",
                "I'm just a hardcoded response for now, but I'm working on it!",
                "The tests are passing, so that's good news.",
                "I can't access the external API right now, but I'm still here.",
                "Hello! This is a pre-defined message."
        };
        return responses[(int) (Math.random() * responses.length)];
    }
}
