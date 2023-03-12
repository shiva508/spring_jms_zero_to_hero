package com.pool.consumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
@JmsListener(destination="In-memmory-queue")
public void  myConsumerMethod(String message) {
System.out.println("Active MQ message:"+message);
//new section
}
}
