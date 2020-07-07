package com.example.kafkaprovider.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProviderService {
    private final Logger logger = LoggerFactory.getLogger(KafkaProviderService.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendEvent(String eventName, String eventData) {
        logger.info(String.format("Publish Event name: '%s' - Message: '%s'", eventName, eventData));

        // Publish event to Kafka
        this.kafkaTemplate.send(eventName, eventData);
    }

}