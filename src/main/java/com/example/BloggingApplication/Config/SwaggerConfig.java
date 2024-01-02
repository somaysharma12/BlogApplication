package com.example.BloggingApplication.Config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info().title("Bloggin  Application Manager")
                        .description("This manages enitre user journey and post journey ")
                        .version("v0.0.1"));
    }
}