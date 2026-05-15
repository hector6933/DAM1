fun buscarLetra(texto: String, letra: Char) {

    // withIndex te crea un "mapa" con la letra y su posición
    val resultados = texto.withIndex().filter { it.value.equals(letra,true) }

    resultados.forEach { println("Letra ${it.value} encontrada en la posición: ${it.index}") }

//    var contador = 0
//    texto.forEachIndexed { index, ch -> if (ch.equals(letra, true)) {
//
//        println("Letra $ch encontrada en la posición: $index")
//        contador++
//
//    }
//    }
//    println("Hay un total de $contador $letra")

}

fun main() {

    val texto = "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit a"

    buscarLetra(texto,'s')

}