package com.cliff.config;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AvailabilityFilteringRule;
import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.PingUrl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * User: Cliff
 */
@Configuration
public class SimpleServiceConfiguration {

    @Autowired
    public IClientConfig ribbonClientConfig;

    //define how this client will ping the different instances that ribbon load balances across
    @Bean
    public IPing ping( IClientConfig config ) {
        return new PingUrl();
    }

    @Bean
    public IRule rule( IClientConfig config ) {
        return new AvailabilityFilteringRule();
    }
}
