package org.example.Ejercicios

fun eliminarDuplicados(lista: ArrayList<Int>): ArrayList<Int> {

    return lista.distinct() as ArrayList<Int>

}

fun main() {

    var lista = ArrayList<Int>()
    lista.add(22)
    lista.add(22)
    lista.add(2)
    lista.add(3)
    lista.add(4)
    lista.add(5)
    lista.add(6)
    lista.add(7)
    lista.add(67)
    lista.add(67)

    lista = eliminarDuplicados(lista)

    println(lista)

}