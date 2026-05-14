fun main() {

    var cosa = arrayOf(

        arrayOf(1,2,3,4),
        arrayOf(1,2,3,4),
        arrayOf(1,2,3,4),
        arrayOf(1,2,67,4),
        arrayOf(1,2,3,4)

    )

    for (i in cosa) {

        for (j in i) {

            print("| $j |")

        }

        println()

    }


}