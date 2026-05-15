fun main() {

    val nombres = arrayOf(
        "Juan", "María", "Carlos", "Ana", "Luis",
        "Laura", "Pedro", "Lucía", "Miguel", "Sofía",
        "Javier", "Elena", "David", "Paula", "Sergio",
        "Andrea", "Daniel", "Cristina", "Adrián", "Raquel",
        "Pablo", "Marta", "Álvaro", "Natalia", "Iván",
        "Beatriz", "Rubén", "Carmen", "Óscar", "Teresa"
    )

    val frase = ".Hola mundo que tal estamos hoy" +
            "asd (asdas) dsa dasd ad a dad sa" +
            "asd as" +
            "d as d" +
            "asd " +
            "as d" +
            "sa d" +
            "a."

    val arrayPalabras = Regex("[A-Za-záéíóúÁÉÍÓÚÑñ]+").findAll(frase).map { it.value }.toList()
    val arrayPalabrasMal = frase.split(Regex("[^A-Za-z]"))
    println(arrayPalabras)
    println(arrayPalabrasMal)

}