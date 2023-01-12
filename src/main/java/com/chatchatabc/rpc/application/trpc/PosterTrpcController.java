package com.chatchatabc.rpc.application.trpc;

import org.jetbrains.annotations.Nullable;
import org.mvnsearch.spring.boot.trpc.TrpcInput;
import org.mvnsearch.spring.boot.trpc.TrpcMutate;
import org.mvnsearch.spring.boot.trpc.TrpcResponse;
import org.springframework.stereotype.Controller;

import java.util.UUID;

@Controller
public class PosterTrpcController {
    record Poster(@Nullable String id, String title, String text) {
    }

    @TrpcMutate("/poster.createPost")
    public TrpcResponse<Poster> createPost(@TrpcInput Poster poster) {
        return TrpcResponse.of(new Poster(UUID.randomUUID().toString(), poster.title, poster.text));
    }
}
