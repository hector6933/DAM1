const sout = (asd) => console.log(asd)

const numeros = [10, 20, 30, 40, 50]

const [primero, segundo, ...resto] = numeros

sout(resto)