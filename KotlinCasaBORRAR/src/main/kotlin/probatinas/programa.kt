package probatinas

fun main(){

    println("Introduce un número ")
    print("> ")
    val num1 = pedirInt()

    println("Introduce otro número ")
    print("> ")
    val num2 = pedirInt()

    println("La suma de $num1 + $num2 = " + (num1+num2))

}