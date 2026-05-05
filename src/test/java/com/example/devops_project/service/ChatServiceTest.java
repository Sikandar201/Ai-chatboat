package com.example.devops_project.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

public class ChatServiceTest {

    private ChatService chatService;

    @BeforeEach
    public void setUp() {
        chatService = new ChatService();
    }

    @Test
    public void testGenerateReply() {
        String message = "Hello";

        String actualReply = chatService.generateReply(message);

        // Since the response is random, we can't assert a specific value easily without
        // duplicating the list.
        // For now, let's just assert it's not null and not empty.
        // Or we can check if it's one of the known responses.
        String[] expectedResponses = {
                "That's an interesting perspective! Tell me more.",
                "I'm just a hardcoded response for now, but I'm working on it!",
                "The tests are passing, so that's good news.",
                "I can't access the external API right now, but I'm still here.",
                "Hello! This is a pre-defined message."
        };

        boolean isValidResponse = false;
        for (String response : expectedResponses) {
            if (response.equals(actualReply)) {
                isValidResponse = true;
                break;
            }
        }

        assertEquals(true, isValidResponse, "Response should be one of the hardcoded values");
    }
}
