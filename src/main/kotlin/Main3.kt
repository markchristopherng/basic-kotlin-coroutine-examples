import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext


fun main() = runBlocking {
    printHelloWorld(this.coroutineContext)
}

suspend fun printHelloWorld(parentCoroutineContext: CoroutineContext) {

    //Coroutine scope =  CoroutineContext = Dispatcher (where to run coroutine) + Job (cancellable thing)
    CoroutineScope(Dispatchers.Default + parentCoroutineContext.job).launch {
        log("starting coroutine")
        delay(1000) // non-blocking delay for 1 second
        log("delay coroutine")
        log("World!") // print after delay
    }
    log("Hello")
}