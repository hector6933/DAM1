fun main() {

    val numeros = listOf(
        5, 12, 7, 5, 9,
        3, 12, 8, 5, 1,
        7, 7, 10, 3, 12,
        4, 9, 9, 2, 5,
        6, 8, 12, 7, 3,
        1, 4, 4, 9, 10,
        11, 5, 6, 7, 8,
        12, 3, 2, 2, 9,
        10, 11, 5, 4, 6,
        7, 8, 9, 12, 1
    )

    val palabras = arrayOf("hola","que","tal","pascual","supercalifragilisticoespialidoso")

    val texto = "hola pascual que tal estas hola hola andres andres juanma juanma juanma juanma juanma supercalifragilisticoespialidoso"

    // Cuantas veces aparece cada número en un Array
    println(numeros.groupingBy { it }.eachCount().entries.sortedByDescending { it.value })

    // Encontrar palabras en un texto y agruparlas por las veces que se repite
    println(Regex("[a-zA-Z]+").findAll(texto).groupingBy { it.value }.eachCount().entries.sortedByDescending { it.value })

    // Asociar cada palabra a su longitud
    println(palabras.associateWith { it.length }.entries.sortedByDescending { it.value })

    // Cuántas veces aparece cada carácter en un texto
    println(texto.groupingBy { it }.eachCount().entries.sortedByDescending { it.value }.filter { it.key != ' '})

    // Encontrar palabras en un texto y agruparlas por su longitud
    println(Regex("[a-zA-Z]+").findAll(texto).map { it.value }.associateWith { it.length }.entries.sortedByDescending { it.value })

}