package com.example.demo.config;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MessageReceiver {

	public void onReceivedMessage(String message) {
		System.out.println(message);
	};
}
