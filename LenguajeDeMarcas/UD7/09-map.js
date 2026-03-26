const sout = (a) => console.log(a)

const numeros = [1,2,3,4,5,6,7,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36]

// El map devuelve valores y genera un array

// Si la operación es simple se puede hacer en una línea sin return
const dobles2 = numeros.map(n => n * 2)

// Pero si queremos crear un bloque de código más complejo hay que añadir llaves y return del valor
const dobles = numeros.map( num => {

    sout("Procesando: " + num)
    return num * 2

}
)

sout(dobles)
sout(dobles2)


const ej = numeros.map( (num) => {

    if (num % 2 === 0) {

        return num * 100

    } else {
        return num

    }
 
}
)

sout(ej)

sout("---------------------------------------------------------------------------------------------------------------------------------------------------------")

const usuariosDesdeServidor = [
    {id:1,nombre:"Ana",edad:17},
    {id:2,nombre:"Héctor",edad:28},
    {id:3,nombre:"Remón",edad:67}
]

// Necesitamos listar la UI solo los nombres
// Printearlos
usuariosDesdeServidor.forEach( usuario =>

    sout(usuario.nombre)

)

// Almacenarlos

const nombresUsuarios = usuariosDesdeServidor.map(usu => usu.nombre)

sout(nombresUsuarios)


// Para convertir de un objeto a otro ponemos paréntesis y corchetes con las condiciones dentro
const usuariosTransformados = usuariosDesdeServidor.map( (usu) => ({

    label: usu.nombre,
    valor: usu.id,
    esAdulto: usu.edad >= 18    

})
)

usuariosTransformados.forEach(sout)