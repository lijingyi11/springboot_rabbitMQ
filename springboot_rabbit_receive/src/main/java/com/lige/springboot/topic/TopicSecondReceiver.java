package com.lige.springboot.topic;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.lige.springboot.entity.User;

@Component
@RabbitListener(queues = "topic.second")
public class TopicSecondReceiver {
	@RabbitHandler
    public void process(User user) {
		System.out.println("TopicSecondReceiver消费者收到消息  : " + user.toString());
    }
}
