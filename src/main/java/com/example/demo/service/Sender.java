package com.example.demo.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by WD42700 on 2018/9/3.
 */

//@Component
public class Sender {

    //@Autowired
    private AmqpTemplate amqpTemplate;

    public void send() {
        String context = "hello " + new Date();
        this.amqpTemplate.convertAndSend("hello", context);
    }


}
