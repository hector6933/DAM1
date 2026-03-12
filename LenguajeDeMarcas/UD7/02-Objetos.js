const persona = {

    nombre: "Ana",
    edad: 23,
    email: "ana@name.me",
    
}

persona.nombre = "Javier Sanz"
persona.edad = 67

console.log(persona)

const diasSemana = ["Lunes","Martes","Miércoles","Abril",200,"Bootstrap",6.7,true,false,persona]

diasSemana.push(true)
console.log(diasSemana.at(9).edad) 

diasSemana[1] = persona.nombre

diasSemana.pop()

console.log(diasSemana)