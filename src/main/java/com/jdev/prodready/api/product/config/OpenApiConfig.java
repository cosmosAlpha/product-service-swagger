package com.jdev.prodready.api.product.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenApiConfig {

    // Reads environment variable APP_OPENAPI_SERVER_URL or defaults to localhost
    @Value("${app.openapi.server-url:http://localhost:8080}")
    private String serverUrl;

    @Value("${app.env:local}")
    private String environment;

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Product API Service")
                        .version("1.0.0")
                        .description("High-performance microservice with containerized OpenAPI documentation.")
                        .contact(new Contact().name("Platform Engineering").email("jdevprodready@example.com"))
                        .license(new License().name("Apache 2.0").url("https://www.apache.org/licenses/LICENSE-2.0")))
                .servers(List.of(
                        new Server()
                                .url(serverUrl)
                                .description("Active Dynamic Server Host Environment: " + environment)
                ));
    }
}
