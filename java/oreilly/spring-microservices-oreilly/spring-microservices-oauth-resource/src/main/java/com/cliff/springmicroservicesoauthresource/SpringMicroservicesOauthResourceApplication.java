package com.cliff.springmicroservicesoauthresource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.security.Principal;

/**
 * THe OAuth Resource Server
 * Houses resource owner data and can grant access to that data
 */
@SpringBootApplication
@EnableResourceServer
@RestController
@EnableGlobalMethodSecurity( prePostEnabled = true )
public class SpringMicroservicesOauthResourceApplication {



    @RequestMapping("/resource/endpoint")
    @PreAuthorize( "hasRole('ADMIN')" )
    public String endpoint( Principal principal ) {
        return String.format( "Welcome %s this message is protected by the resource server", principal.getName() );
    }



    public static void main( String[] args ) {
        SpringApplication.run( SpringMicroservicesOauthResourceApplication.class, args );
    }
}
