<script setup>
import { setBlockTracking } from 'vue'

const sout = (a) => console.log(a)

const nombre = "Vue 3"

const styleHr = "margin: 20px 0;"

const arrayFrutas = ["🍎", "🍌", "🍉", "🍓", "🍒"]

const descargaFrutas = [
  {
    name: "Manzana",
    price: "1.00€",
    description: "Manzana Golden",
    stock: 0
  },
  {
    name: "Pera",
    price: "2.00€",
    description: "Pera Conferencia",
    stock: 10
  },
  {
    name: "Naranja",
    price: "3.00€",
    description: "Naranjas de Valencia",
    stock: 20
  }
]

const fruta = {

  name: "Fresa",
  price: "4.00€",
  description: "Fresón de Palos"

}

</script>

<template>

  <div style="padding: 20px;">

    <h1>Hola {{ nombre }}</h1>
    
    <hr :style="styleHr">

    <h1>Directiva v-for</h1>
    <ul>
      <li v-for="(fruta, index) in arrayFrutas" :key="index">
        
        {{ index }} - {{ fruta }}
      </li>
    </ul>

    <hr :style="styleHr">

    <h1>Recorremos un Array de objetos</h1>

    <ul>
      <li v-for="fruta in descargaFrutas" :key="fruta.name">
          {{ fruta.name }} - {{ fruta.description }} - {{ fruta.price }}
      </li>
    </ul>

    <hr :style="styleHr">

    <h1>Recorremos un objeto</h1>

    <ul>
      <li v-for="(valor, propiedad, index) in fruta">
       {{ index }} - {{ propiedad }} - {{ valor }}
      </li>
    </ul>

    <hr :style="styleHr">

    <h1>Lista de productos con 10 o más unidades</h1>
    <ul>
      <li v-for="(valor, propiedad, index) in fruta">
       {{ index }} - {{ propiedad }} - {{ valor }}
      </li>
    </ul>
  </div>

</template>

<style>
  h1 {

    color: white;
    font-weight: bold;
  
  }
</style>