package com.cliff.springmicroservicesoauthserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * This is the OAUTH2 Authorization Server, it authenticates clients and grants them an access token so that they
 * can make requests from resource servers. This particular server (for demonstration purposes) will keep granted
 * tokens in a HSQLDB
 *
 * It is currently configured to retrieve client credentials stored in an HSQLDB, so that DB must be started first (see the
 * resources folder for info on how to do this)
 */
@SpringBootApplication
@RestController
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SpringMicroservicesOauthServerApplication {



    public static void main( String[] args ) {
        SpringApplication.run( SpringMicroservicesOauthServerApplication.class, args );
    }
}
