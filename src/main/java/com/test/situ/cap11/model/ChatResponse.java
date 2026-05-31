package com.test.situ.cap11.model;

public record ChatResponse(
    String conversationId,
    String response,
    int messageCount
) {}
