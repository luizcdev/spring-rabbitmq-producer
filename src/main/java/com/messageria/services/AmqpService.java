package com.messageria.services;

import com.messageria.dto.Message;

public interface AmqpService {
	void sendToConsumer(Message message);
}
