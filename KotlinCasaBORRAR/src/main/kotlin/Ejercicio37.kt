import java.lang.Exception
import java.util.Random


val random = Random()

fun esperar(segundos: Int) {

    val miliSeg:Long = segundos.toLong() * 1000
    try {

        Thread.sleep(miliSeg)

    } catch (e: Exception) {

        println("No se que ha pasado")

    }

}

fun tiradaMaquina(): Int {

    return random.nextInt(1,4)

}

fun ganado(tirada: String, maquina: String): Boolean? {

    return when (tirada) {

        "Piedra" -> {

            return when (maquina) {
                "Papel" -> false
                "Tijera" -> true
                else -> null
            }

        }

        "Papel" -> {

            return when (maquina) {
                "Piedra" -> true
                "Tijera" -> false
                else -> null
            }

        }

        "Tijera" -> {

            return when (maquina) {
                "Papel" -> true
                "Piedra" -> false
                else -> null
            }

        }

        else -> null

    }

}

fun traducirElecion(opt: Int): String {

    return when (opt) {

        1 -> "Piedra"
        2 -> "Papel"
        3 -> "Tijera"
        else -> "tonto"

    }

}

fun main() {

    println("Juego de piedra, papel o tijera. Gana el primero a 3 puntos")
    var contUsuario = 0
    var contMaquina = 0
    do {

        println("--- ELIGE ---")
        println("1 - Piedra")
        println("2 - Papel")
        println("3 - Tijera")
        print("> ")

        try {

            val opt = leer.nextLine().toInt()

            val tirada = traducirElecion(opt)
            var ganado:Boolean?

            if (tirada != "tonto") {

                val maquina = traducirElecion(tiradaMaquina())
                println("Elección de la máquina: $maquina")

                ganado = ganado(tirada,maquina)

            } else {

                println("¡ Elige una opción válida !")
                continue

            }

            esperar(1)

            when (ganado) {

                true -> {
                    println("- RONDA GANADA -")
                    contUsuario++
                }

                false -> {
                    println("- RONDA PERDIDA -")
                    contMaquina++
                }
                else -> println("- EMPATE -")

            }

        } catch (e: NumberFormatException) {

            println("¡¡¡ Introduce un número entero !!!")

        }

        println("Puntuación: ")
        println("Tú: $contUsuario")
        println("Máquina: $contMaquina")

    } while (contUsuario != 3 && contMaquina != 3)

    if (contUsuario == 3) {

        println("¡ HAS GANADO !")

    } else {

        println("¡ HAS PERDIDO JAJAJAJA !")

    }

}