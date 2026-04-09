const sout = (a) => console.log(a)

const obtenerUsuarios = async () => {

    try {

        const res = await fetch("https://jsonplaceholder.typicode.com/users")
        const data = await res.json()
        data.forEach(element => {
          
            sout(element.name) 
 
        })

    } catch (error) {

        sout(error)

    }

}

obtenerUsuarios()