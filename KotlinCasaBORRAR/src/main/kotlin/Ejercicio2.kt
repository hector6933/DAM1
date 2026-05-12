package org.example.Ejercicios

fun factorial(num:Int): Int {

    if (num == 0 || num == 1) {

        return 1

    } else {

        return num * factorial(num-1)

    }

}

fun main() {

    println("----------------Calculadora de factorial----------------")
    val numero = pedirInt()

    println("El factorial de ${numero} es ${factorial(numero)}")

    leer.close()

}