package com.chatchatabc.rpc.application.trpc;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingTrpcController {
    record Hello(String name) {
    }

    @GetMapping(value = "/greeting.hello", produces = "application/json")
    public TrpcResponse<String> hello(@TrpcInput Hello hello) throws Exception {
        return TrpcResponse.of("Hello " + hello.name);
    }

    @GetMapping(value = "/greeting.hello2")
    public TrpcResponse<String> hello2(@TrpcInput String name) throws Exception {
        return TrpcResponse.of("Hello, " + name + "!");
    }

}
