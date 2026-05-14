fun main() {

    val tareas = arrayListOf(
        Tarea("Estudiar Kotlin", "Alta", false),
        Tarea("Hacer ejercicio", "Media", true),
        Tarea("Comprar comida", "Alta", false),
        Tarea("Leer un libro", "Baja", true),
        Tarea("Terminar proyecto", "Alta", false),
        Tarea("Limpiar la habitación", "Media", true),
        Tarea("Responder correos", "Media", false),
        Tarea("Preparar presentación", "Alta", false),
        Tarea("Ver tutoriales", "Baja", true),
        Tarea("Actualizar CV", "Media", false)
    )

    println("Ordenar por prioridad")
    tareas.sortByDescending {
        when (it.prioridad) {

            "Alta" -> 3
            "Media" -> 2
            "Baja" -> 1
            else -> 0

        }
    }

    tareas.forEach { println(it) }

    println("--------------------------------")

    println("Ordenar por NO completadas")
    tareas.sortBy { it.completada }

    tareas.forEach { println(it) }
}