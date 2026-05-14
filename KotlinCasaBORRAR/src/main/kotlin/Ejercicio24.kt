fun main() {

    println("Introduce un texto")
    print("> ")
    val texto = leer.nextLine()

    // val palabras = texto.split(Regex("[^a-zA-ZáéíóúÁÉÍÓÚ]+")).filter { it.isNotEmpty() } as ArrayList

    // Necesitas convertirlo (map) a un it.value porque el regex devuelve un MatchResult no strings
    val palabras = Regex("[a-zA-ZáéíóúÁÉÍÓÚ]+").findAll(texto).map { it.value }.toList()

    println(palabras.distinct())
    println(palabras.distinct().size)

}

