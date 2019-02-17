package com.TacoCloud.TacoCloud.Configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * This is a separate configuration class which we add in order to add view controllers.
 * We could add it as part of the TacoCloudApplication class but this would dilute it, it
 * makes sense to have it as a separate configuration.
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    /**
     * We can add the view here as it is static and does not require any parameters.
     *
     * @param registry The registry of view controllers. We add all of the views to
     *                 this in order for the Spring container to recognise them.
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("home");
    }

}
