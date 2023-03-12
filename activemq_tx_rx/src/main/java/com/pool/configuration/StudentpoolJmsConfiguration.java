package com.pool.configuration;

import java.util.Properties;
import javax.naming.Context;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.connection.UserCredentialsConnectionFactoryAdapter;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;
import org.springframework.jndi.JndiTemplate;


//@Configuration
public class StudentpoolJmsConfiguration {

	@Bean(name = "jmsListenerContainerFactory")
	public DefaultJmsListenerContainerFactory jmsListenerContainerFactory() {
		DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
		UserCredentialsConnectionFactoryAdapter connectionFactoryAdapter=new UserCredentialsConnectionFactoryAdapter();
		connectionFactoryAdapter.setUsername("admin");
		connectionFactoryAdapter.setPassword("admin");
		factory.setConnectionFactory(connectionFactoryAdapter);
		factory.setSessionTransacted(true);
		factory.setMaxMessagesPerTask(1);
		factory.setConcurrency("1-5");
		return factory;
	}

	@Bean
	public MessageConverter jacksonJmsMessageConverter() {
		MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
		converter.setTargetType(MessageType.TEXT);
		converter.setTypeIdPropertyName("_type");
		return converter;
	}

	@Bean
	public JndiTemplate jndiTemplate() {
		JndiTemplate jndiTemplate = new JndiTemplate();
		Properties properties=new Properties();
		properties.put(Context.PROVIDER_URL, "http://localhost:8161");
		properties.put(Context.INITIAL_CONTEXT_FACTORY, "http://localhost:8161");
		jndiTemplate.setEnvironment(properties);
		return jndiTemplate;
	}
}
