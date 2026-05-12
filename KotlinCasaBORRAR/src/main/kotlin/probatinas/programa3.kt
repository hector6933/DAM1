package probatinas

import java.util.Scanner

fun crearPersona():Persona {

    val leer = Scanner(System.`in`)

    val nombre = pedirString("tu nombre")
    var edad = 0
    do {

        println("Edad: ")
        edad = pedirInt()

        if (edad < 0) {

            println("La edad debe de ser un número positivo")

        } else {

            break

        }

    } while (true)

    var salario = 0.0
    do {

        println("Salario: ")
        salario = pedirDouble()

        if (salario < 0) {

            println("El salario debe de ser mayor que 0 !!!")

        } else {

            break

        }

    } while (true)

    return Persona(nombre,edad,salario)

}

fun main(){

    val personas = ArrayList<Persona>()

    do {

        var salir = false

        println("¿Qué desea hacer?")
        println("1 - Crear una persona")
        println("2 - Salir")

        val opt = pedirInt()

        when (opt) {

            1 -> {

                personas.add(crearPersona())
                println("Persona creada correctamente !!!")

            }

            2 -> {

                salir = true

            }

            else -> {

                println("Opción inválida !!!")

            }

        }

    } while (!salir)

    println("Personas creadas: ")
    println(if (personas.isEmpty()) "No hay personas" else personas.toString())

}