fun sumarColumnasTabla(tabla: Array<IntArray>) {

    var suma:Int
    for (j in 0 until tabla[0].size) {

        suma = 0

        for (i in tabla.indices) {

            suma += tabla[i][j]

        }

        println("Columna $j: $suma")

    }

}

fun sumarFilasTablaDevolverArray(tabla: Array<IntArray>): IntArray {

    return tabla.map { it.sum() }.toIntArray()

}

fun sumarFilasTabla(tabla: Array<IntArray>) {

    tabla.forEachIndexed { index, fila -> println("Fila $index: ${fila.sum()}")}

}

fun mostrarTablaa(tabla: Array<IntArray>) {

    for (i in tabla) {

        for (j in i) {

            print("[$j]")

        }

        println()

    }

}

fun main() {

    val matriz = arrayOf(
        intArrayOf(12, 45, 78, 23, 56, 89, 34, 67, 90, 11),
        intArrayOf(54, 21, 87, 65, 32, 10, 98, 43, 76, 29),
        intArrayOf(33, 66, 99, 12, 44, 88, 55, 77, 22, 11),
        intArrayOf(91, 82, 73, 64, 55, 46, 37, 28, 19, 10),
        intArrayOf(14, 28, 42, 56, 70, 84, 98, 13, 27, 41),
        intArrayOf(63, 17, 81, 25, 49, 93, 57, 31, 75, 19),
        intArrayOf(8, 16, 24, 32, 40, 48, 56, 64, 72, 80),
        intArrayOf(95, 85, 75, 65, 55, 45, 35, 25, 15, 5),
        intArrayOf(11, 22, 33, 44, 55, 66, 77, 88, 99, 100),
        intArrayOf(3, 6, 9, 12, 15, 18, 21, 24, 27, 30)
    )

    println("--------------------------------------------------")
    println("Mostrar la tabla")
    mostrarTablaa(matriz)

    println("--------------------------------------------------")
    println("Sumar filas")
    sumarFilasTabla(matriz)

    println("--------------------------------------------------")
    println("Sumar columnas")
    sumarColumnasTabla(matriz)


    println(sumarFilasTablaDevolverArray(matriz).toList())

}