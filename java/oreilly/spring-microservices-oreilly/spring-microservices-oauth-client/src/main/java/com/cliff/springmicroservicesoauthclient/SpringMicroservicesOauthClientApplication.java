package com.cliff.springmicroservicesoauthclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.token.AccessTokenRequest;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;
import java.security.Principal;

@SpringBootApplication
@EnableOAuth2Client
@RestController
public class SpringMicroservicesOauthClientApplication {

    @Autowired
    private OAuth2RestTemplate restTemplate;


    @Bean
    public OAuth2RestTemplate restTemplate() {
        return new OAuth2RestTemplate( resource(), new DefaultOAuth2ClientContext() );
    }

    @Bean
    protected OAuth2ProtectedResourceDetails resource() {
        ResourceOwnerPasswordResourceDetails details = new ResourceOwnerPasswordResourceDetails();
        details.setAccessTokenUri( "http://localhost:9090/oauth/token" ); //resource server URI
        details.setClientId( "webapp" );
        details.setClientSecret( "websecret" );
        details.setGrantType( "password" );
        return details;
    }

    @RequestMapping("/execute")
    public String execute( Principal principal ) throws URISyntaxException {
        Authentication auth = (Authentication) principal;
        UsernamePasswordAuthenticationToken upat = (UsernamePasswordAuthenticationToken) auth;
        System.out.println( String.format( "username:%s   password:%s", upat.getName(), upat.getCredentials().toString() ));
        URI uri = new URI("http://localhost:7070/resource/endpoint");
        RequestEntity<String> request = new RequestEntity<>( HttpMethod.POST, uri );
        AccessTokenRequest accessTokenRequest = restTemplate.getOAuth2ClientContext().getAccessTokenRequest();
        accessTokenRequest.set( "username", upat.getName() );
        accessTokenRequest.set( "password", upat.getCredentials().toString() );

        return restTemplate.exchange( request, String.class ).getBody();
    }

    public static void main( String[] args ) {
        SpringApplication.run( SpringMicroservicesOauthClientApplication.class, args );
    }
}
