package com.escom.restaurante.restaurante.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;

@Configuration
public class OpenApiConfig {
    
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API Restaurante")
                        .version("1.7.0")
                        .description("Los restaurantes enfrentan desafíos al gestionar recetas, controlar inventarios de ingredientes y garantizar que los platos se preparen de manera consistente"));
    }

}
