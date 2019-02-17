package com.cliff.springmicroservicesoauthserver;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 * User: Cliff
 */
@Component
@EnableAuthorizationServer
public class AuthorizationServerConfigurer extends AuthorizationServerConfigurerAdapter {

    //need this to enable password grant(s)
    private AuthenticationManager authManager;

    public AuthorizationServerConfigurer( AuthenticationManager authManager ) {
        this.authManager = authManager;
    }

    @Override
    public void configure( AuthorizationServerEndpointsConfigurer endpoints ) throws Exception {
        endpoints.authenticationManager( authManager )
                .tokenStore( tokenStore() );
    }

//    @Override
//    //allows us to set up oauth clients we want available in this authentication server..stored in memory
//    public void configure( ClientDetailsServiceConfigurer clients ) throws Exception {
//        clients.inMemory()
//                .withClient( "webapp" )
//                .secret( "{noop}websecret" ) //websecret
//                .authorizedGrantTypes( "password" )
//                .scopes( "read,write,trust" );
//    }


    @Override
    public void configure( AuthorizationServerSecurityConfigurer security ) throws Exception {
        //allows tokens to be delivered and validated from our token access point
        security.checkTokenAccess( "permitAll()" );
    }

    @Override
    public void configure( ClientDetailsServiceConfigurer clients ) throws Exception {
        //client details stored in our datasource
        clients.jdbc( dataSource() );
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
