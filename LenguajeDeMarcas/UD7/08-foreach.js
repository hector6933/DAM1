const sout = (asd) => console.log(asd)

const alumnos = ["Héctor","Javi","María","Dylan"]

// Forma antigua de smr2
/*
for (let i = 0; i < alumnos.length; i++) {

    sout(alumnos[i])

}
*/
// Forma moderna de recorrer un Array
// Esto se asemeja a un lamda de Java
alumnos.forEach( (alumno,i) =>

    sout(`${i+1} | ${alumno}`)

)