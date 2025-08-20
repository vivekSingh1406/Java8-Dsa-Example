package com.bezkoder.spring.thymeleaf.config;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class OpenApiConfig {


    @Bean
    public OpenAPI api() {
        return new OpenAPI().info(new Info()
                .title("LMS API")
                .description("CRUD for Users, Courses, Enrollments with validations")
                .version("v1"));
    }
}