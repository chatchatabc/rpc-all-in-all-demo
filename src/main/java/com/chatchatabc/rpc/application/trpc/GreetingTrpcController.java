package com.chatchatabc.rpc.application.trpc;

import org.mvnsearch.spring.boot.trpc.TrpcInput;
import org.mvnsearch.spring.boot.trpc.TrpcQuery;
import org.mvnsearch.spring.boot.trpc.TrpcResponse;
import org.springframework.stereotype.Controller;

@Controller
public class GreetingTrpcController {
    record Hello(String name) {
    }

    @TrpcQuery("/greeting.hello")
    public TrpcResponse<String> hello(@TrpcInput Hello hello) throws Exception {
        return TrpcResponse.of("Hello " + hello.name);
    }

    @TrpcQuery(value = "/greeting.hello2")
    public TrpcResponse<String> hello2(@TrpcInput String name) throws Exception {
        return TrpcResponse.of("Hello, " + name + "!");
    }

}
