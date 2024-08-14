package com.example.spring_crud.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Title Rest API")
                        .version("1.0")
                        .description("API exemplo de uso de Springboot REST API")
                        .termsOfService("Termo de uso: Open Source")
                        .contact(new Contact()
                                .name("Felipe")
                                .url("http://www.teste.com.br")
                                .email("meuEmail@email.com"))
                        .license(new License()
                                .name("Licença Sua Empresa")
                                .url("http://www.seusite.com.br"))
                );
    }
}
