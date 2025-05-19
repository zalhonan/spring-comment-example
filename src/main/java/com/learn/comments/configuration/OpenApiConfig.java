package com.learn.comments.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI commentsApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("Comments API")
                        .description("API for managing comments")
                        .version("1.0"));
    }
}