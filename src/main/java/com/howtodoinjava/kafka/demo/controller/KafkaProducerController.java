package com.howtodoinjava.kafka.demo.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.howtodoinjava.kafka.demo.model.PublishData;
import com.howtodoinjava.kafka.demo.service.KafKaConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.howtodoinjava.kafka.demo.model.User;
import com.howtodoinjava.kafka.demo.service.KafKaProducerService;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/kafka")
public class KafkaProducerController {
	private final KafKaProducerService producerService;
	//private final KafKaConsumerService consumerService;

	@Autowired
	public KafkaProducerController(KafKaProducerService producerService
			//, KafKaConsumerService consumerService
	) {
		this.producerService = producerService;
		//this.consumerService = consumerService;
	}

	@PostMapping(value = "/publish")
	public ResponseEntity<PublishData> sendMessageToKafkaTopic(@RequestParam("message") String message) {
		this.producerService.sendMessage(message);
		PublishData data = new PublishData();
		data.setMessage("SUCCESS");
		data.setDate(new Date());
		data.setData(message);

		return new ResponseEntity<>(data, HttpStatus.OK);
	}
	/*@GetMapping(value = "/consume")
	public ResponseEntity<String> consumeMessageFromKafkaTopic() {
		this.consumerService.consumeOnDemand();
		return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
	}*/
	
	@PostMapping(value = "/createUser")
	public void sendMessageToKafkaTopic(
			@RequestParam("userId") long userId, 
			@RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName) {
		
		User user = new User();
		user.setUserId(userId);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		
		this.producerService.saveCreateUserLog(user);
	}
}