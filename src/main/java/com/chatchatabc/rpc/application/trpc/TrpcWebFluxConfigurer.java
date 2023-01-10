package com.chatchatabc.rpc.application.trpc;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.WebFluxConfigurer;
import org.springframework.web.reactive.result.method.annotation.ArgumentResolverConfigurer;

@Configuration
public class TrpcWebFluxConfigurer implements WebFluxConfigurer {
    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void configureArgumentResolvers(ArgumentResolverConfigurer configurer) {
        configurer.addCustomResolver(new TrpcInputArgumentResolver(this.objectMapper));
    }
}
