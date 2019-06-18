package com.lige.springboot.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class DirectRabbitConfig {
	//队列
    public Queue CalonDirectQueue() {
        return new Queue("CalonDirectQueue",true);
    }
	
    //Direct交换机
    DirectExchange CalonDirectExchange() {
        return new DirectExchange("CalonDirectExchange");
    }
	
    //绑定
    Binding bindingDirect() {
        return BindingBuilder.bind(CalonDirectQueue()).to(CalonDirectExchange()).with("CalonDirectRouting");
    }

}
