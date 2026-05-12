fun main() {

    val productos = arrayListOf(
        Producto("Leche", 1.20, 0),
        Producto("Pan", 0.80, 100),
        Producto("Huevos", 2.50, 30),
        Producto("Arroz", 1.10, 0),
        Producto("Pasta", 1.00, 70),
        Producto("Azúcar", 1.30, 0),
        Producto("Sal", 0.60, 90),
        Producto("Aceite", 3.50, 0),
        Producto("Café", 2.80, 25),
        Producto("Té", 1.90, 0),
        Producto("Galletas", 1.70, 55),
        Producto("Queso", 2.40, 0),
        Producto("Jamon", 2.90, 20),
        Producto("Yogur", 0.90, 0),
        Producto("Manzana", 1.50, 0),
        Producto("Plátano", 1.40, 110),
        Producto("Tomate", 1.60, 95),
        Producto("Pollo", 5.20, 0),
        Producto("Carne", 6.80, 10),
        Producto("aaaaaa", 6.80, 10),
        Producto("Agua", 0.50, 0)
    )

    productos.filter { it.stock > 0 }.forEach {

        println("Precio total de ${it.nombre}: ${it.precio * it.stock}€ ")

    }

}