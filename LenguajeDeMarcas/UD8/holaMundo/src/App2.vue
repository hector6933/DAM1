<script setup>
const sout = (a) => console.log(a)

const colores = ['white','blue','red','green','yellow']

/* const color = 'blue'

const obtenerUsuarios = async () => {

    while (true) {

      colores.forEach( col => color = col)
    

    }

}*/

const nombre = "la clase de DAM 1"

const styleColor = "color: white;"
const styleBold = "font-weight: bold;"

const styleHr = "margin: 20px 0;"

const active = false


</script>

<template>

  <div style="padding: 20px;">

    <h1>Hola {{ nombre }}</h1>
    <h2 :style="styleColor">Hola {{ nombre }}</h2>

    <hr :style="styleHr">

    <h2>Hola {{ nombre.toUpperCase() }}</h2>

    <hr :style="styleHr">

    <p>{{ active ? 'Estoy activo' : 'Estoy inactivo' }}</p>

    <h3 :style="`color: ${colores[1]}`">Color con interpolación</h3>

    <hr :style="styleHr">

    <h1>Directiva v-if</h1> <!-- v-if lo pone o no lo pone-->
    <h2 v-if="active">Active vale true</h2> <!-- Muestra algo o no dependiendo del valor booleano proporcionado-->
    <h2 v-else-if="activa === false">Active vale false</h2>
    <h2 v-else>No se sabe lo que vale active</h2> <!-- Para poder usar el v-else el elemento anterior debe de ser un v-if, si no da fallo -->
    <!-- <h2 v-if="!active">Active vale false</h2> otra manera -->

    <hr :style="styleHr">

    <h1>Directiva v-show</h1> <!-- Si que lo pone pero no lo muestra -->

    <h2 v-show="active">Active vale true</h2>

  </div>
  
</template>



<style>
  h1 {

    color: white;
    font-weight: bold;
  
  }
</style>