fun main() {

    val variable: Any = 33.0

    when (variable) {

        is Circulo -> println("La variable es un círculo")
        is Cuadrado -> println("La variable es un cuadrado")
        is String -> println("La variable es una cadena")
        is Int -> println("La variable es una entero")
        is Double -> println("La variable es una decimal")
        is Empleado -> println("La variable es un empleado")
        is Producto -> println("La variable es un producto")
        else -> println("Ni idea de que es eso")

    }

}
