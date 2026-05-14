import java.time.LocalDate
import java.time.temporal.ChronoUnit
import java.time.temporal.TemporalAmount

fun main() {

    val hoy = LocalDate.now()

    val proximoEnero = LocalDate.of(hoy.year + 1,1,1,)

    val dias = ChronoUnit.DAYS.between(hoy,proximoEnero)

    println(dias)

}