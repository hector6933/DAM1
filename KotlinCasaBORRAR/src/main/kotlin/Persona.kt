import kotlinx.serialization.Serializable

@Serializable
data class Persona(val nombre: String, val apellidos:String, val edad:Int) {
}

@Serializable
data class Personas(val personas: List<Persona>)