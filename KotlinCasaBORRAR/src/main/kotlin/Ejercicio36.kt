fun main() {

    val agenda = mapOf(
        "Juan Pérez" to 612345678,
        "María López" to 623456789,
        "Carlos Ruiz" to 634567890,
        "Ana García" to 645678901,
        "Luis Fernández" to 656789012,
        "Laura Sánchez" to 667890123,
        "Pedro Martín" to 678901234,
        "Lucía Gómez" to 689012345,
        "Miguel Torres" to 690123456,
        "Sofía Díaz" to 601234567,
        "Javier Morales" to 612398745,
        "Elena Navarro" to 623498756,
        "David Romero" to 634598767,
        "Paula Jiménez" to 645698778,
        "Sergio Castro" to 656798789,
        "Andrea Ortiz" to 667898790,
        "Daniel Vega" to 678998701,
        "Cristina Molina" to 689098712,
        "Adrián Delgado" to 690198723,
        "Raquel Rubio" to 601298734,
        "Pablo Herrera" to 612378945,
        "Marta Silva" to 623478956,
        "Álvaro Cano" to 634578967,
        "Natalia Reyes" to 645678978,
        "Iván Blanco" to 656778989,
        "Beatriz Suárez" to 667878990,
        "Rubén Pascual" to 678978901,
        "Carmen León" to 689078912,
        "Óscar Molina" to 690178923,
        "Pascual" to 676767676,
        "Teresa Vázquez" to 601278934
    )

    println("Agenda: ")
    agenda.forEach { (nombre,numero) ->
        println("$nombre -> $numero")
    }

    println("-----------------------------------")
    println("Agenda ordenada alfabéticamente")
    agenda.entries.sortedBy { it.key }.forEach { (nombre,numero) ->
        println("$nombre -> $numero")
    }

    println("-----------------------------------")
    do {

        println("Buscar contacto: ")
        print("> ")
        val nombre = leer.nextLine()

        if (!agenda.contains(nombre)) {

            println("¡ No existe ese contacto !")

        } else {

            println(agenda[nombre])
            break

        }

    } while (true)



}