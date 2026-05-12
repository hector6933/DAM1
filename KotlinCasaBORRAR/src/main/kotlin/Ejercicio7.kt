package org.example.Ejercicios

import java.util.Scanner

val leer2 = Scanner(System.`in`)

fun main() {

    val listaPalabras = ArrayList<String>()

    do {

        println("Introduce una frase")
        print("> ")
        listaPalabras.add(leer2.nextLine())

    } while (listaPalabras.size != 5)

    listaPalabras.sortBy { it.length }

    println(listaPalabras)

}