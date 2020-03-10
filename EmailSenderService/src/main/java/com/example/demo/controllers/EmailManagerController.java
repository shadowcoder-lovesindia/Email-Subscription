package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.EmailRequest;



@RestController
@RequestMapping("/")
public class EmailManagerController {
	

		@Autowired
		private Environment env;

		@PostMapping(path = "/send", consumes = "application/json", produces = "application/json")
		public String sendEmail(@RequestBody EmailRequest request) {

			return "email-sent-successfully";
		}
	

}
