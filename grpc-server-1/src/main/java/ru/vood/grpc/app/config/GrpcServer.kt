package ru.vood.grpc.app.config

import com.google.protobuf.Empty
import io.grpc.stub.StreamObserver
import net.devh.boot.grpc.server.service.GrpcService
import org.slf4j.LoggerFactory
import ru.vood.grpc.app.GlobalGrpcExceptionHandler
import ru.vood.grpc.app.proto.HelloRequest
import ru.vood.grpc.app.proto.SimpleGrpc.SimpleImplBase

@GrpcService
class GrpcServer : SimpleImplBase(), SyncResponseSender<Empty> {

    private val LOGGER = LoggerFactory.getLogger(GlobalGrpcExceptionHandler::class.java)

    override fun sayHello(request: HelloRequest, responseObserver: StreamObserver<Empty>) {
        super.sayHello(request, responseObserver)
        sendOk(responseObserver, Empty.getDefaultInstance())

    }

}