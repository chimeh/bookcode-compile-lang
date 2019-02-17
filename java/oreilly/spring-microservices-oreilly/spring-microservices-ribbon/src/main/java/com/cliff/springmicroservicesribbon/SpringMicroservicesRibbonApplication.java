package com.cliff.springmicroservicesribbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

//SimpleServiceConfiguration must not be componentScanned (as per Ribbon Docs)
@SpringBootApplication
@RestController
@RibbonClient(name = "simple-service-2", configuration = com.cliff.config.SimpleServiceConfiguration.class)
public class SpringMicroservicesRibbonApplication {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Autowired
    public RestTemplate restTemplate;

    @RequestMapping("/startClient")
    public String startClient() {
        return restTemplate.getForObject( "http://simple-service-2/execute" , String.class );
    }

    public static void main( String[] args ) {
        SpringApplication.run( SpringMicroservicesRibbonApplication.class, args );
    }
}
