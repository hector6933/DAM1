const sout = (a) => console.log(a)

const numeros = [1,2,3,4,5,6,7,8,9,10]

// foreach solo itera, NO DEVUELVE NADAAAAAAAAAAAAAAAAAAAAAA
const r1 = numeros.forEach( n => n * 2)
sout(r1)

// map ESTE SI QUE DEVUELVE VALORES !!!!!!!!!!!!!!!!!!!!!!!!!!!! LET'S GOO
const r2 = numeros.map( n => n * 2)
sout(r2)