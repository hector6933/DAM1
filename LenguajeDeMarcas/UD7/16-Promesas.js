const sout = (a) => console.log(a)

// Crear una Promesa
const miPromesa = new Promise((resolve,reject) => {

    // Código asíncrono
    setTimeout( () => {

        const exito = true

        if (exito) {

            resolve("Exito!! Aquí están los datos")

        } else {

            reject("Error: Algo salió mal!")

        }

    }, 2000)

})

sout(" ----------- Inicio ----------- ")

// User esa promesa
miPromesa
    .then( resultado => {

        sout(resultado) // Si se resuelve

    })
    .catch( error => {

        sout(error) // Si falla

    })

sout(" ----------- Fin ----------- ")