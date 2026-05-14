import kotlinx.serialization.*
import kotlinx.serialization.json.Json
import java.io.File

fun main() {

    println("Deserializar usuarios:")

    val usuarios:Usuarios = Json.decodeFromString(File("src/main/kotlin/ArchivoUsers.json").readText())

    println(usuarios)

    File("src/main/kotlin/ArchivoUsersCOPY.json").writeText(Json{prettyPrint = true}.encodeToString(usuarios))

}