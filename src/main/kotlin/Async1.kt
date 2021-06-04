import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import java.util.concurrent.Executors

// this launches 2 coroutines and uses async() and await() to later wait for the results

fun main() {

    suspend fun task1(): String {
        log("running task 1")
        delay(5000)
        log("task1 finished delay")
        return "Hello"
    }

    suspend fun task2(): String {
        log("running task 2")
        delay(2000)
        log("task2 finished delay")
        return "World"
    }
    println("Start")

    Executors.newSingleThreadExecutor().asCoroutineDispatcher().use { context ->
        runBlocking {
            val defer1 = async {
                task1()
            }
            val defer2 = async {
                task2()
            }
            log("${defer1.await()} ${defer2.await()}")
        }
    }
    println("Finish")
}
