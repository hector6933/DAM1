
fun String.cuantoDeLargoEsEstoBro(): Int{

    return this.length

}

fun String.delRevesBro(): String{

    return this.reversed()

}

fun String.tomaLasVocalesBro(): String{

    return this.replace(Regex("[^aeiouAEIOU]"),"")

}

fun String.bro(): String{

    this // No sirve para nada jajaja
    return "bro"

}

fun main() {

    val texto = "hola buenas soy un texto, como lo llevas HOLA"

    println(texto.cuantoDeLargoEsEstoBro())
    println(texto.delRevesBro())
    println(texto.tomaLasVocalesBro())
    println(texto.bro())

}