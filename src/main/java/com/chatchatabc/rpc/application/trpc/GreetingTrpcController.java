package com.chatchatabc.rpc.application.trpc;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingTrpcController extends TrpcBaseController {

    @GetMapping(value = "/greeting.hello", produces = "application/json")
    public TrpcResponse<String> hello(@RequestParam("input") JsonNode jsonNode) throws Exception {
        record Hello(String name) {
        }
        final Hello hello = objectMapper.convertValue(jsonNode, Hello.class);
        return TrpcResponse.of("Hello " + hello.name);
    }

    @GetMapping(value = "/greeting.hello2")
    public TrpcResponse<String> hello2(@RequestParam("input") JsonNode jsonNode) throws Exception {
        final String name = jsonNode.asText();
        return TrpcResponse.of("Hello, " + name + "!");
    }

}
