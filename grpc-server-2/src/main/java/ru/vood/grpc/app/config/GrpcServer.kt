package ru.vood.grpc.app.config

import com.google.protobuf.Empty
import io.grpc.Status
import io.grpc.stub.StreamObserver
import net.devh.boot.grpc.server.service.GrpcService
import org.slf4j.LoggerFactory
import ru.vood.grpc.app.GlobalGrpcExceptionHandler
import ru.vood.grpc.app.proto.HelloRequest
import ru.vood.grpc.app.proto.SimpleGrpc.SimpleImplBase
import ru.vood.grpc.app.proto2.HelloRequest2
import ru.vood.grpc.app.proto2.Simple2Grpc

@GrpcService
class GrpcServer(/*val client: Simple2BlockingStub*/) : Simple2Grpc.Simple2ImplBase(), SyncResponseSender<Empty> {

    private val LOGGER = LoggerFactory.getLogger(GlobalGrpcExceptionHandler::class.java)

    override fun getHello(request: HelloRequest2, responseObserver: StreamObserver<Empty>) {
        LOGGER.info("sayHello ${request.name}")
        this.sendError(responseObserver = responseObserver, e = error("in error ${request.name}"), st = Status.INTERNAL)
//        sendOk(responseObserver, Empty.getDefaultInstance())
    }

/*
    override fun sayHello(request: HelloRequest, responseObserver: StreamObserver<Empty>) {

        LOGGER.info("sayHello ${request.name}")
//        val hello = client.getHello(HelloRequest2.newBuilder().setName(request.name).build())
        sendOk(responseObserver, Empty.getDefaultInstance())

    }
*/

}