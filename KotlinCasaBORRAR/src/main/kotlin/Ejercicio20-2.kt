import java.util.Random

fun main() {

    val random = Random()
    var contador = 0
    var pruebas = 0
    var totalTiradas = 0

    var dado1:Int
    var dado2:Int

    do {

        contador = 0
        do {

            dado1 = random.nextInt(1,7)
            dado2 = random.nextInt(1,7)

            contador++

        } while (dado1 != 6 || dado2 != 6)

        totalTiradas += contador

        pruebas++

    } while (pruebas != 10000000)


    println("Media de tiradas en $pruebas pruebas para sacar un doble 6: ${totalTiradas.toDouble() / pruebas}")

}