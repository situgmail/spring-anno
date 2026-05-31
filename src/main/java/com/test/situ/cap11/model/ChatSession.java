package com.test.situ.cap11.model;

import java.time.LocalDateTime;

public record ChatSession(
    String conversationId,
    String title,
    LocalDateTime createdAt,
    LocalDateTime updatedAt,
    int messageCount,
    String summary
) {}
