package com.chatchatabc.rpc.application.trpc;

import java.lang.annotation.*;

@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TrpcInput {
}
