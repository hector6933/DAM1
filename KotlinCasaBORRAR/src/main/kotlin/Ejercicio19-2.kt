fun operar(a: Int, b: Int, operacion: (Int,Int) -> Int): Int {

    return operacion(a,b)

}

fun <T,R> cojones (lista: List<T>, filtro: (T) -> Boolean, transformacion: (T) -> R): List<R>{

    return lista.filter(filtro).map(transformacion)

}

fun main() {

    val operacion = operar(33,40, { a, b -> a + b } )

    println(operacion)

    val lista = listOf(1,2,3,4,5,6,7,8,9)

    val listaResultado = cojones(lista,{it % 2 == 0},{"Es par"})
    println(listaResultado)

}