package com.example.demo.service;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by WD42700 on 2018/9/3.
 */
//@RunWith(SpringRunner.class)
//@SpringBootTest
public class RabbitmqApplicationTest {

   // @Autowired
    private Sender sender;

    //@Test
    public void hello(){
        sender.send();
    }

}
