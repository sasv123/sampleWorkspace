package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.citigroup.ccp.session.configuration.EnableDistributedSession;

@SpringBootApplication
//@EnableDiscoveryClient
@EnableDistributedSession(regionName="SSO")
//@EnableGemfireSession
public class DemoApplication {
	
	

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@LoadBalanced
	@Bean
	public RestTemplate createRest(){
	   return new RestTemplate();	
	}
	
	}
