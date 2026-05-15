import kotlin.concurrent.fixedRateTimer

fun esPrimo(numero: Int) :Boolean {

    if (numero < 2) return false

    for (i in 2 until numero) {

        if (numero % i == 0) {

            return false

        }

    }

    return true

}

fun main() {

    var num = 4
    var contador = 0
    do {

        var esCuasi = false
        for (i in 2..num) {

            if (num % i == 0 && esPrimo(i)) {

                if (esPrimo(num/i)) {

                    esCuasi = true

                }

            }

        }

        if (esCuasi) {

            println(num)
            contador++

        }

        num++

    } while (contador < 100)

    println("Cuasiprimos impresos: $contador")


}