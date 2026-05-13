fun main() {

    // Buscar el maximo de una matriz tridimensioal

    val matriz =  arrayOf(

        arrayOf(
            intArrayOf(2,5,6,3,2),
            intArrayOf(2,5,6,3,2),
            intArrayOf(2,5,6,3,2)
        ),
        arrayOf(
            intArrayOf(1,5,6,3,2),
            intArrayOf(8,5,9,3,4),
            intArrayOf(2,5,6,3,2)
        )
    )
    var max = 0

    for (array in matriz){
        for (array2 in array){
            for (dato in array2){
                if (dato>max){
                    max = dato
                }

            }
        }
    }

    println(max)

    val array = arrayOf(1,2,3,4)

    println(array.maxBy { it })

    // println(matriz.maxBy { matriz2 -> matriz2.maxBy { matriz3 -> matriz3.maxBy { it } } )

}