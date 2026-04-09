const sout = (a) => console.log(a)

const nombre = "María"
const edad = 67
const ciudad = "Madrid"

// 1. "Hola María"
const saludo = `Hola ${nombre}`

// 2. "María tiene 25 años"
const presentacion = `${nombre} tiene ${edad} años`

// 3. "María es de Madrid y tiene 25 años"
const presentacionCompleta = `${nombre} es de ${ciudad} y tiene ${edad} años`

// 4. Con operación dentro: "María tendrá 26 años el próximo año"
const proximoAnio = `${nombre} tendrá ${edad + 1} años el próximo año`

// 5. Con condicional: "María es adulta" o "María es menor"
const estadoEdad = nombre +  ((edad >= 18) ? " es adulta" : " es menor")

console.log(saludo)
console.log(presentacion)
console.log(presentacionCompleta)
console.log(proximoAnio)
console.log(estadoEdad)


// 1. Copia un array y agrega un elemento
const original = [1, 2, 3]
const copia = [...original,4]

// 2. Combina dos arrays
const array1 = [1, 2, 3]
const array2 = [4, 5, 6]
const combinado = [...array1,...array2]

// 3. Copia un objeto y modifica una propiedad
const persona = { nombre: "Ana", edad: 30 }
const personaActualizada = {...persona,edad: 67}

// 4. Combina dos objetos
const obj1 = { a: 1, b: 2 }
const obj2 = { c: 3, d: 4 }
const combinadoObj = {...obj1,...obj2}

// 5. Copia un array y agrega múltiples elementos
const base = [10, 20]
const conAgregar = [...base,2,3,4,5,6,7,8]

console.log(copia)
console.log(combinado)
console.log(personaActualizada)
console.log(combinadoObj)
console.log(conAgregar)


sout("----------------------------------------")

// 1. Función tradicional → arrow function
function sumar(a, b) {
  return a + b
}
const sumarArrow = (a,b) => a + b

// 2. Función de una línea simplificada
const multiplicar = (a,b) => a * b

// 3. Sin parámetros
function obtenerFecha() {
  return new Date()
}

const obtenerFechaArrow = () => Date()

// 4. Un solo parámetro
const cuadrado = (a) => a * a

// 5. Retornar un objeto
const crearUsuario = (nombre, edad) => ({nombre, edad})

// Prueba
console.log(sumarArrow(5, 3))
console.log(multiplicar(4, 5))
console.log(cuadrado(7))
console.log(crearUsuario("Javi", 20))