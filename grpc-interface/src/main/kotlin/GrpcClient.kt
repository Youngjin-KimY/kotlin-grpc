

import helloworld.GreeterGrpc
import helloworld.helloRequest
import io.grpc.ManagedChannelBuilder



fun main() {
    val channel = ManagedChannelBuilder.forAddress("localhost",50051)
        .usePlaintext()
        .build()

    println(channel)
    val stub = GreeterGrpc.newBlockingStub(channel)

    val res = stub.sayHello(helloRequest { name="jj" })

    println("response: $res")

    channel.shutdown()
}