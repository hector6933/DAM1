import java.util.regex.Matcher
import java.util.regex.Pattern

fun main() {

    do {

        println("Introduce números separados por comas Ej: 1,2,3,4 1,2")
        print("> ")
        val cadena = leer.nextLine()
        if (!Pattern.matches("^\\d+(,\\d+)*$",cadena)) {

            println("¡ Formato incorrecto !")

        } else {

            try {

                val numeros = cadena.split(",")
                println(numeros.sumOf { it.toBigInteger() })

            } catch (e: NumberFormatException) {

                println("¡ Error al convertir los números !")

            }

        }

    } while (true)

}
