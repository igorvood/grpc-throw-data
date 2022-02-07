package ru.vood.grpc.app

import io.grpc.*
import net.devh.boot.grpc.server.interceptor.GrpcGlobalServerInterceptor
import org.slf4j.LoggerFactory

@GrpcGlobalServerInterceptor
class GlobalGrpcExceptionHandler : ServerInterceptor {

    private val LOGGER = LoggerFactory.getLogger(GlobalGrpcExceptionHandler::class.java)

    override fun <ReqT : Any, RespT : Any> interceptCall(
        call: ServerCall<ReqT, RespT>,
        headers: Metadata,
        next: ServerCallHandler<ReqT, RespT>
    ): ServerCall.Listener<ReqT> {
        LOGGER.info("calling {} parameters {}", call.methodDescriptor.fullMethodName, call.attributes.toString())
        val delegate = next.startCall(call, headers)
        return object : ForwardingServerCallListener.SimpleForwardingServerCallListener<ReqT>(delegate) {
            override fun onHalfClose() {
                try {
                    super.onHalfClose()
                } catch (e: Exception) {
                    LOGGER.error("{} - {}", e, e.message)
                    call.close(Status.INTERNAL.withCause(e).withDescription(e.message), Metadata())
                }
            }
        }
    }
}