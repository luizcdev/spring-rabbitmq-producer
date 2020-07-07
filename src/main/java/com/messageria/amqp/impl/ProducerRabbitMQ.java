package com.messageria.amqp.impl;

import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.messageria.amqp.AmqpProducer;
import com.messageria.dto.Message;

@Component
public class ProducerRabbitMQ implements AmqpProducer<Message>{

	@Value("${spring.rabbitmq.request.routing-key.producer}")
	private String queue;
	
	@Value("${spring.rabbitmq.request.exchange.producer}")
	private String exchange;
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	@Override
	public void producer(Message message) {
		try {
			rabbitTemplate.convertAndSend(exchange, queue, message);
		} catch(Exception e) {
			throw new AmqpRejectAndDontRequeueException(e);
		}
	}
	
}
