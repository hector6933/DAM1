const sout = (a) => console.log(a)

fetch("https://pokeapi.co/api/v2/pokemon/") // Esto no va a traer los pokemones, lee las Apis
    .then( // Va a esperar una promesa. Le hemos de decir que obtendremos un JSON y se lo vamos a decir con forma de flecha

        res => res.json()
        
    )
    .then(
        data => data.results.forEach(element => {

            sout(element.name) 
            
        })
    )
