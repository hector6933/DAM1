const sout = (a) => console.log(a)

// Simularemos una carga de 3 segundos

function descargarDatos() {
    
    const inicio = Date.now()

    // Bloquear durante 3 segundos el programa

    while (Date.now() - inicio <= 3000) {

        // Esperar

    }

    sout("Datos descargados.")
    sout("Han pasado 3 segundos !!!")

}

sout(" ----------- Inicio ----------- ")

setTimeout(() => {

    sout("Después de 3 segundos")
    
}, 3000)

sout(" ----------- Fin ----------- ")
// descargarDatos()


