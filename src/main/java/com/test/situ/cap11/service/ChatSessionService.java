package com.test.situ.cap11.service;

import com.test.situ.cap11.model.ChatSession;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class ChatSessionService {

    private static final int TITLE_MAX_LENGTH = 50;
    private final ConcurrentHashMap<String, ChatSession> sessions = new ConcurrentHashMap<>();

    public ChatSession createSession(String conversationId, String firstMessage) {
        String title = firstMessage.length() > TITLE_MAX_LENGTH
                ? firstMessage.substring(0, TITLE_MAX_LENGTH) + "..."
                : firstMessage;
        LocalDateTime now = LocalDateTime.now();
        ChatSession session = new ChatSession(conversationId, title, now, now, 0, null);
        sessions.put(conversationId, session);
        return session;
    }

    public Optional<ChatSession> getSession(String conversationId) {
        return Optional.ofNullable(sessions.get(conversationId));
    }

    public List<ChatSession> listSessions() {
        return List.copyOf(sessions.values());
    }

    public void incrementMessageCount(String conversationId) {
        sessions.computeIfPresent(conversationId, (id, session) -> new ChatSession(
                session.conversationId(),
                session.title(),
                session.createdAt(),
                LocalDateTime.now(),
                session.messageCount() + 1,
                session.summary()
        ));
    }

    public boolean removeSession(String conversationId) {
        return sessions.remove(conversationId) != null;
    }
}
