# start RPC server with REST, GraphQL, RSocket
rpc-server:
   mvn -DskipTests=true spring-boot:run

# start tRPC Server
trpc-server:
   npm run dev:server