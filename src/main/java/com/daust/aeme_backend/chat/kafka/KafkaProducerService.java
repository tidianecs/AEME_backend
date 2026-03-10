package com.daust.aeme_backend.chat.kafka;

import com.daust.aeme_backend.chat.model.ChatMessage;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {
    private final KafkaTemplate<String, ChatMessage> kafkaTemplate;

    public KafkaProducerService(KafkaTemplate<String, ChatMessage> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(ChatMessage message) {
        kafkaTemplate.send("chat-messages", message);
    }
}
