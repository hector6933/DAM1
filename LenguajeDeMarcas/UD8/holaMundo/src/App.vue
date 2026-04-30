<script setup>
import { computed, ref } from 'vue'


const estiloHr = "margin: 10px 0px; border-color: red; border-width: 2px"
const estiloHr2 = "margin: 10px 0px;"

const click = ( mensaje ) => {

    console.log(mensaje)

}

const click2 = () => {

    console.log("Mensaje click 2")

}

const incrementar = () => {

    contador.value++

}

const decrementar = () => {

    contador.value--

}

const reset = () => {

    contador.value = 0

}

const favoritos = ref([])

const fav = () => {

    if (!favoritos.value.includes(contador.value)) {

        favoritos.value.push(contador.value) 

    }
    
}

const clearFav = () => {

    favoritos.value.length = 0

}

const contador = ref(0)

const claseContador = computed( () => {
    if (contador.value === 0) {

        return 'color: yellow'

    }

    return contador.value > 0 ? 'color: lime' : 'color: red'
})

</script>



<template>

    <div style="padding: 10px;">

        <h1>Botones y cosas</h1>

        <hr :style="`${estiloHr}`">

        <br>
        <button v-on:click="click('Mensaje click 1')">Click Aquí</button>
        <button @click.middle="click2">Click Aquí</button>
        <br>
        <br>

        <h1>Contador</h1>
        <div class="d-flex gap-1">
            <button v-on:click="incrementar" class="btn btn-success">Aumentar</button>
            <button v-on:click="decrementar" class="btn btn-danger">Disminuir</button>
            <button v-on:click="reset" class="btn btn-secondary">Cero</button>
            <button v-on:click="fav" class="btn btn-info">Favorito</button>
            <button v-on:click="clearFav" class="btn btn-warning">Borrar Favoritos</button>
        </div>
        <!-- <h2 :style=" contador >= 0 ? 'color: green' : 'color: red'">{{ contador }}</h2>-->
        <h2 :style="claseContador">{{ contador }}</h2> <!-- Para que la lógica se haga en el script en vez de en el html-->

        <h2>Números favoritos:</h2>
        <ul>
            
            <li v-for="numero in favoritos" class="fs-5">
                {{ numero }}
            </li>

        </ul>

    </div>

</template>


<style>

</style>
