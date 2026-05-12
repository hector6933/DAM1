package org.example.Ejercicios

fun esPrimo(num:Int): Boolean {

    var contador = 0

    for (i in 1..num) {

        if (num % i == 0) {

            contador++

        }

    }

    return contador == 2

}

fun main() {

    println("---------Calculadora de numeros primos---------")
    if (esPrimo(pedirInt())) {

        println("Es primo")

    } else {

        println("NO es primo")

    }

}