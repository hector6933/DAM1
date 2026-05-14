fun main() {

    for (i in 0..10) {

        for (j in 0..20) {

            print("*")

        }
        println()

    }

    println("----------------------------------------")

    for (i in 0..10) {

        for (j in 0..20) {

            if (i == 0 || i == 10) {

                print("*")

            } else {

                if (j == 0 || j == 20) {

                    print("*")

                } else {

                    print(" ")

                }

            }

        }
        println()

    }

    println("----------------------------------------")

    for (i in 1..5) {

        for (j in 1..5 - i) {
            print(" ")
        }

        for (k in 1..(2 * i - 1)) {
            print("*")
        }

        println()
    }

}