const sout = (cosa) => console.log(cosa)

// Nos permite extraer los valores de objetos o de arrays fácilmenete lLlLlLlLlLlLlLlLlLlLlLlLlLlLlLlLlLlLlLlLlLlLlLl
const persona = {
    nombre: "Dylan",
    edad: 20
}

/*
const nombre = persona.nombre

const edad = persona.edad
*/

// ALA QUE GUAPO TÍO:
const {nombre,edad} = persona

sout(nombre + " " + edad)