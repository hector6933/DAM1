fun main() {

    val empleados = arrayListOf(
        Empleado("Ana", 28),
        Empleado("Luis", 35),
        Empleado("Marta", 42),
        Empleado("Carlos", 30),
        Empleado("Lucía", 25),
        Empleado("Pedro", 50),
        Empleado("Sofía", 33),
        Empleado("Javier", 29),
        Empleado("Elena", 41),
        Empleado("Miguel", 38),
        Empleado("Laura", 27),
        Empleado("Diego", 45),
        Empleado("Carmen", 52),
        Empleado("Pablo", 31),
        Empleado("Sara", 24),
        Empleado("Álvaro", 36),
        Empleado("Nerea", 26),
        Empleado("Iván", 40),
        Empleado("Claudia", 32),
        Empleado("Raúl", 37)
    )

    println("Empleados ordenados por cercanía a la jubilación")
    empleados.sortBy { it.jubilacion() }
    empleados.forEach { println(it) }

    println("--------------------------------------------")
    println("Empleados filtrados por edad prima")
    empleados.filter {

        val edad = it.edad

        if (edad <= 1) return@filter false

        for (i in 2 until edad) {

            if (edad % i == 0) return@filter false

        }

        return@filter true

    }.forEach { println(it) }

}