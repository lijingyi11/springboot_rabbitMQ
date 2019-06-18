package com.ljy.boot.send;

import java.util.Date;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HelloSender {
	//rabbitTemplate 是 Spring Boot 提供的默认实现
	@Autowired
	private AmqpTemplate rabbitTemplate;
	
	public void send(){
		String  context = "hello"+ new Date();
		
		System.out.println("Sender:::"+context);
		rabbitTemplate.convertAndSend("hello",context);
		
		
		
	}
	
}
