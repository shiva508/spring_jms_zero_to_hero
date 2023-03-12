package com.pool.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.shiva.model.Order;
import com.shiva.repository.OrderRepository;

@Component
public class OrderReceiver {
	@Autowired
	private OrderRepository orderRepository;
	@JmsListener(destination="OrderQueue",containerFactory="custom")
	public void receiveMessage(Order order) {
		System.out.println(order+"TRANSACTION STARTED");
		orderRepository.save(order);
	}
}
