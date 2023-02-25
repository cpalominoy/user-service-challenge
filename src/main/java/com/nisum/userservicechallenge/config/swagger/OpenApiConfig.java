package com.nisum.userservicechallenge.config.swagger;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(servers = {@Server(url = "http://localhost:9091", description = "local")})
public class OpenApiConfig {

  @Bean
  public OpenAPI customOpenApi() {
    return new OpenAPI()
        .info(
            new Info()
                .title("Administración de usuarios")
                .version("1.0.0")
                .description("Servicio de Administración de usuarios -  NISUM"));
  }
}
