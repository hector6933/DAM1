import com.sun.org.apache.bcel.internal.generic.IFEQ
import kotlin.math.sqrt
fun esPrimo(num: Int): Boolean {

    if (num < 2) return false

    for (i in 2 until num) {

        if (num % i == 0) {

            return false

        }

    }

    return true

}

fun primosHasta(num: Int): ArrayList<Int> {

    val primos = ArrayList<Int>()

    for (i in 1..num) {

        if (esPrimo(i)) {

            primos.add(i)

        }

    }

    return primos

}

fun factorial(num: Int): Int {

    return if (num < 1) {

        1

    } else {

        factorial(num-1) * num

    }

}

fun main() {

    println(factorial(5))

    println(primosHasta(20))


}