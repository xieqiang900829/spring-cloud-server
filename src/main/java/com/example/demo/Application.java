package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableCircuitBreaker
@EnableDiscoveryClient
@SpringBootApplication
public class Application {

	//springcloud暴露的服务接口 必须和Application在一个包底下、或者在他的子包底下
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
