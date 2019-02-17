package com.cliff.springmicroservicesoauthclient;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * User: Cliff
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure( HttpSecurity http ) throws Exception {
        http
                .authorizeRequests()
                .anyRequest()
                .authenticated()
                .and()
                    .formLogin()
                .and()
                    .httpBasic();
    }

    @Override
    //specify the users within our web application
    protected void configure( AuthenticationManagerBuilder auth ) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user1")
                .password( "{noop}password1" )
                .roles( "USER" )
                .and()
                .withUser( "admin" )
                .password( "{noop}password2" )
                .roles( "ADMIN" );
        auth.eraseCredentials( false );
    }
}
