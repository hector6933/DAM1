import filtrarYTransformar

fun <T, R> /* Recibe algo de entrada y devuelve algo de salida*/ filtrarYTransformar(lista: List<T> /* Recibe una lista de algo*/, filtro: (T) -> Boolean /* Recibe algo que devuelve true or false */, transformacion: (T) -> R) /* Transforma algo, ejemplo si it es 2: T = it * 2 entonces R será 4*/: List<R> {

    return lista.filter(filtro).map(transformacion)

}

fun main() {

    val lista = listOf(1,2,3,4,5,6,7,8,9)

    println(filtrarYTransformar(lista, {it % 2 == 0},  {67}))

    val lista2 = listOf("Pepe","Juanlu","Ikerr")

    println(filtrarYTransformar(lista2, {it.length % 2 == 0}, {it.uppercase()}))

}