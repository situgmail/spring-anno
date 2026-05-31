package com.test.situ.cap11.controller;

import com.test.situ.cap11.exception.SessionNotFoundException;
import com.test.situ.cap11.model.ChatRequest;
import com.test.situ.cap11.model.ChatResponse;
import com.test.situ.cap11.model.ChatSession;
import com.test.situ.cap11.service.AiChatService;
import com.test.situ.cap11.service.ChatSessionService;
import jakarta.validation.Valid;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ai")
public class AiChatController {

    private final AiChatService aiChatService;
    private final ChatSessionService sessionService;
    private final ChatMemory chatMemory;

    public AiChatController(AiChatService aiChatService, ChatSessionService sessionService, ChatMemory chatMemory) {
        this.aiChatService = aiChatService;
        this.sessionService = sessionService;
        this.chatMemory = chatMemory;
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

    @GetMapping("/sessions/{id}/messages")
    public ResponseEntity<List<?>> getSessionMessages(@PathVariable String id) {
        if (sessionService.getSession(id).isEmpty()) {
            throw new SessionNotFoundException(id);
        }
        return ResponseEntity.ok(chatMemory.get(id));
    }

    @DeleteMapping("/sessions/{id}")
    public ResponseEntity<Void> deleteSession(@PathVariable String id) {
        if (sessionService.getSession(id).isEmpty()) {
            throw new SessionNotFoundException(id);
        }
        chatMemory.clear(id);
        sessionService.removeSession(id);
        return ResponseEntity.noContent().build();
    }
}
