package com.example.devops_project.controller;

import com.example.devops_project.model.ChatRequest;
import com.example.devops_project.model.ChatResponse;
import com.example.devops_project.service.ChatService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/chat")
public class ChatController {
    
    private final ChatService chatService;
    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @PostMapping("/send")
    public ChatResponse chat(@RequestBody ChatRequest request) {
        String reply = chatService.generateReply(request.getMessage());
        return new ChatResponse(reply);
    }
    
}

/*

    HTTP Request (JSON)
            ↓
    ChatRequest object
            ↓
    (process / delegate)
            ↓
    ChatResponse object
            ↓
    HTTP Response (JSON)

*/