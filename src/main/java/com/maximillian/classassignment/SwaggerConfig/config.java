package com.maximillian.classassignment.SwaggerConfig;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class config {
    @Value("${application.version}")
    private String version;

    @Bean
    public OpenAPI api(){
        return new OpenAPI()
                .info(new Info()
                        .title("ClassAssignment_Week9")
                        .description("A class task supervised By Mr.Gadibia")
                        .version(version));
    }

    @Bean
    public GroupedOpenApi usersEndpoint(){
        return  GroupedOpenApi
                .builder()
                .group("Users")
                .pathsToMatch("/api/v1/users/**").build();
    }

    }
