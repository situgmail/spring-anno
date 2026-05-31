package com.test.situ.cap11.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ChatRequest(
    @NotBlank @Size(max = 4000) String message,
    String conversationId
) {
    public String conversationId() {
        return conversationId == null || conversationId.isBlank() ? "default" : conversationId;
    }
}
