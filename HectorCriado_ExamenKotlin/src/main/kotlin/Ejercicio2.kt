import java.util.Scanner

val leer = Scanner(System.`in`)

fun esPalindromo(frase : String): Boolean {

    var fraseReversed = ""
    var fraseSinEspacios = ""
    frase.forEach {
        if (it != ' ') {

            fraseSinEspacios += it
            fraseReversed = it + fraseReversed

        }

    }

    return fraseSinEspacios.equals(fraseReversed,true)

}

fun main() {

    println("Introduce una frase")
    print("> ")
    val frase = leer.nextLine()

    if (esPalindromo(frase)) {

        println("Es un palíndromo")

    } else {

        println("No es un palíndromo")

    }

}