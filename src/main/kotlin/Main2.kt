import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


fun main() = runBlocking {
    printHelloWorld()
}

suspend fun printHelloWorld() = coroutineScope {  // this: CoroutineScope
    //creating a coroutine
    launch {
        log("starting coroutine")
        delay(1000) // non-blocking delay for 1 second
        log("delay coroutine")
        println("World!") // print after delay
    }
    println("Hello")
}