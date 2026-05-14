import kotlin.math.sqrt

fun main() {

    // Un número perfecto es un número que es igual a la suma de sus divisores positivos propios.

    var suma:Int
    for (i in 1..10000) {

        suma = 0
        for (j in 1 until i) {

            if (i % j == 0) {

                suma += j

            }

        }

        if (i == suma) {

            println(i)

        }

    }


}