package com.cliff.springmicroserviceshystrix;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@RestController
@EnableHystrix
@EnableHystrixDashboard
public class SpringMicroservicesHystrixApplication {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate(  );
    }

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/startClient")
    //tell Hystrix to timeout if a method takes over 500 milliseconds to execute
    @HystrixCommand(fallbackMethod = "failover", commandProperties = {
            @HystrixProperty( name = "execution.isolation.thread.timeoutInMilliseconds", value = "500")
    })
    public List<String> startClient( @RequestParam long time ) throws InterruptedException {
        Thread.sleep( time );
        return restTemplate.getForObject( "http://localhost:8888/service", List.class );
    }

    public List<String> failover( long time ) {
        return Arrays.asList("default1","default2");
    }

    public static void main( String[] args ) {
        SpringApplication.run( SpringMicroservicesHystrixApplication.class, args );
    }
}
