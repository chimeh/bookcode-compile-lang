package com.MeterReads.MeterReads.Configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * This is the configuration class for the Spring Boot application. It
 * is separated out from the main class so that we can use separate configurations
 * for both running the application and testing
 */
@Configuration
@EnableSwagger2
@EnableAspectJAutoProxy
public class MeterReadsApplicationConfiguration {
}
