import kotlinx.serialization.Serializable

@Serializable
data class Usuario(val id: Int, var nombre: String, var apellidos: String)
