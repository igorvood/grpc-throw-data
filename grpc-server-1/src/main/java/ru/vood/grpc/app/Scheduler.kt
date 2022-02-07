package ru.vood.grpc.app

import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service
import ru.vood.grpc.app.proto2.HelloRequest2
import ru.vood.grpc.app.proto2.Simple2Grpc
import java.util.*

@Service
class Scheduler(val sad: Simple2Grpc.Simple2BlockingStub) {


    @Scheduled(fixedDelay = 1000)
    fun sad() {
        val random = Random()
        val randomWithNextInt: Int = random.nextInt()
        sad.getHello(HelloRequest2.newBuilder()
            .setName("Igor $randomWithNextInt")
            .build())
    }
}