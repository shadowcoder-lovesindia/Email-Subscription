package com.example.demo.controllers;



import java.util.Date;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entities.Greeting;
import com.example.demo.entities.SubscriptionRequest;
import com.google.gson.Gson;

@RestController
@RequestMapping("/")
public class SubscriptionController {
	
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	
	@Autowired
	private Environment env;

	@Autowired
	private RestTemplate restTemplate;
	
	@PostMapping(path = "/subscribe", consumes = "application/json", produces = MediaType.ALL_VALUE)
	public String subscribe(@RequestBody SubscriptionRequest request) throws InterruptedException {
		System.out.print("Email Response is::"+sendEmail(request));
		
		return "Subscription id is "+counter;
	}
	
	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		SubscriptionRequest subscriptionRequest=new SubscriptionRequest();
		subscriptionRequest.setConsentGiven(true);
		subscriptionRequest.setDateOfBirth(new Date());
		subscriptionRequest.setEmail("durgadas123@gmail.com");
		subscriptionRequest.setFirstName("Durgadas");
		subscriptionRequest.setGender("M");
		subscriptionRequest.setNewsLetterId(123);
		Gson gson=new Gson();
		System.out.print(gson.toJson(subscriptionRequest));
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
	@Async
    public CompletableFuture sendEmail(SubscriptionRequest request) throws InterruptedException {
    
	ResponseEntity<Object> emailMessageId=	restTemplate.postForEntity("http://email-sender-service/send", request, null);
	
        return CompletableFuture.completedFuture(emailMessageId);
    }
	
	
}