package org.example.Ejercicios

import java.util.Scanner

val leer = Scanner(System.`in`)

fun pedirInt(): Int{

    do {
        println("Introduce un número enteroo ")
        print("> ")

        try {

            val num = Integer.parseInt(leer.nextLine())

            return num

        } catch (e: NumberFormatException) {

            println("El número debe de ser entero !!!")

        }


    } while (true)

}

fun main() {

    val num1 = pedirInt()
    val num2 = pedirInt()

    print("Respuesta: ")
    if (num1 > num2) {

        println(num1)

    } else if (num2 > num1){

        println(num2)

    } else {

        println("Son iguales")

    }

    leer.close()

}