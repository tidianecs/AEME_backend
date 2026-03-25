package com.daust.aeme_backend.chat.controller;

import com.daust.aeme_backend.chat.kafka.KafkaProducerService;
import com.daust.aeme_backend.chat.model.ChatMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

@Controller
public class ChatWebSocketController {

    private final KafkaProducerService kafkaProducerService;

    public ChatWebSocketController(KafkaProducerService kafkaProducerService) {
        this.kafkaProducerService = kafkaProducerService;
    }

    @MessageMapping("/chat.sendMessage")
    public void sendMessage(ChatMessage message) {

        kafkaProducerService.sendMessage(message);

    }
}