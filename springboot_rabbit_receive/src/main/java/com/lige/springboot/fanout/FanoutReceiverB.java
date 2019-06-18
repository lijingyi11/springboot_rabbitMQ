package com.lige.springboot.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.lige.springboot.entity.User;

@Component
@RabbitListener(queues="fanout.B")
public class FanoutReceiverB {
	 @RabbitHandler
    public void process(User user) {
    	System.out.println("FanoutReceiverB消费者收到消息  : " + user.toString());
    }
}
