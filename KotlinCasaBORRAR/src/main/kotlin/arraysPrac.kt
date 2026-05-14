import java.util.Random

fun mostrarTabla(tabla: Array<IntArray>) {

    for (i in tabla) {

        for (j in i) {

            print("| $j |")

        }

        println()

    }

}

fun main() {

    val random = Random()

    // Filas - Columnas
    val tabla = Array(3) { IntArray(4)}

    for (fila in tabla) {

        for (j in fila.indices) {

            fila[j] = random.nextInt(1,101)

        }

    }

    mostrarTabla(tabla)
    println(tabla.size)

}