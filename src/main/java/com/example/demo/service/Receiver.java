package com.example.demo.service;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by WD42700 on 2018/9/3.
 */

//@Component
//@RabbitListener(queues = "hello")
public class Receiver {

    //@RabbitHandler
    public void process(String hello) {
        System.out.println("Receiver : " + hello);
    }

}
