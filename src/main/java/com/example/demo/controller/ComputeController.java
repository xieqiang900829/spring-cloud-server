package com.example.demo.controller;

import org.apache.log4j.Logger;
import org.bouncycastle.asn1.ocsp.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;


/**
 * Created by WD42700 on 2018/8/19.
 */
@RestController
public class ComputeController {

    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "/add" ,method = RequestMethod.GET)
    public String add() {
        ServiceInstance instance = client.getLocalServiceInstance();
        Integer r = 100;
        logger.info("/add, host:" + instance.getHost() + ", service_id:" + instance.getServiceId() + ", result:" + r);
        return "ComputeController" ;
    }


    /**
     * 减法
     * @param
     * @return
     */
    @GetMapping("/sub/{a}")
    public void sub(@PathVariable("a")Long a) {
        String  s=  "大家好，我是减法"+(a-100);
        System.out.print(s);
    }


}
