package com.example.demo.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.config.RabbitConfig;
import com.example.demo.model.dto.MessageDto;

@RestController
@RequestMapping("/messages")
public class MessageController {

	@Autowired
    private RabbitTemplate rabbitTemplate;

    @PostMapping("/send")
    public void sendMessage(@RequestParam String message) {
        rabbitTemplate.convertAndSend("exchange", RabbitConfig.routingKey, message);
    }
}
