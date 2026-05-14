import com.sun.org.apache.xerces.internal.impl.dv.xs.IntegerDV

var dinero = 2000.0

fun consultarSaldo() {

    println("Saldo: ${dinero}€")

}

fun depositar() {

    do {

        println("Introduce la cantidad para depositar:")
        print("> ")

        try {

            var deposito = leer.nextLine().toDouble()

            if (deposito <= 0) {

                println("¡¡¡ Introduce un número mayor que 0 !!!")

            } else {

                dinero += deposito
                return

            }

        } catch (e: NumberFormatException) {

            println("¡¡¡ Introduce un número decimal !!!")

        }

    } while (true)

}

fun retirar() {

    do {

        println("Introduce la cantidad para retirar:")
        print("> ")

        try {

            var retirar = leer.nextLine().toDouble()

            if (retirar <= 0) {

                println("¡¡¡ Introduce un número mayor que 0 !!!")

            } else if (retirar > dinero) {

                throw DineroNoSuficienteException("NOOO PUEDES RETIRAR MAS DINERO DEL QUE TIEEEENEEEEESSSS AAAAAAAAAAAAAAAAAAAAAA")

            } else {

                dinero -= retirar
                return

            }

        } catch (e: NumberFormatException) {

            println("¡¡¡ Introduce un número decimal !!!")

        } catch (e: DineroNoSuficienteException) {

            println(e.message)

        }

    } while (true)


}

fun main() {

    do {

        println("¡ Bienvenido a tu cuenta !")
        println("1 - Consultar saldo")
        println("2 - Depositar")
        println("3 - Retirar")
        println("0 - SALIR")
        print("> ")

        try {

            val opt:Int = leer.nextLine().toInt()

            when (opt) {

                1 -> consultarSaldo()

                2 -> {
                    depositar()
                    consultarSaldo()
                }

                3 -> {
                    retirar()
                    consultarSaldo()
                }

                0 -> break

                else -> println("¡ Opción inválida !")

            }

        } catch (e: NumberFormatException) {

            println("¡¡¡ Introduce un número entero !!!")

        }

    } while (true)

}
