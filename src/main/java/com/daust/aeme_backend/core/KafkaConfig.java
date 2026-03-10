package com.daust.aeme_backend.core;

import java.util.HashMap;
import java.util.Map;

import com.daust.aeme_backend.chat.model.ChatMessage;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;

import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;

import org.springframework.kafka.core.*;

import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;

@Configuration
@EnableKafka
public class KafkaConfig {

    // PRODUCER

    @Bean
    public ProducerFactory<String, ChatMessage> producerFactory() {

        Map<String, Object> config = new HashMap<>();

        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);

        return new DefaultKafkaProducerFactory<>(config);
    }

    @Bean
    public KafkaTemplate<String, ChatMessage> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }

    // CONSUMER

    @Bean
    public ConsumerFactory<String, ChatMessage> consumerFactory() {

        JsonDeserializer<ChatMessage> deserializer = new JsonDeserializer<>(ChatMessage.class);
        deserializer.addTrustedPackages("*");

        Map<String, Object> config = new HashMap<>();

        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        config.put(ConsumerConfig.GROUP_ID_CONFIG, "chat-group");

        return new DefaultKafkaConsumerFactory<>(
                config,
                new StringDeserializer(),
                deserializer
        );
    }

    // LISTENER FACTORY (IMPORTANT)

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, ChatMessage> kafkaListenerContainerFactory() {

        ConcurrentKafkaListenerContainerFactory<String, ChatMessage> factory =
                new ConcurrentKafkaListenerContainerFactory<>();

        factory.setConsumerFactory(consumerFactory());

        return factory;
    }
}