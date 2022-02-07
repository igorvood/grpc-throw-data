package ru.vood.grpc.app.config

import com.google.protobuf.GeneratedMessageV3
import io.grpc.Status
import io.grpc.stub.StreamObserver

interface SyncResponseSender<T : GeneratedMessageV3> {

    fun sendOk(responseObserver: StreamObserver<T>, rsp: T) {
        responseObserver.onNext(rsp)
        responseObserver.onCompleted()
    }

    fun sendError(responseObserver: StreamObserver<T>, e: Throwable, st: Status) {
        responseObserver.onError(
            st.withCause(e).withDescription(e.message).asRuntimeException()
        )
    }
}
