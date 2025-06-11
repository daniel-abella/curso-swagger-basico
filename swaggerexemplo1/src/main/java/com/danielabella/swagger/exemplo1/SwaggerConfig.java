package com.danielabella.swagger.exemplo1;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI apiInfo() {
        return new OpenAPI().info(new Info()
            .title("API de Produtos")
            .version("1.0")
            .description("API CRUD de produtos com documentação Swagger"));
    }
}
