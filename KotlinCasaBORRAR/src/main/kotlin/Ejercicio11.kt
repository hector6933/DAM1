fun main() {

    val p1 = Producto("Producto Uno", 22.0,33)
    val p2 = p1.copy(nombre="Producto Dos")

    val p1Copy = p1.copy()

    println(p2)
    println(p1 == p1Copy)

    // Guarda los atributos en orden, no se tienen por qué llamar igual
    val (cosa,cosa2) = p1
    // Nombre y precio
    println("$cosa $cosa2")

}