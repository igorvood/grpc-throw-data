package ru.vood.grpc.app.config

import net.devh.boot.grpc.client.inject.GrpcClient
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import ru.vood.grpc.app.proto2.Simple2Grpc.Simple2BlockingStub

@Configuration
open class GrpcClientConfig {

    @GrpcClient("srv2")
    lateinit var sad: Simple2BlockingStub

    @Bean
    open fun sad1()/*(sad: Simple2Grpc.Simple2BlockingStub)*/ = sad
}