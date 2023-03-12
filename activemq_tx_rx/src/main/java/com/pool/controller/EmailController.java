package com.pool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pool.configuration.properties.StudentpoolProperties;
import com.pool.model.CommonResponse;
import com.pool.model.Email;

@RestController
public class EmailController {
	@Autowired
	private JmsTemplate jmsTemplate;
	
	@Autowired
	private StudentpoolProperties studentpoolProperties;
	
	@PostMapping("/sendmessage")
	public ResponseEntity<?> sendMessage(@RequestBody Email email) {
		System.out.println(studentpoolProperties.getPassword());
		jmsTemplate.convertAndSend(studentpoolProperties.getStudentpoolTopic(), email);
		return new ResponseEntity<>(new CommonResponse().setMessage("DATA").setStatusCode(200), HttpStatus.OK);
		
	}
}
