package com.cliff.springmicroservicesoauthresource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

import javax.sql.DataSource;

/**
 * User: Cliff
 */
@Configuration
public class ResourceServerConfig {

    //used to validate tokens that we receive
    private static final String CHECK_TOKEN_URL = "http://localhost:9090/oauth/check_token";


//    @Override
//    public void configure( ResourceServerSecurityConfigurer resources ) throws Exception {
//        resources.tokenServices( tokenServices() )
//                .tokenStore( tokenStore() );
//    }

    @Bean
    @Primary
    public ResourceServerTokenServices tokenServices() {
        RemoteTokenServices tokenService = new RemoteTokenServices();
        tokenService.setCheckTokenEndpointUrl( CHECK_TOKEN_URL );
        tokenService.setClientId( "resource1" );    //this is configured in the database used by authentication server
        tokenService.setClientSecret( "secret" );
        return tokenService;
    }

    @Bean
    public TokenStore tokenStore() {
        //tokens stores in our datasource
        return new JdbcTokenStore( dataSource() );
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName( "org.hsqldb.jdbcDriver" );
        dataSource.setUrl( "jdbc:hsqldb:hsql://localhost/testdb" );
        dataSource.setUsername( "SA" );
        dataSource.setPassword( "" );
        return dataSource;
    }
}
