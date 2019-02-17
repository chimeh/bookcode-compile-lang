package com.cliff.springmicroservicessimpleservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@RestController
public class SpringMicroservicesSimpleServiceApplication {

    @GetMapping("/service")
    public List<String> execute() {
        return Arrays.asList("Value1", "Value2");
    }

    public static void main( String[] args ) {
        SpringApplication.run( SpringMicroservicesSimpleServiceApplication.class, args );
    }
}
