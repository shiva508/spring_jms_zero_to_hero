package com.pool.configuration;

import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
@EnableJms
public class StudentpoolJmsConsumer {
	
	@JmsListener(destination = "${student-pool.topicstudentpool}", containerFactory = "jmsListenerContainerFactory")
	public void receiveMessage(String email) {
		System.out.println(email);
	}
}
