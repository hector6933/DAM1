import java.util.Scanner

var leer = Scanner(System.`in`)

fun main() {

    println("Introduce una cadena")
    print("> ")
    val cadena = leer.nextLine()

//    var cadenaInvertida = ArrayList<Char>()
//
//    for (i in cadena.indices) {
//
//        cadenaInvertida.add(cadena[cadena.length-1 - i])
//
//    }
//
//    cadena = cadenaInvertida.joinToString("")
//    println(cadena)

//    var cadenaInvertida = ""
//    // El downTo 0 significa "contar hacia abajo hasta" por eso le pongo 0
//    for (i in cadena.length - 1 downTo 0) {
//
//        cadenaInvertida += cadena[i]
//
//    }

    var cadenaInvertida = ""

    cadena.toCharArray().forEach {
        cadenaInvertida = it + cadenaInvertida
    }

    println(cadenaInvertida)


}