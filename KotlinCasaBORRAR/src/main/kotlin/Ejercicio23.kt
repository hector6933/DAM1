import java.time.LocalDate
import java.time.chrono.ChronoLocalDate
import java.time.chrono.ChronoPeriod
import java.time.format.DateTimeFormatter
import java.time.format.TextStyle
import java.time.temporal.ChronoUnit
import java.util.Locale
import java.util.Scanner
import java.util.regex.Pattern

fun main() {

    var fecha: LocalDate
    do {

        println("Introduce una fecha, formato (dd-MM-yyyy)")
        print("> ")
        val input = leer.nextLine()

        try {

            fecha = LocalDate.parse(input, DateTimeFormatter.ofPattern("dd-MM-yyyy"))
            break

        } catch (e: Exception) {

            println("¡¡¡ Formato de fecha inválido !!!")

        }

    } while (true)

    // Para sacarlo en español
    println(fecha.dayOfWeek.getDisplayName(TextStyle.FULL, Locale("es","ES")))

}