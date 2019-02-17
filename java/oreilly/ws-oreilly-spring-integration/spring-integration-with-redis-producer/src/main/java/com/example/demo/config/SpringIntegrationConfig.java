package com.example.demo.config;

import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@ImportResource("classpath:/spring-integration.xml")
@AutoConfigureAfter(RedisConfig.class)
@Configuration
public class SpringIntegrationConfig {

}
