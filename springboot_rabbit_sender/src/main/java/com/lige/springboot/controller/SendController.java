package com.lige.springboot.controller;

import java.util.UUID;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lige.springboot.entity.User;




@Controller
public class SendController {
	
	@Autowired
	private 	RabbitTemplate rabbitTemplate;
	//-----//路由模式----------------------------------
	@GetMapping("/sendDirect")
	private @ResponseBody String sendDirect(String message) throws Exception {
		User user = new User(UUID.randomUUID().toString(), message, "123456", "sendDirect");
		rabbitTemplate.convertAndSend("CalonDirectExchange", "CalonDirectRouting", user);
		return "OK,sendDirect:" + message;
	}
	//--------------通配符模式--------------------------
	//发送到first队列
	@GetMapping("/sendTopicFirst")
	private @ResponseBody String sendTopicFirst(String message) {
		User user = new User(UUID.randomUUID().toString(), message, "123456", "sendTopicFirst");
		rabbitTemplate.convertAndSend("topicExchange11", "topic.111", user);
		return "OK,sendTopicFirst:" + message;
	}
	
	//发送到sencond队列
	@GetMapping("/sendTopicSecond")
	private @ResponseBody String sendTopicSecond(String message) {
		User user = new User(UUID.randomUUID().toString(), message, "123456", "sendTopicSecond");
		rabbitTemplate.convertAndSend("topicExchange", "topic.second", user);
		return "OK,sendTopicSecond:" + message;
	}

	//-----------------订阅模式                -----------------------------
	
	@GetMapping("/sendFanout")
	private @ResponseBody String sendFanout(String message) {
		User user = new User(UUID.randomUUID().toString(), message, "123456", "sendFanout");
		rabbitTemplate.convertAndSend("fanoutExchange", "", user);
		return "OK,sendTopicSecond:" + message;
	}
	
	
	
}
