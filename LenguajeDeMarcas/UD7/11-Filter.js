const sout = (a) => console.log(a)

// filter SELECCIONA ELEMENTOS QUE CUMPLEN UNA CONDICIÓN !!! JUSTO COMO EN JAVAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA 

const numeros = [5,12,8,20,3,15,67]

// Necesito números mayores que 10 !!!! NO ME JODASSSS

const mayoresDe10 = numeros.filter(n => n > 10)

const pares = numeros.filter(n => n % 2 === 0)

sout(mayoresDe10)

sout(pares)


// CASO REALLL !!!!!!!!!!!!!! AAAAAAHHHH

const alumnos = [

    {nombre: "Dylan", nota: 5},
    {nombre: "Dani Remón", nota: 4},
    {nombre: "Dani Remón otra vez", nota: 2},
    {nombre: "Andrés", nota: 10}

]

// Alumno 
const aprobados = alumnos.filter(alumno => alumno.nota >= 5)
const suspendidos = alumnos.filter(alumno => alumno.nota < 5)

sout("Aprobados: ")
aprobados.forEach(sout)

sout("Suspendidos: ")
suspendidos.forEach(sout)