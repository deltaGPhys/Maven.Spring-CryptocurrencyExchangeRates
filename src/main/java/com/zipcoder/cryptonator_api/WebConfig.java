package com.zipcoder.cryptonator_api;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

    public void configuationDefaultServletHandling (DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
}
