package com.test.situ.cap11.service;

import com.test.situ.cap11.model.ChatSession;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ChatSessionServiceTest {

    private ChatSessionService service;

    @BeforeEach
    void setUp() {
        service = new ChatSessionService();
    }

    @Test
    @DisplayName("createSession should store and return session")
    void createSession_shouldStoreSession() {
        ChatSession session = service.createSession("sess-1", "Hello");

        assertThat(session.conversationId()).isEqualTo("sess-1");
        assertThat(session.title()).isEqualTo("Hello");
        assertThat(session.messageCount()).isEqualTo(0);
        assertThat(session.createdAt()).isNotNull();
    }

    @Test
    @DisplayName("getSession should return existing session")
    void getSession_shouldReturnExisting() {
        service.createSession("sess-1", "Hello");
        assertThat(service.getSession("sess-1")).isPresent();
    }

    @Test
    @DisplayName("getSession should return empty for unknown id")
    void getSession_shouldReturnEmptyForUnknown() {
        assertThat(service.getSession("unknown")).isEmpty();
    }

    @Test
    @DisplayName("listSessions should return all sessions")
    void listSessions_shouldReturnAll() {
        service.createSession("sess-1", "Hello");
        service.createSession("sess-2", "Hi");
        List<ChatSession> sessions = service.listSessions();
        assertThat(sessions).hasSize(2);
    }

    @Test
    @DisplayName("incrementMessageCount should update count and timestamp")
    void incrementMessageCount_shouldUpdate() {
        service.createSession("sess-1", "Hello");
        service.incrementMessageCount("sess-1");
        ChatSession session = service.getSession("sess-1").orElseThrow();
        assertThat(session.messageCount()).isEqualTo(1);
        assertThat(session.updatedAt()).isNotNull();
    }

    @Test
    @DisplayName("removeSession should delete session")
    void removeSession_shouldDelete() {
        service.createSession("sess-1", "Hello");
        boolean removed = service.removeSession("sess-1");
        assertThat(removed).isTrue();
        assertThat(service.getSession("sess-1")).isEmpty();
    }

    @Test
    @DisplayName("removeSession should return false for unknown id")
    void removeSession_shouldReturnFalseForUnknown() {
        assertThat(service.removeSession("unknown")).isFalse();
    }
}
