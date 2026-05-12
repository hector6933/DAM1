package org.example

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    var decimal = 33.3
    var entero = decimal.toInt()

    var vuleano = (decimal == decimal || entero == entero)

    println(vuleano)

//    val hola = "Hola mundo"

//    for (i in hola.indices) {
//        println(i)
//    }

    val cosas = "Cosa1,Cosa2,Cosa3".split(",")
    val cosas2 = listOf("Cosa1","Cosa2","Cosa3").joinToString("|")
    println(cosas2)


}