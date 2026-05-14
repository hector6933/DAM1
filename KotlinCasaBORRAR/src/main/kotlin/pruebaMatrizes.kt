fun main() {

    val matriz = arrayOf(

        arrayOf(1,2,3,4),
        arrayOf(1,2,67,4),
        arrayOf(1,2,3,4),
        arrayOf(1,2,3,4)

    )

    val matrizTridi = arrayOf(

        arrayOf(
            arrayOf(1,2,3,4),
            arrayOf(1,2,3,4),
            arrayOf(1,2,3,4),
            arrayOf(1,2,3,4)
        ),
        arrayOf(
            arrayOf(1,2,3,4),
            arrayOf(1,2,3,4),
            arrayOf(1,2,100,4),
            arrayOf(1,2,3,4)
        )


    )

    println(matriz[1][2])
    println(matrizTridi[1][2][2])

}