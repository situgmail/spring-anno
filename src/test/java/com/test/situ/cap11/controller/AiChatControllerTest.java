package com.test.situ.cap11.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.situ.cap11.exception.SessionNotFoundException;
import com.test.situ.cap11.model.ChatRequest;
import com.test.situ.cap11.model.ChatResponse;
import com.test.situ.cap11.model.ChatSession;
import com.test.situ.cap11.service.AiChatService;
import com.test.situ.cap11.service.ChatSessionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(AiChatController.class)
class AiChatControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private AiChatService aiChatService;

    @MockBean
    private ChatSessionService sessionService;

    @MockBean
    private ChatMemory chatMemory;

    @Test
    @DisplayName("GET /ai/sessions returns empty list initially")
    void listSessions_returnsEmptyInitially() throws Exception {
        when(sessionService.listSessions()).thenReturn(List.of());

        mockMvc.perform(get("/ai/sessions"))
                .andExpect(status().isOk())
                .andExpect(content().json("[]"));
    }

    @Test
    @DisplayName("DELETE /ai/sessions/{id} returns 404 for unknown session")
    void deleteSession_returns404ForUnknown() throws Exception {
        when(sessionService.getSession("nonexistent")).thenReturn(Optional.empty());

        mockMvc.perform(delete("/ai/sessions/nonexistent"))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("GET /ai/sessions/{id}/messages returns 404 for unknown session")
    void getMessages_returns404ForUnknown() throws Exception {
        when(sessionService.getSession("nonexistent")).thenReturn(Optional.empty());

        mockMvc.perform(get("/ai/sessions/nonexistent/messages"))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("POST /ai/chat with empty message returns 400")
    void chat_withEmptyMessage_returns400() throws Exception {
        mockMvc.perform(post("/ai/chat")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"message\":\"\"}"))
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("ChatRequest with null conversationId defaults to 'default'")
    void chatRequest_defaultConversationId() {
        ChatRequest request = new ChatRequest("hello", null);
        assertThat(request.conversationId()).isEqualTo("default");
    }

    @Test
    @DisplayName("ChatRequest with blank conversationId defaults to 'default'")
    void chatRequest_blankConversationId() {
        ChatRequest request = new ChatRequest("hello", "   ");
        assertThat(request.conversationId()).isEqualTo("default");
    }

    @Test
    @DisplayName("POST /ai/chat returns response")
    void chat_returnsResponse() throws Exception {
        when(aiChatService.chat(anyString(), anyString()))
                .thenReturn(new ChatResponse("test-session", "Mock AI response", 2));

        String jsonRequest = objectMapper.writeValueAsString(new ChatRequest("Hello AI", "test-session"));

        mockMvc.perform(post("/ai/chat")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonRequest))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.conversationId").value("test-session"))
                .andExpect(jsonPath("$.response").value("Mock AI response"))
                .andExpect(jsonPath("$.messageCount").value(2));
    }

    @Test
    @DisplayName("GET /ai/sessions returns created sessions")
    void listSessions_returnsCreatedSessions() throws Exception {
        ChatSession session = new ChatSession(
                "session1", "First message", LocalDateTime.now(), LocalDateTime.now(), 0, null);
        when(sessionService.listSessions()).thenReturn(List.of(session));

        mockMvc.perform(get("/ai/sessions"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(1))
                .andExpect(jsonPath("$[0].conversationId").value("session1"));
    }

    @Test
    @DisplayName("DELETE /ai/sessions/{id} deletes existing session")
    void deleteSession_deletesExistingSession() throws Exception {
        ChatSession session = new ChatSession(
                "to-delete", "Test message", LocalDateTime.now(), LocalDateTime.now(), 0, null);
        when(sessionService.getSession("to-delete")).thenReturn(Optional.of(session));
        when(sessionService.removeSession("to-delete")).thenReturn(true);

        mockMvc.perform(delete("/ai/sessions/to-delete"))
                .andExpect(status().isNoContent());

        verify(sessionService).removeSession("to-delete");
        verify(chatMemory).clear("to-delete");
    }

    @Test
    @DisplayName("GET /ai/sessions/{id}/messages returns messages for existing session")
    void getMessages_returnsMessagesForExistingSession() throws Exception {
        ChatSession session = new ChatSession(
                "with-messages", "Test message", LocalDateTime.now(), LocalDateTime.now(), 0, null);
        when(sessionService.getSession("with-messages")).thenReturn(Optional.of(session));
        when(chatMemory.get("with-messages")).thenReturn(List.of());

        mockMvc.perform(get("/ai/sessions/with-messages/messages"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray());
    }
}
