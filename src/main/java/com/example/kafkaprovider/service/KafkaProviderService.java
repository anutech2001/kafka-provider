package com.example.kafkaprovider.service;

import com.example.kafkaprovider.model.Event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProviderService {
    private final Logger logger = LoggerFactory.getLogger(KafkaProviderService.class);

    private final String TOPIC = "event";

    @Autowired
    private KafkaTemplate<String, Event> kafkaTemplate;

    public void sendEvent(Event event) {
        logger.info(
                String.format("Publish Event name: '%s' - Message: '%s'", event.getEventName(), event.getEventData()));

        // Publish event to Kafka
        this.kafkaTemplate.send(TOPIC, event);
    }

}