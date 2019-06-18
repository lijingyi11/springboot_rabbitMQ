package com.lige.springboot.receive;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.lige.springboot.entity.User;


@Component
@RabbitListener(queues = "CalonDirectQueue")//CalonDirectQueue为队列名称
public class DirectReceiver {
	
	@RabbitHandler
    public void process(User user) {
        System.out.println("DirectReceiver消费者收到消息  : " + user.getId()+","+user.getUsername()+","+user.getPassword()+","+user.getType());
    }
 
}