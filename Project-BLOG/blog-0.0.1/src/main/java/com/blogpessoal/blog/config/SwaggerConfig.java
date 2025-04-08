package com.blogpessoal.blog.config;

import io.swagger.v3.oas.models.*;
import io.swagger.v3.oas.models.info.*;
import org.springframework.context.annotation.*;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI springBlogPessoalOpenAPI() {
        return new OpenAPI()
            .info(new Info()
                .title("Projeto Blog Pessoal")
                .description("Documentação da API do Blog Pessoal")
                .version("v1.0.0")
                .contact(new Contact()
                    .name("Jemima - Dev 💻")
                    .email("jemima@email.com")));
    }
}
