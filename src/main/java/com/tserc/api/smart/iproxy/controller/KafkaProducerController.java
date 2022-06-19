package com.tserc.api.smart.iproxy.controller;

import com.tserc.api.smart.iproxy.model.PublishData;
import com.tserc.api.smart.iproxy.service.KafKaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping(value = "/kafka")
public class KafkaProducerController {
	private final KafKaProducerService producerService;

	@Autowired
	public KafkaProducerController(KafKaProducerService producerService) {
		this.producerService = producerService;
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
}