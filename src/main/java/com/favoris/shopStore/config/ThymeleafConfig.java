package com.favoris.shopStore.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.extras.springsecurity4.dialect.SpringSecurityDialect;

import java.io.File;


@Configuration
public class ThymeleafConfig extends WebMvcConfigurerAdapter {

    @Bean
    public SpringSecurityDialect springSecurityDialect() {
        return new SpringSecurityDialect();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.
                addResourceHandler("/img/**")
                .addResourceLocations("file:" + System.getProperty("user.home") + File.separator + "images" + File.separator);

    }
}
