data class Empleado(var nombre: String, var edad: Int) {

    fun jubilacion(): Int {

        return 65 - edad

    }
}