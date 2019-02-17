package com.MeterReads.MeterReads;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * This is the main body of the application and the API can be started from here.
 */

@Configuration
@SpringBootApplication
public class MeterReadsApplication {

    /**
     * This is the configuration for Swagger2 so we can use it to
     * document the API.
     *
     * @return A new docket for the configuration
     */
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

	public static void main(String[] args) {
		SpringApplication.run(MeterReadsApplication.class, args);
	}
}
