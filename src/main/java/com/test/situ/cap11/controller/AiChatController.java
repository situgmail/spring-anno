package com.test.situ.cap11.controller;

import com.test.situ.cap11.model.ChatRequest;
import com.test.situ.cap11.model.ChatResponse;
import com.test.situ.cap11.model.ChatSession;
import com.test.situ.cap11.service.AiChatService;
import com.test.situ.cap11.service.ChatSessionService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ai")
public class AiChatController {

    private final AiChatService aiChatService;
    private final ChatSessionService sessionService;

    public AiChatController(AiChatService aiChatService, ChatSessionService sessionService) {
        this.aiChatService = aiChatService;
        this.sessionService = sessionService;
    }

    @PostMapping("/chat")
    public ResponseEntity<ChatResponse> chat(@Valid @RequestBody ChatRequest request) {
        ChatResponse response = aiChatService.chat(request.conversationId(), request.message());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/sessions")
    public ResponseEntity<List<ChatSession>> listSessions() {
        return ResponseEntity.ok(sessionService.listSessions());
    }

    @GetMapping("/sessions/{conversationId}")
    public ResponseEntity<ChatSession> getSession(@PathVariable String conversationId) {
        return sessionService.getSession(conversationId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/sessions/{conversationId}")
    public ResponseEntity<Void> deleteSession(@PathVariable String conversationId) {
        boolean removed = sessionService.removeSession(conversationId);
        return removed ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
