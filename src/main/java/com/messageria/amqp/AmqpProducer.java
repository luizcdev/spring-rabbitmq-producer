package com.messageria.amqp;

public interface AmqpProducer<T> {
	
	void producer(T t);
}
