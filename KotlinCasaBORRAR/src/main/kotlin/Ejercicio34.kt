fun main() {

    val numeros = listOf(
        4, 7, 12, 4, 9, 3,
        7, 7, 2, 10, 12, 5,
        9, 4, 6, 7, 1, 3,
        12, 12, 8, 5, 9, 2,
        4, 6, 7, 10, 11, 3,
        5, 9, 12, 1, 4, 7,
        8, 2, 6, 9, 10, 12,
        3, 4, 5, 7, 11, 1,
        9, 12, 6, 2, 4, 7,
        10, 3, 5, 8, 9, 12
    )

    val mapa = mutableMapOf<Int,Int>()

    for (i in numeros) {

        mapa[i] = mapa.getOrDefault(i,0) + 1

    }

    println(mapa.entries.sortedByDescending { it.value })

}