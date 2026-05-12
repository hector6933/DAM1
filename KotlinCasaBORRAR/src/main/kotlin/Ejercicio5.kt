package org.example.Ejercicios

import kotlin.random.Random

fun main() {

    val random = Random

    val lista = ArrayList<Int>()

    do {

        lista.add(random.nextInt(0,10001))

    } while (lista.size != 100)

    println("Lista de numeros: ")
    println(lista)

    lista.sort()
    lista.reverse()

    println("Top números:")
    println("1 - ${lista[0]}")
    println("2 - ${lista[1]}")
    println("3 - ${lista[2]}")


}