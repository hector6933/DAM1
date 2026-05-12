import java.util.Random

fun main() {

    val random = Random()
    var contador = 0;

    var dado1:Int
    var dado2:Int

    do {

        dado1 = random.nextInt(1,7)
        dado2 = random.nextInt(1,7)

        println("Valor de los dados:")
        println("Dado 1: $dado1")
        println("Dado 2: $dado2")

        contador++

    } while (dado1 != 6 || dado2 != 6)

    println("¡ Ha salido un doble 6 !")
    println("Veces tirados los dados: $contador")


}