package Ejercicios

import org.w3c.dom.ls.LSOutput
import java.util.Scanner

val leer = Scanner(System.`in`)

fun cuentaChars(frase:String) {

    val letras = mutableMapOf<Char,Int>()

    for (c in frase) {

        letras[c] = letras.getOrDefault(c,0) + 1

    }

    val letrasOrdenadas = ArrayList(letras.entries)

    letrasOrdenadas.sortByDescending { it.value }

    println(letrasOrdenadas)

}

fun main() {

    println("Introduce una frase")
    print("> ")
    cuentaChars(leer.nextLine())





}