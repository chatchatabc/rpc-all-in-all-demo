package com.chatchatabc.rpc.application.trpc;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class PosterTrpcController {
    record Poster(String id, String title, String text) {
    }

    @PostMapping("/poster.createPost")
    public TrpcResponse<Poster> createPost(@TrpcInput Poster poster) {
        return TrpcResponse.of(new Poster(UUID.randomUUID().toString(), poster.title, poster.text));
    }
}
