package com.dbc.pessoaapi.service;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ConfigurationCors  implements WebMvcConfigurer {
    public  void addCorsMappings (CorsRegistry registry){
        registry.addMapping("/**")
                .allowedMethods("*")
                .exposedHeaders("Authorization");
    }
}
