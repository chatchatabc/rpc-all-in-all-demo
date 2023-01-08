package com.chatchatabc.rpc.application.rsocket;

import org.springframework.graphql.ExecutionGraphQlService;
import org.springframework.graphql.server.GraphQlRSocketHandler;
import org.springframework.http.codec.json.Jackson2JsonEncoder;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;

@Controller
public class GraphqlOverRSocketController {
    private final GraphQlRSocketHandler handler;

    GraphqlOverRSocketController(ExecutionGraphQlService graphQlService) {
        this.handler = new GraphQlRSocketHandler(graphQlService, List.of(), new Jackson2JsonEncoder());
    }

    @MessageMapping("graphql")
    public Mono<Map<String, Object>> handle(Map<String, Object> payload) {
        return this.handler.handle(payload);
    }

    @MessageMapping("graphql")
    public Flux<Map<String, Object>> handleSubscription(Map<String, Object> payload) {
        return this.handler.handleSubscription(payload);
    }
}
