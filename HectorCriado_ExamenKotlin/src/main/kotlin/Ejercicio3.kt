fun retirarDinero(saldo: Double): Double {

    do {

        println("Introduce la cantidad para retirar")
        print("> ")

        try {

            var cantidad = leer.nextLine().toDouble()

            if (cantidad < 0) {

                println("¡No puedes ingresar una cantidad negativa!")

            } else if (cantidad > saldo) {

                println("¡No puedes retirar una cantidad mayor a tu saldo!")

            } else {

                return cantidad

            }

        } catch (e : NumberFormatException) {

            println("¡Introduce un número decimal!")

        }

    } while (true)

}

fun ingresarDinero(): Double {

    do {

        println("Introduce la cantidad para ingresar")
        print("> ")

        try {

            var cantidad = leer.nextLine().toDouble()

            if (cantidad < 0) {

                println("¡No puedes ingresar una cantidad negativa!")

            } else {

                return cantidad

            }

        } catch (e : NumberFormatException) {

            println("¡Introduce un número decimal!")

        }

    } while (true)

}

fun main() {

    var saldo = 1000.0

    do {

        println("1 - Consultar saldo")
        println("2 - Ingresar dinero")
        println("3 - Retirar dinero")
        println("4 - Salir")
        print("> ")

        try {

            var opt = leer.nextLine().toInt()

            when (opt) {

                1 -> println(saldo)
                2 -> saldo += ingresarDinero()
                3 -> saldo -= retirarDinero(saldo)
                4 -> break
                else -> println("¡Opción inválida!")
            }

        } catch (e: NumberFormatException) {

            println("¡Introduce un número!")

        }

    } while (true)

}