const sout = (cosa) => console.log(cosa)

const nombre = "Alberto"
const edad = 40
const ciudad = "Teruel"

const mensaje = `Hola ${nombre}, tengo ${edad} años, y vivo en ${ciudad}`
sout(mensaje)

// Se permiten expresiones
const a = 5
const b = 67

const resultado = `La suma es ${a+a+a+a+a+a+a+a+a+a+a+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+a+a+a+a+a+a+a+a+a+a+a+a+a+a+a+a+a+a+a+b+b+b+b+b+b+b+b+b+b+b+b+a+a+a+b+b+b} \nsix seven: ${b}`
sout(resultado)