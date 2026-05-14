fun tipoSolicitud(solicitud: Solicitud) {

    when (solicitud) {

        is Cargando -> println("La solicitud está cargando")
        is Error -> println("La solicitud ha dado error")
        is Exito -> println("La solicitud ha sido un éxito")

    }

}

fun main() {

    val cargando = Cargando()
    val exito = Exito()
    val error = Error()

    tipoSolicitud(error)
    tipoSolicitud(cargando)
    tipoSolicitud(exito)

}