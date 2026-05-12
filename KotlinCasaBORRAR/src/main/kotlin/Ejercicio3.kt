package org.example.Ejercicios

fun main() {

    println("Intdoduce una palabra ")
    print("> ")

    val palabra = leer.next()
    leer.nextLine()

    for (i in 0..palabra.length-1) {

        if (palabra[i] != palabra[palabra.length-1 - i]) {

            println("La palabra NO es un palíndromo")
            return

        }

    }

    println("La palabra ES un palíndromo")

    leer.close()
}