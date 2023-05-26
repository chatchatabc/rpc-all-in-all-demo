package com.chatchatabc.rpc;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "Spring Boot REST API Documentation",
                description = "Spring Boot REST API Documentation",
                version = "0.1.0",
                contact = @Contact(
                        name = "linux_china",
                        email = "libing.chen@gmail.com"
                )
        )
)
public class RpcBootApp {

    public static void main(String[] args) {
        SpringApplication.run(RpcBootApp.class, args);
    }

}
