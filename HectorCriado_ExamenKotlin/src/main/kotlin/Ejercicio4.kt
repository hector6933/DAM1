fun esMagica(matriz: Array<IntArray>): Boolean {

    var listaMagica = ArrayList<Int>()

    if (!comprobarIgualdad(sumarColumnas(matriz))) {

        return false

    } else {

        listaMagica.add(sumarColumnas(matriz)[0])

    }

    if (!comprobarIgualdad(sumaFilas(matriz))) {

        return false

    } else {

        listaMagica.add(sumaFilas(matriz)[0])

    }

    listaMagica.add(sumaDiagonal1(matriz))
    listaMagica.add(sumaDiagonal2(matriz))

    if (!comprobarIgualdad(listaMagica)) {

        return false

    } else {

        return true

    }

}

fun sumaDiagonal1(matriz: Array<IntArray>) : Int {

    var tam = matriz.size
    var suma = 0
    for (i in 0 until tam) {

        suma += matriz[i][i]

    }

    return suma

}

fun sumaDiagonal2(matriz: Array<IntArray>) : Int {

    var tam = matriz.size
    var suma = 0
    for (i in tam-1 downTo 0) {

        suma += matriz[i][i]

    }

    return suma

}

fun sumaFilas(matriz: Array<IntArray>): ArrayList<Int>{

    var sumaFilas = ArrayList<Int>()

    for (i in matriz) {

        var suma = 0
        for (j in i) {

            suma += j

        }

        sumaFilas.add(suma)

    }
    return sumaFilas

}

fun comprobarIgualdad(lista: ArrayList<Int>) : Boolean{

    lista.forEach {
        if (it != lista[0]) return false
    }

    return true

}

fun sumarColumnas(matriz: Array<IntArray>): ArrayList<Int>{

    var sumaColumnas = ArrayList<Int>()
    var tam = matriz[0].size

    for (i in 0 until tam) {

        var suma = 0
        for (j in 0 until tam) {

            suma += matriz[j][i]

        }

        sumaColumnas.add(suma)

    }

    return sumaColumnas

}

fun pedirEntero(): Int {

    do {

        println("Introduce un número entero")
        print("> ")

        try {

            val num = leer.nextLine().toInt()

            return num

        } catch (e : NumberFormatException) {

            println("¡Introduce un número entero!")

        }

    } while (true)

}

fun main() {

    var tam:Int
    do {

        println("Introduce el tamaño de la matriz")
        print("> ")

        try {

            tam = leer.nextLine().toInt()

            if (tam < 2) {

                println("¡El tamaño debe ser mayor o igual a 2!")

            } else {

                break

            }

        } catch (e : NumberFormatException) {

            println("¡Introduce un número entero!")

        }

    } while (true)

    val matriz = Array(tam) { IntArray(tam) }

    for (i in matriz.indices) {

        for (j in matriz[i].indices) {

            println("Introducir número para la fila $i columna $j")
            matriz[i][j] = pedirEntero()

        }

    }

    if (esMagica(matriz)) {

        println("Es una matriz mágica")

    } else {

        println("No es una matriz mágica")

    }

}