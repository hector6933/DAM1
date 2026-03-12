/*
function saludar(nombre){
    return "Hola " + nombre + " !"
}

console.log(saludar("Pascual"));*/

const sout = (cosa) => console.log(cosa)

const saludar = (nombre) => "Hola " + nombre
const sumar = (a,b) => a+b
const fecha = () => new Date()

sout(sumar(6,7))

sout(fecha())

console.log(saludar("pascual"));
