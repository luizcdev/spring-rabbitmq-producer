package com.messageria.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.messageria.amqp.AmqpProducer;
import com.messageria.dto.Message;
import com.messageria.services.AmqpService;

@Service
public class RabbitMQService implements AmqpService{

	@Autowired
	private AmqpProducer<Message> amqp;
	
	@Override
	public void sendToConsumer(Message message) {
		amqp.producer(message);
	}

}
