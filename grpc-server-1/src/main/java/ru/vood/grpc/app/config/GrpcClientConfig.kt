package ru.vood.grpc.app.config

import net.devh.boot.grpc.client.inject.GrpcClient
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import ru.vood.grpc.app.proto.SimpleGrpc

@Configuration
open class GrpcClientConfig {

    @Bean
    @GrpcClient("srv2")
    open fun sad(sad: SimpleGrpc.SimpleBlockingStub) = sad
}