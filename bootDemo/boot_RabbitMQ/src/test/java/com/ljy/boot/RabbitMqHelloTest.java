package com.ljy.boot;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ljy.boot.rece.HelloReceiver;
import com.ljy.boot.send.HelloSender;

@SpringBootTest
public class RabbitMqHelloTest {
	
	@Autowired
	private HelloSender helloSender;
	
	@Autowired
	private HelloReceiver helloReceiver;
	
	
	@Test
	public void sendTest(){
		helloSender.send();
	}
	
	
	
}
