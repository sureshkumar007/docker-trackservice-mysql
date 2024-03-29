package com.stackroute.trackservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    /*
    bean is used to create a object .
    here docket is one type of saas and paas
     */
    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                /*
                here the we assign the path of the class....
                 */
                .select().apis(RequestHandlerSelectors.basePackage("com.stackroute.trackservice.controller"))
                .paths(regex("/api/v1/.*"))
                .build();

    }
}