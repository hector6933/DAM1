fun main() {

    println("Pirámide normal")
    for (i in 0..5) {

        for (j in 0..i) {

            print("*")

        }

        println()

    }

    println("Pirámide invertida")
    for (i in 5 downTo 0) {

        for (j in 0..i) {

            print("*")

        }

        println()

    }

    do {

        println("Introduce un numero entero")
        print("> ")
        try {

            val num = leer.nextLine().toInt()

            for (i in 1..num) {

                if (num % i == 0) {

                    print("$i,")

                }

            }
            break

        } catch (e: NumberFormatException) {

            println("¡¡¡ Introduce un número entero !!!")

        }


    } while (true)

    println()

    do {

        println("Introduce un numero entero")
        print("> ")
        try {

            var num = leer.nextLine().toInt()

            var divisor = 2
            while (num > 1) {

                if (num % divisor == 0) {

                    println("$num | $divisor")
                    num /= divisor

                } else {

                    divisor++

                }

            }

            println("1")
            break

        } catch (e: NumberFormatException) {

            println("¡¡¡ Introduce un número entero !!!")

        }


    } while (true)



}