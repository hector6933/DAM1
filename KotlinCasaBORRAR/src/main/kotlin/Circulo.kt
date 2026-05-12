import kotlin.math.PI
import kotlin.math.pow

class Circulo(var radio: Double) : Figura  {

    override fun area(): Double {

        return PI * radio.pow(2)

    }

}