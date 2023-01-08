RPC all-in-one Demo
===============================
         
Spring Boot app with all-in-one RPC demo.

# Protocols

* [HTTP REST API](https://spring.io/guides/tutorials/rest/)
* [GraphQL](https://graphql.org/): GraphQL over HTTP, WebSocket and RSocket
* [tRPC](https://trpc.io/)
* [RSocket](https://rsocket.io/): RSocket over WebSocket, GraphQL support
* [gRPC](https://grpc.io/): Please refer https://github.com/chatchatabc/grpc-demo 
* [dubbo](https://cn.dubbo.apache.org/en/): please refer https://github.com/chatchatabc/spring-dubbo-demo
         
# Get Started

### Start Spring Boot RPC server
  
Run `mvn spring-boot:run` from the command line or run `RpcBootApp` from your IDE.

### Start tRPC Server

Run `npm run dev:server` to start tRPC server and run `npm run dev:client` to start tRPC client.

# References

* Spring GraphQL: https://spring.io/projects/spring-graphql
* Spring Boot GraphQL: https://docs.spring.io/spring-graphql/docs/current/reference/html/
* RSocket: https://rsocket.io/
* RSocket JetBrains Plugin: https://plugins.jetbrains.com/plugin/18195-rsocket-requests-in-http-client
* httpx JetBrains Plugin: https://plugins.jetbrains.com/plugin/18807-httpx-requests
* Spring Custom Property Editor: property editor for JsonNode of Jackson https://www.baeldung.com/spring-mvc-custom-property-editor
