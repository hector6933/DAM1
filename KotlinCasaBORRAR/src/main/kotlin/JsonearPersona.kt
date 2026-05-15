import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonDecoder
import kotlinx.serialization.json.JsonEncoder
import java.io.File

fun main() {

    val personas = listOf(
        Persona("Juan", "Pérez García", 25),
        Persona("María", "López Sánchez", 30),
        Persona("Carlos", "Ruiz Fernández", 22),
        Persona("Ana", "García Martín", 28),
        Persona("Luis", "Fernández Gómez", 35),
        Persona("Laura", "Sánchez Díaz", 19),
        Persona("Pedro", "Martín Torres", 41),
        Persona("Lucía", "Gómez Navarro", 27),
        Persona("Miguel", "Torres Romero", 33),
        Persona("Sofía", "Díaz Morales", 24),
        Persona("Javier", "Morales Castro", 29),
        Persona("Elena", "Navarro Ortiz", 38),
        Persona("David", "Romero Vega", 21),
        Persona("Paula", "Jiménez Castro", 26),
        Persona("Sergio", "Castro Molina", 31),
        Persona("Andrea", "Ortiz Delgado", 23),
        Persona("Daniel", "Vega Rubio", 36),
        Persona("Cristina", "Molina Herrera", 27),
        Persona("Adrián", "Delgado Cano", 40),
        Persona("Raquel", "Rubio León", 32)
    )

    val encodePersonas = Personas(personas)

    File("src/main/kotlin/Personas.json").writeText(Json{prettyPrint = true}.encodeToString(encodePersonas))

    val decodePersonas:Personas = Json.decodeFromString(File("src/main/kotlin/Personas.json").readText())

    decodePersonas.personas.forEach { println(it) }

}