package com.cliff.springmicroserviceszuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableZuulProxy
public class SpringMicroservicesZuulApplication {

    @Bean
    //instantiate our custom zuul filter, so that it gets automatically created and registered with zuul
    public MyZuulFilter myFilter() {
        return new MyZuulFilter();
    }

    public static void main( String[] args ) {
        SpringApplication.run( SpringMicroservicesZuulApplication.class, args );
    }
}
