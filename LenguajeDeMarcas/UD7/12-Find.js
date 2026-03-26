const sout = (a) => console.log(a)

// Filter devuelve TOOODOS los elementos que cumplen una condición
// Find devuelve SOOOOLO el primer elemento que cunple la condición


const usuarios = [

    {id: 1, nombre:"Ana"},
    {id: 2, nombre:"Iker"},
    {id: 3, nombre:"David"},
    {id: 5, nombre:"Almonso"},

]

// Filter me devuelve un array de objetos
const resultado1 = usuarios.filter(usu => usu.id === 2)
resultado1.forEach(sout)

// find me devuelve un objeto
const resultado2 = usuarios.find(usu => usu.id === 2)
sout(resultado2)