package com.pool.configuration;

import jakarta.jms.JMSException;
import org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

import com.pool.configuration.properties.StudentpoolProperties;

@Configuration
public class StudentpoolEmailJmsConfiguration {
	
	@Autowired
	private StudentpoolProperties studentpoolProperties;

	@Bean
	public DefaultJmsListenerContainerFactory jmsListenerContainerFactory() throws JMSException {
		DefaultJmsListenerContainerFactory jmsListenerContainerFactory = new DefaultJmsListenerContainerFactory();
		jmsListenerContainerFactory.setConnectionFactory(activeMQConnectionFactory());
		jmsListenerContainerFactory.setConcurrency("1-1");
		return jmsListenerContainerFactory;
	}

	@Bean
	public ActiveMQConnectionFactory activeMQConnectionFactory() throws JMSException {
		ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory();
		activeMQConnectionFactory.setBrokerURL(studentpoolProperties.getJmsUrl());
		activeMQConnectionFactory.setUser(studentpoolProperties.getUserName());
		activeMQConnectionFactory.setPassword(studentpoolProperties.getPassword());
		return activeMQConnectionFactory;
	}
	
	@Bean
	public JmsTemplate jmsTemplate() throws JMSException {
		JmsTemplate jmsTemplate=new JmsTemplate();
		jmsTemplate.setConnectionFactory(activeMQConnectionFactory());
		jmsTemplate.setMessageConverter(jacksonJmsMessageConverter());
		return jmsTemplate;
	}
	
	@Bean
	public MessageConverter jacksonJmsMessageConverter() {
		MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
		converter.setTargetType(MessageType.TEXT);
		converter.setTypeIdPropertyName("_type");
		return converter;
	}
}
