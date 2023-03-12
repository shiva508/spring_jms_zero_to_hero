package com.pool.controller;

import javax.jms.Queue;

import com.pool.model.Order;
import jakarta.jms.Destination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerController {
	@Autowired
	private Queue queue;
	@Autowired
	private JmsTemplate jmsTemplate;

	@GetMapping("/message/{message}")
	public String send(@PathVariable("message") String message) {
		jmsTemplate.convertAndSend((Destination) queue, message);
		return "produced";
	}
	@GetMapping("/order")
	public Order saveOrder() {
		Order order=new Order();
		order.setItemName("LAPTOP")
		.setOrderPrice("32000");
		jmsTemplate.convertAndSend("OrderQueue", order);
		return order;
	}
}
