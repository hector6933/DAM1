const sout = (asd) => console.log(asd)

// Crear un Array
const frutas = ["Manzana","Pera","Melocotón"]

frutas[1] = "Piña"
frutas.push("Alonso")

sout(frutas)

// Nos devuelve el tamaño del Array
sout("Tamaño de frutas")
sout(frutas.length)

// Queremos sacar el último valor
sout( frutas[ frutas.length - 1] ) // Devuelve 'Alonso'

const carrito = ["Ratón","Alonso","Monitor"]


// Con pop eliminaos el úñtimo elemento
carrito.pop()

carrito.unshift("Licker Ozano") // Añade al principio
carrito.push("Teclado") // Añade al final

sout(carrito)

const lista2 = carrito.shift()

sout(`Lista 2 es: ${carrito}`)

