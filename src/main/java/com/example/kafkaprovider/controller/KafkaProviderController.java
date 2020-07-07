package com.example.kafkaprovider.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import com.example.kafkaprovider.service.KafkaProviderService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping(path = "/api/event/")
public class KafkaProviderController {
    private final Logger logger = LoggerFactory.getLogger(KafkaProviderController.class);

    @Autowired
    KafkaProviderService kafkaProviderService;

    @PostMapping(value = "/")
    public String postMethodName(@RequestBody Map<String, String> event) {
        String eventName = event.get("eventName");
        String eventData = event.get("eventData");
        logger.info(String.format("Received event - name: '%s', data: '%s'", eventName, eventData));

        // Call provider service
        kafkaProviderService.sendEvent(eventName, eventData);

        return "event was published";
    }

}