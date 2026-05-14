fun main() {

    val libros = listOf(
        Libro("Cien años de soledad", "Gabriel García Márquez", 1967),
        Libro("Don Quijote de la Mancha", "Miguel de Cervantes", 1605),
        Libro("1984", "George Orwell", 1949),
        Libro("Rebelión en la granja", "George Orwell", 1945),
        Libro("El principito", "Antoine de Saint-Exupéry", 1943),
        Libro("Crimen y castigo", "Fiódor Dostoyevski", 1866),
        Libro("Los miserables", "Victor Hugo", 1862),
        Libro("Orgullo y prejuicio", "Jane Austen", 1813),
        Libro("Moby Dick", "Herman Melville", 1851),
        Libro("La Odisea", "Homero", -700),
        Libro("La Ilíada", "Homero", -750),
        Libro("Fahrenheit 451", "Ray Bradbury", 1953),
        Libro("Drácula", "Bram Stoker", 1897),
        Libro("Frankenstein", "Mary Shelley", 1818),
        Libro("El nombre de la rosa", "Umberto Eco", 1980),
        Libro("Rayuela", "Julio Cortázar", 1963),
        Libro("La sombra del viento", "Carlos Ruiz Zafón", 2001),
        Libro("It", "Stephen King", 1986),
        Libro("El resplandor", "Stephen King", 1977),
        Libro("Dune", "Frank Herbert", 1965),
        Libro("Neuromante", "William Gibson", 1984),
        Libro("La carretera", "Cormac McCarthy", 2006),
        Libro("Ensayo sobre la ceguera", "José Saramago", 1995),
        Libro("El Hobbit", "J.R.R. Tolkien", 1937),
        Libro("El señor de los anillos", "J.R.R. Tolkien", 1954),
        Libro("Harry Potter y la piedra filosofal", "J.K. Rowling", 1997),
        Libro("Juego de tronos", "George R.R. Martin", 1996),
        Libro("El código Da Vinci", "Dan Brown", 2003),
        Libro("Sapiens", "Yuval Noah Harari", 2011),
        Libro("Hábitos atómicos", "James Clear", 2018)
    )

    libros.sortedBy { it.anio }.forEach { println(it) }

}