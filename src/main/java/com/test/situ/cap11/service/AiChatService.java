package com.test.situ.cap11.service;

import com.test.situ.cap11.exception.AiServiceException;
import com.test.situ.cap11.model.ChatResponse;
import com.test.situ.cap11.model.ChatSession;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.stereotype.Service;

@Service
public class AiChatService {

    private static final int MESSAGE_MAX_LENGTH = 4000;
    private static final int SESSION_MESSAGE_LIMIT = 200;

    private final ChatClient chatClient;
    private final ChatMemory chatMemory;
    private final ChatSessionService sessionService;

    public AiChatService(ChatClient chatClient, ChatMemory chatMemory, ChatSessionService sessionService) {
        this.chatClient = chatClient;
        this.chatMemory = chatMemory;
        this.sessionService = sessionService;
    }

    public ChatResponse chat(String conversationId, String message) {
        String trimmed = message.length() > MESSAGE_MAX_LENGTH
                ? message.substring(0, MESSAGE_MAX_LENGTH)
                : message;

        ensureSessionExists(conversationId, trimmed);
        checkMessageLimit(conversationId);

        String response;
        try {
            response = chatClient.prompt()
                    .user(trimmed)
                    .advisors(a -> a.param(ChatMemory.CONVERSATION_ID, conversationId))
                    .call()
                    .content();
        } catch (Exception e) {
            throw new AiServiceException("AI service unavailable: " + e.getMessage(), e);
        }

        sessionService.incrementMessageCount(conversationId);
        sessionService.incrementMessageCount(conversationId);

        int messageCount = sessionService.getSession(conversationId)
                .map(ChatSession::messageCount)
                .orElse(0);

        return new ChatResponse(conversationId, response, messageCount);
    }

    private void ensureSessionExists(String conversationId, String firstMessage) {
        if (sessionService.getSession(conversationId).isEmpty()) {
            sessionService.createSession(conversationId, firstMessage);
        }
    }

    private void checkMessageLimit(String conversationId) {
        sessionService.getSession(conversationId).ifPresent(session -> {
            if (session.messageCount() >= SESSION_MESSAGE_LIMIT) {
                throw new IllegalStateException(
                        "Session " + conversationId + " exceeded message limit (" + SESSION_MESSAGE_LIMIT + "). Please start a new session.");
            }
        });
    }
}
