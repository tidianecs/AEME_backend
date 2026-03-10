package com.daust.aeme_backend.chat.model;

import java.time.LocalDateTime;

public class ChatMessage {

    private String senderId;
    private String receiverId;
    private String content;
    private LocalDateTime timestamp;

    public ChatMessage() {}

    public ChatMessage(String senderId, String receiverId, String content) {
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.content = content;
        this.timestamp = LocalDateTime.now();
    }

    public void setReceiverId(String receiverId) {
        this.receiverId = receiverId;
    }
    public String getReceiverId() {
        return receiverId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }
    public String getSenderId() {
        return senderId;
    }

    public void setContent(String content) {
        this.content = content;
    }
    public String getContent() {
        return content;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}