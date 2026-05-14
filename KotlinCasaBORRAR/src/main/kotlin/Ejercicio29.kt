fun main() {

    // groupìngBy coje y los almacena como un mapa de clave valor siendo el valor el número de veces que aparece en la lista
    val duplicados: (List<Any>) -> List<Any> = {lista -> lista.groupingBy { it }.eachCount().filter { it.value > 1 }.keys.toList()}

    val numeros = listOf(
        1, 2, 3, 4, 5,
        6, 7, 8, 9, 10,
        3, 5, 7, 10, 12,
        15, 18, 20, 1, 6
    )

    val palabras = listOf(
        "hola",
        "kotlin",
        "java",
        "python",
        "swift",
        "hola",
        "java",
        "rust",
        "scala",
        "python",
        "go",
        "ruby",
        "kotlin",
        "dart",
        "csharp",
        "go",
        "typescript",
        "php",
        "ruby",
        "swift"
    )

    println("Duplicados de números:")
    println(duplicados(numeros))
    println("Duplicados de palabras:")
    println(duplicados(palabras))

}