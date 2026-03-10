package com.daust.aeme_backend.chat.kafka;

import com.daust.aeme_backend.chat.model.ChatMessage;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    @KafkaListener(topics = "chat-messages")
    public void consume(ChatMessage message) {

        System.out.println("Message reçu : " + message.getContent());

    }
}