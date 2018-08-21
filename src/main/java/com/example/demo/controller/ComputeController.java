package com.example.demo.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;


/**
 * Created by WD42700 on 2018/8/19.
 */

//@RestController注解相当于@ResponseBody ＋ @Controller   RequestMapping需要再单独定义
//@RestController虽然继承了@Controller，但是却不能返回jsp，即试图解析器InternalResourceViewResolver会失效。value属性不要使用
@RequestMapping("/compute")
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
        String  s=  "大家好，我是减法 参数为："+(a-100);
        System.out.println(s);
    }

    /**
     * 乘法
     * @param
     * @return
     */
    @GetMapping("/multi/{a}/{b}")
    public Long multi(@PathVariable("a")Long a,@PathVariable("b")Long b) {
        String  s=  "大家好，我是乘法 参数为   a:"+a+"   b:"+b;
        System.out.println(s);
        return  a*b;
    }


}
