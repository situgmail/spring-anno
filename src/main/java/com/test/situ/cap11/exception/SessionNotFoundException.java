package com.test.situ.cap11.exception;

public class SessionNotFoundException extends RuntimeException {
    public SessionNotFoundException(String conversationId) {
        super("Session not found: " + conversationId);
    }
}
