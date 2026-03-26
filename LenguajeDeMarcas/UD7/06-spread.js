const sout = (cosa) => console.log(cosa)

// Me sirve para operar con arrays y con objetos, me permite expandirlos

const numeros = [1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67]

const listaNumeros = [...numeros,7,8,"Pascual",false,'c',8.8]

sout("Lista numeros: ")
sout(listaNumeros)

sout("")
sout("Longitud: " + listaNumeros.length) 

sout("")
sout("Lista numeros reversed: ")
listaNumeros.reverse()
sout(listaNumeros)

const personas = [{

    nombre: "Alberto",
    edad: 40,

},
{

    nombre: "Pascual",
    edad: 40,

}
]

sout(personas.at(0).nombre)
sout(personas.at(1).nombre)


const persona = {

    nombre: "Alberto",
    edad: 40,

}

const personaCompleta = {

    ...persona,
    ciudad: "Teruel",
    codPost: 44002,
    email: "alberto@gmail.es"

}

const personaCompletisima = {

    ...personaCompleta,
    altura: 6.7,
    peso: 0.0,
    telefono: 6767676767

}

sout(personaCompleta)