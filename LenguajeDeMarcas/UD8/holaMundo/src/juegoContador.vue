<script setup>
import { computed, ref, watch } from 'vue'


const estiloHr = "margin: 10px 0px; border-color: red; border-width: 2px"
const estiloHr2 = "margin: 10px 0px;"

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

const claseContador = computed(() => {
    if (contador.value === 0) {

        return 'color: gray'

    }

    return contador.value > 0 ? 'color: lime' : 'color: red'
})

watch(contador, () => { // La función watch es para que se ejecute cuando el valor de la variable cambie, entonces hace comao una especie de "vigilancia" osea watch

    if (contador.value >= objetivo.value) {

        objetivo.value = objetivo.value * 2

    }
})

let objetivo = ref(50)

</script>



<template>

    <div style="padding: 10px;">
        <div class="miHeader">

            <div class="cosa1">

                <h1 style="display: inline;">Objetivo: </h1>
                <span class="fs-2 text-warning">{{ objetivo }}</span>

            </div>

            <div class="cosa2">

                <h1>Contador</h1>

            </div>


        </div>

        <h2 :style="claseContador" class="text-center my-3">{{ contador }}</h2>

        <div class="d-flex gap-1 justify-content-center my-4">

            <button v-on:click="incrementar" class="btn btn-success">Aumentar</button>
            <button v-on:click="decrementar" class="btn btn-danger">Disminuir</button>
            <button v-on:click="reset" class="btn btn-secondary">Cero</button>
            <button v-on:click="fav" class="btn btn-info">Favorito</button>
            <button v-on:click="clearFav" class="btn btn-warning">Borrar Favoritos</button>

        </div>

        <div class="contenedorCentrado">

            <!-- <h2 :style=" contador >= 0 ? 'color: green' : 'color: red'">{{ contador }}</h2>-->

            <!-- Para que la lógica se haga en el script en vez de en el html-->

            <h2>Números favoritos:</h2>
            <ul>

                <li v-for="numero in favoritos" class="fs-5">
                    {{ numero }}
                </li>

            </ul>

        </div>


    </div>

</template>


<style>

.contenedorCentrado {

    display: grid;
    justify-content: center;

}

.miHeader {

    display: grid;
    grid-template-columns: 1fr auto 1fr;

}

.cosa1 {

    justify-self: start;

}

.cosa2 {

    justify-self: center;

}
</style>
