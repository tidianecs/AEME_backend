package com.daust.aeme_backend.chat.controller;

import com.daust.aeme_backend.chat.kafka.KafkaProducerService;
import com.daust.aeme_backend.chat.model.ChatMessage;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/chat")
public class TestKafkaController {

    private final KafkaProducerService producer;

    public TestKafkaController(KafkaProducerService producer) {
        this.producer = producer;
    }

    @PostMapping("/send")
    public String sendMessage(@RequestBody ChatMessage message) {

        message.setTimestamp(LocalDateTime.now());
        producer.sendMessage(message);

        return "Message envoyé";
    }
}