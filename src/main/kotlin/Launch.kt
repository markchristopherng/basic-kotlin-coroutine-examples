import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

// this launches 2 coroutines and runs them sequentially

fun main() {

    suspend fun task1() {
        log("running task 1")
        delay(5000)
        log("task1 finished delay")
    }

    suspend fun task2() {
        log("running task 2")
        delay(2000)
        throw RuntimeException()
        log("task2 finished delay")
    }

    println("Start")

    runBlocking {

        launch {
            try {
                task2()
            } catch (throwable: Throwable) {
                log("Exception calling task 2 ${throwable.message}")
            }
        }
        launch { task1() }
    }
    println("Finish")
}
