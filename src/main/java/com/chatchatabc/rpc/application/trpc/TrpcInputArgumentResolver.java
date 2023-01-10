package com.chatchatabc.rpc.application.trpc;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.jetbrains.annotations.NotNull;
import org.springframework.core.MethodParameter;
import org.springframework.core.ResolvableType;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.codec.json.Jackson2JsonDecoder;
import org.springframework.web.reactive.BindingContext;
import org.springframework.web.reactive.result.method.HandlerMethodArgumentResolver;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Collections;

import static org.springframework.core.ResolvableType.forClass;


public class TrpcInputArgumentResolver implements HandlerMethodArgumentResolver {
    private final ObjectMapper objectMapper;
    Jackson2JsonDecoder decoder = new Jackson2JsonDecoder();

    public TrpcInputArgumentResolver(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(TrpcInput.class);
    }

    @Override
    public @NotNull Mono<Object> resolveArgument(@NotNull MethodParameter parameter, @NotNull BindingContext bindingContext, ServerWebExchange exchange) {
        ResolvableType elementType = forClass(parameter.getParameterType());
        if (exchange.getRequest().getMethod() == HttpMethod.POST) {  //tRPC mutate
            return exchange.getRequest()
                    .getBody()
                    .map(Flux::just)
                    .map(body -> decoder.decodeToMono(body, elementType, MediaType.APPLICATION_JSON, Collections.emptyMap()).cast(parameter.getParameterType()))
                    .next()
                    .flatMap(x -> x);
        } else {  //tRPC query
            return Mono.create(monoSink -> {
                try {
                    String input = exchange.getRequest().getQueryParams().getFirst("input");
                    monoSink.success(objectMapper.readValue(input, parameter.getParameterType()));
                } catch (Exception e) {
                    monoSink.error(e);
                }
            });
        }
    }

}
