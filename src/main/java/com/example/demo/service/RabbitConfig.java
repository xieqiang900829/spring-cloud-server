package com.example.demo.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.core.Queue;


/**
 * Created by WD42700 on 2018/9/3.
 */
//@Configuration
public class RabbitConfig {

    //@Bean
    public Queue helloQueue(){
        //https://blog.csdn.net/wqh8522/article/details/79157808
        //hello 是消息队列的名称
        //RabbitMQ中添加一个hello队列，进入RabbitMQ的管理页面
        return new Queue("hello");
    }

}
