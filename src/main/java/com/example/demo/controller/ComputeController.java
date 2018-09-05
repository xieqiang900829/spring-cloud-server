package com.example.demo.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.Random;


/**
 * Created by WD42700 on 2018/8/19.
 */

//@RestController注解相当于@ResponseBody ＋ @Controller   RequestMapping需要再单独定义
//@RestController虽然继承了@Controller，但是却不能返回jsp，即试图解析器InternalResourceViewResolver会失效。value属性不要使用

   /* 首先@ApiOperation注解不是Spring自带的，它是是swagger里的
        注解@ApiOperation是用来构建Api文档的
@ApiOperation(value = “接口说明”, httpMethod = “接口请求方式”, response =
        “接口返回参数类型”, notes = “接口发布说明”；其他参数可参考源码；*/

@RequestMapping("/compute")
@RestController
public class ComputeController {

    private final Logger logger = Logger.getLogger(getClass());

    public  static  int  count =0;
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
    @ApiOperation(value="减法", notes="减法标记")// 使用该注解描述接口方法信息
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
    @ApiOperation(value="乘法", notes="乘法标记")// 使用该注解描述接口方法信息
    @ApiImplicitParams({
            @ApiImplicitParam(name = "a", value = "a", required = true, dataType = "Long", paramType="path"),
            @ApiImplicitParam(name = "b", value = "b", required = true, dataType = "Long", paramType="path")
    })// 使用该注解描述方法参数信息，此处需要注意的是paramType参数，需要配置成path，否则在UI中访问接口方法时，
    @GetMapping("/multi/{a}/{b}")
    public Long multi(@PathVariable("a")Long a,@PathVariable("b")Long b) {
        count++;
        System.out.println("乘法第"+count+"次被执行");

        Random  r =new  Random();
        int temp = r.nextInt(3);
        if(temp == 2){
            //System.out.println("开始睡眠");
            try {
                Thread.sleep(5000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
           // System.out.println("睡眠结束");
        }


        //System.out.println(s);
        return  a*b;
    }


}
