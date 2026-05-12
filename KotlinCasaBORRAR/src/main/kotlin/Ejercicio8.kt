package org.example.Ejercicios

import java.util.Scanner

val leer3 = Scanner(System.`in`)

fun main() {

    var numero:Int
    do {

        println("Introduce un número")
        print("> ")

        try {

            numero = Integer.parseInt(leer3.nextLine())
            break

        } catch (e: NumberFormatException) {

            println("¡¡¡ Introduce un número válido !!!")

        }

    } while (true)

    print(Integer.toBinaryString(numero))


}