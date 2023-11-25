import java.util.*
import kotlin.concurrent.schedule

class zvon( val delaySeconds: Long) {
    var isRinging: Boolean = false

    fun start() {
        Timer("tick ", false).schedule(delaySeconds * 1000) {
            isRinging = true
            println("chick  BOOM !")
        }
        Timer("tick", true).schedule(0, 1000) {
            if (!isRinging) {
                println("click - chick ")
            }
        }
    }
}

fun main() {
    val  zvon1 = zvon( 5)
    val  zvon2 = zvon( 7)
    val  zvon3 = zvon( 10)

    zvon1.start()
    zvon2.start()
    zvon3.start()

    // Ждем некоторое время, чтобы увидеть звонки будильников
    Thread.sleep(15000)
}