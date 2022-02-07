package ru.vood.grpc.app

import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service
import ru.vood.grpc.app.proto.HelloRequest
import ru.vood.grpc.app.proto.SimpleGrpc
import ru.vood.grpc.app.proto2.HelloRequest2
import ru.vood.grpc.app.proto2.Simple2Grpc
import java.util.*

@Service
class Scheduler(val client: SimpleGrpc.SimpleBlockingStub) {


    @Scheduled(fixedDelay = 10000)
    fun sad() {
        val random = Random()
        val randomWithNextInt: Int = random.nextInt()
        client.sayHello(
            HelloRequest.newBuilder()
            .setName("Igor $randomWithNextInt")
            .build())
    }
}