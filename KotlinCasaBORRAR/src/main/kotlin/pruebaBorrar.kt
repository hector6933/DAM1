import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.io.File

fun main() {

    val usuarios:Usuarios = Json.decodeFromString(File("src/main/kotlin/ArchivoUsers.json").readText())

    File("src/main/kotlin/ArchivoUsersCOPY.json").writeText(Json{prettyPrint = true}.encodeToString(usuarios))

}