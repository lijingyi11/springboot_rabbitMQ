package com.ljy.boot.rece;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues="Hello")//监听来自哪个队列
public class HelloReceiver {
	
	@RabbitHandler
	private void rece(String hello){
		System.out.println("Receiver::::"+hello);
	}
	
}
