import kotlinx.coroutines.*
import java.lang.RuntimeException
import java.util.concurrent.Executors

// this launches 2 coroutines and uses async() and await() to later wait for the results

fun main() {

    suspend fun task1(): String {
        log("running task 1")
        throw RuntimeException()
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
            //          supervisorScope {

            val defer1 = async {
                task1()
            }
            val defer2 = async {
                task2()
            }
            var result1 = ""
            var result2 = ""

            try {
                result1 = defer1.await()
            } catch (throwable: Throwable) {
                log("Error calling task 1 ${throwable.message}")
            }
            try {
                result2 = defer2.await()
            } catch (throwable: Throwable) {
                log("Error calling task 2 ${throwable.message}")
            }
            log("$result1 $result2")
        }
    }
    //   }
    println("Finish")
}
