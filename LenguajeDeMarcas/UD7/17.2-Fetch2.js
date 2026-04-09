const sout = (a) => console.log(a)

sout(" ----------- Inicio ----------- ")

fetch("https://jsonplaceholder.typicode.com/users")
    .then(

        res => res.json()
    )
    .then(

        res => res.forEach(element => {
            
            sout(element.name)

        })
    )

sout(" ----------- Fin ----------- ")
for(let i = 0; i < 100; i++){

    sout("hola " + i)

}
