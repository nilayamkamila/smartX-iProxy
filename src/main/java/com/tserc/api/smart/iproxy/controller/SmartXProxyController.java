package com.tserc.api.smart.iproxy.controller;

import com.tserc.api.smart.iproxy.model.ProxyPredictionForwardData;
import com.tserc.api.smart.iproxy.model.PublishData;
import com.tserc.api.smart.iproxy.service.KafKaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Arrays;
import java.util.Date;

@RestController
@RequestMapping(value = "/proxy")
public class SmartXProxyController {
	@Autowired
	private RestTemplate restProxyTemplate;

	@Value("${frames.intelligent.proxy.ibrains.url:http://127.0.0.1:5000/predict/targets}")
	private String iBrainsUrl;

	@GetMapping(value = "/predict/data")
	public ResponseEntity<ProxyPredictionForwardData> proxyPredictAndForward(@RequestParam("message") String message) {
		System.out.println(restProxyTemplate);
		try {
			URI uri = new URI(iBrainsUrl + "?experience=" + message);
			HttpHeaders headers = new HttpHeaders();
			headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			HttpEntity<String> entity = new HttpEntity<String>(headers);
			ProxyPredictionForwardData ProxyPredictionForwardData = restProxyTemplate.getForObject(uri, ProxyPredictionForwardData.class);
			PublishData data = new PublishData();
			data.setMessage("SUCCESS");
			data.setDate(new Date());
			data.setData(message);
			return new ResponseEntity<>(ProxyPredictionForwardData, HttpStatus.OK);
		}catch(Exception ex){
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}