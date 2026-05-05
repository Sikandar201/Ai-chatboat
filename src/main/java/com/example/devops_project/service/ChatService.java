package com.example.devops_project.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ChatService {

    @Value("${gemini.api.key}")
    private String geminiApiKey;

    @Value("${gemini.api.url:https://generativelanguage.googleapis.com/v1beta/models/gemini-2.0-flash:generateContent?key=}")
    private String geminiApiUrl;

    public ChatService() {
    }

    public String generateReply(String message) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            // Construct payload
            Map<String, Object> textPart = new HashMap<>();
            textPart.put("text", message);

            Map<String, Object> parts = new HashMap<>();
            parts.put("parts", Collections.singletonList(textPart));

            Map<String, Object> contents = new HashMap<>();
            contents.put("contents", Collections.singletonList(parts));

            HttpEntity<Map<String, Object>> request = new HttpEntity<>(contents, headers);

            ResponseEntity<Map> response = restTemplate.postForEntity(geminiApiUrl + geminiApiKey, request, Map.class);
            Map<String, Object> body = response.getBody();
            if (body != null && body.containsKey("candidates")) {
                List<Map<String, Object>> candidates = (List<Map<String, Object>>) body.get("candidates");
                if (!candidates.isEmpty()) {
                    Map<String, Object> candidate = candidates.get(0);
                    Map<String, Object> content = (Map<String, Object>) candidate.get("content");
                    List<Map<String, Object>> resParts = (List<Map<String, Object>>) content.get("parts");
                    if (!resParts.isEmpty()) {
                        return (String) resParts.get(0).get("text");
                    }
                }
            }
            return "No response from Gemini.";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error calling Gemini API: mittal ki ma ki chut " + e.getMessage();
        }
    }
}
