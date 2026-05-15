fun fibonacci(num: Int): Int {

    if (num == 1) return 1
    if (num == 0) return 0

    var a = 0
    var b = 1

    for (i in 2..num) {

        val temp = a + b
        a = b
        b = temp

    }

    return b

}

fun fibonacciRecurs(num: Int): Int {

    if (num == 1) return 1
    if (num == 0) return 0

    return fibonacci(num - 1) + fibonacci(num - 2)

}

fun main() {

    println(fibonacciRecurs(9))
    println(fibonacci(9))

}