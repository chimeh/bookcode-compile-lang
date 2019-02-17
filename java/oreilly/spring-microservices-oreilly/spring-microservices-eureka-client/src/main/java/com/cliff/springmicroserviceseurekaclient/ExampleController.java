package com.cliff.springmicroserviceseurekaclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * User: Cliff
 */
@RestController
public class ExampleController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/execute")
    public String execute() {
        return restTemplate.getForObject( "http://MYOTHERCLIENT/serviceinfo", String.class );
    }
}
