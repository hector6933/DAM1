fun devolverComunes(lista: List<Any>, lista2: List<Any>): List<Any> {

    return lista.filter { it in lista2 }

}

fun main() {

    val lista1 = listOf(
        "manzana", "pera", "uva", "naranja", "kiwi",
        "plátano", "melón", "sandía", "cereza", "limón",
        "mango", "papaya", "piña", "fresa", "coco",
        "melocotón", "ciruela", "granada", "albaricoque", "mandarina",
        "guayaba", "higo", "nectarina", "lima", "frambuesa",
        "arándano", "caqui", "pomelo", "membrillo", "litchi"
    )
    val lista2 = listOf(
        "pera", "uva", "manzana", "mango", "kiwi",
        "sandía", "durazno", "banana", "papaya", "coco",
        "pitahaya", "granada", "ciruela", "maracuyá", "limón",
        "carambola", "guayaba", "pomelo", "fruta del dragón", "higo",
        "lima", "nectarina", "melón", "fresa", "arándano",
        "mandarina", "cereza", "plátano", "frambuesa", "membrillo"
    )

    val comunes = devolverComunes(lista1,lista2)
    println(comunes)
    println(comunes.size)

    println("----------------------------------------------------")

    val comunesPro = lista1.intersect(lista2.toSet())

    println(comunesPro)
    println(comunesPro.size)

}