package probatinas

import java.util.Scanner

val leer = Scanner(System.`in`)

fun pedirInt():Int {

    do {

        println("Introduce un número entero")
        print("> ")

        try {

            val numero = leer.nextInt()

            return numero

        } catch (e: Exception) {

            println("Tienes que introducir un número entero !!!")
            leer.nextLine()

        }

    } while (true)

}

fun pedirString(string:String):String {

    val leer = Scanner(System.`in`)

    println("Introduce $string ")
    print("> ")
    return leer.nextLine()

}

fun pedirDouble():Double {

    do {

        println("Introduce un decimal")
        print("> ")

        try {

            var numero = leer.nextDouble()

            return numero

        } catch (e: Exception) {

            println("Tienes que introducir un número decimal !!!")
            leer.nextLine()

        }

    } while (true)

}