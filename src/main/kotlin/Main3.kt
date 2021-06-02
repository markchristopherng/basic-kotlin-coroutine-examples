import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext


fun main() = runBlocking {
    printHelloWorld(this.coroutineContext)
}

suspend fun printHelloWorld(parentCoroutineContext: CoroutineContext) {

    //CoroutineContext = Dispatcher (where to run coroutine) + Job (cancellable thing)
    val localCoroutineContext = Dispatchers.Default + parentCoroutineContext.job

    //Scope of coroutine
    val scope = CoroutineScope(localCoroutineContext)

    //creating a coroutine
    scope.launch {
        log("starting coroutine")
        delay(1000) // non-blocking delay for 1 second
        log("delay coroutine")
        println("World!") // print after delay
    }
    println("Hello")

}


