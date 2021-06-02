import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


fun log(msg: String) = println("[${Thread.currentThread().name}] $msg")

fun main() = runBlocking { // this: CoroutineScope

    launch { // launch a new coroutine and continue
        log("starting coroutine")
        delay(1000L) // non-blocking delay for 1 second
        log("World!") // print after delay
    }
    log("Hello") // main coroutine continues while a previous one is delayed
}



