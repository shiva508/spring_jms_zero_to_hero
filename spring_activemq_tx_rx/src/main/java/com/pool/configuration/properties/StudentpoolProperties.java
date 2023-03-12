package com.pool.configuration.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("student-pool")
public class StudentpoolProperties {
	@Value("jmsUrl")
	private String jmsUrl;
	@Value("userName")
	private String userName;
	@Value("password")
	private String password;

	@Value("topic.studentpool")
	private String studentpoolTopic;

	public StudentpoolProperties() {

	}

	public String getJmsUrl() {
		return jmsUrl;
	}

	public void setJmsUrl(String jmsUrl) {
		this.jmsUrl = jmsUrl;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStudentpoolTopic() {
		return studentpoolTopic;
	}

	public void setStudentpoolTopic(String studentpoolTopic) {
		this.studentpoolTopic = studentpoolTopic;
	}

}
