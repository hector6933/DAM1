fun main() {

    val numeros = listOf(
        1, 2, 3, 4, 5,
        6, 7, 8, 9, 10,
        5, 4, 3, 2, 1,
        11, 12, 13, 14, 15,
        16, 17, 18, 19, 20,
        10, 15, 20, 25, 30,
        21, 22, 23, 24, 25,
        26, 27, 28, 29, 30,
        31, 32, 33, 34, 35,
        36, 37, 38, 39, 40,
        40, 39, 38, 37, 36
    )

    println(numeros.toSet()) // Me devuelve un SET no una lista, un set solo puede tener valores únicos, es como un mapa con solo la clave
    println(numeros.distinct()) // Esto me devuelve una lista sin repetidos

}