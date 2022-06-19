package com.howtodoinjava.kafka.demo.service;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.stereotype.Service;

import com.howtodoinjava.kafka.demo.model.User;

import java.util.Collections;

//@Service
public class KafKaConsumerService 
{
	private final Logger logger 
		= LoggerFactory.getLogger(KafKaConsumerService.class);

	/*
	@Autowired
	private ConsumerFactory consumerFactory;
	 */


	/*@KafkaListener(topics = "${general.topic.name}",
			groupId = "${general.topic.group.id}")
	public void consume(String message) {
		logger.info(String.format("Message recieved -> %s", message));
	}*/

	@KafkaListener(topics = "${user.topic.name}", 
			groupId = "${user.topic.group.id}",
			containerFactory = "userKafkaListenerContainerFactory")
	public void consume(User user) {
		logger.info(String.format("User created -> %s", user));
	}


	/*public void consumeOnDemand() {
		Consumer consumer = consumerFactory.createConsumer("mytopic");
		ConsumerRecords<Integer, String> records = consumer.poll(3000);
		for (ConsumerRecord<Integer, String> record : records) {
			System.out.println("Received message: (" + record.key() + ", " + record.value() + ") at offset " + record.offset());
		}

		//logger.info(String.format("Message recieved -> %s", message));
	}*/
}
