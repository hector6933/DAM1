import java.time.LocalDate

fun main() {

    val personas = mapOf(
        "Juan Pérez" to LocalDate.of(1990, 5, 12),
        "María García" to LocalDate.of(1985, 8, 3),
        "Carlos López" to LocalDate.of(1998, 1, 25),
        "Lucía Fernández" to LocalDate.of(1992, 11, 14),
        "Pedro Sánchez" to LocalDate.of(1980, 6, 30),
        "Ana Martínez" to LocalDate.of(1995, 9, 8),
        "Miguel Torres" to LocalDate.of(1987, 12, 19),
        "Laura Ruiz" to LocalDate.of(2000, 4, 2),
        "Javier Gómez" to LocalDate.of(1993, 7, 27),
        "Sofía Navarro" to LocalDate.of(1997, 10, 5),
        "Diego Romero" to LocalDate.of(1989, 3, 16),
        "Elena Castro" to LocalDate.of(1991, 2, 11),
        "Pablo Ortega" to LocalDate.of(1984, 1, 7),
        "Carmen Molina" to LocalDate.of(1996, 6, 21),
        "Raúl Delgado" to LocalDate.of(1988, 8, 18),
        "Claudia Vega" to LocalDate.of(2001, 12, 9),
        "Álvaro Herrera" to LocalDate.of(1994, 5, 1),
        "Nerea Silva" to LocalDate.of(1999, 9, 13),
        "Iván Morales" to LocalDate.of(1986, 11, 22),
        "Sara Jiménez" to LocalDate.of(1990, 7, 4)
    )

    println("Mostrar el mas viejo:")
    println(personas.minBy { it.value })
    println("Mostrar el mas joven:")
    println(personas.maxBy { it.value })

    println("---------------------------")
    println("Lista de mayor a menor:")
    personas.values.sortedBy { it }.forEach { println(it)}


}