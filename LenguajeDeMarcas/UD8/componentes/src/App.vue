<script setup>
import { computed, ref } from 'vue';
import BlogPost from './components/BlogPost.vue';
import BotonContador from './components/BotonContador.vue';
import CardsContacto from './components/CardsContacto.vue';
import PaginatePosts from './components/PaginatePosts.vue';
import LoadingSpinner from './components/LoadingSpinner.vue';


const posts = ref([])
const loading = ref(true)

fetch('https://jsonplaceholder.typicode.com/posts').then(response => response.json()).then(data => posts.value = data)
  .finally(() => {


    setTimeout(() => {
      console.log("3 segundos de espera")
      loading.value = false
    }, 3000)


  }
  )
const tam = computed(() => posts.value.length)
const personas = ref([
  { id: 1, title: "Juan Pérez", email: "juan@example.com", especialidad: "Desarrollador" },
  { id: 2, title: "María García", email: "maria@example.com", especialidad: "Diseñadora" },
  { id: 3, title: "Carlos López", email: "carlos@example.com", especialidad: "Usuario" }
])

const postPorPagina = 10
const inicio = ref(0)
const fin = ref(postPorPagina)


const siguientePost = () => {

  if (fin.value < posts.value.length) {
    inicio.value += 10
    fin.value += 10
  }

}

const anteriorPost = () => {

  if (inicio.value > 0) {

    inicio.value -= 10
    fin.value -= 10

  }

}

const miFavorito = ref("")

const cambiarFavorito = (titulo) => {
  miFavorito.value = titulo
}

const contacto = ref("Sin contacto")

const cambiarContacto = (titulo) => {
  contacto.value = titulo
}

</script>

<template>

  <div class="mx-5 mt-5">
    <h1>DAM 1 - 2026</h1>

    <hr>

    <div class="container-fluid">

      <div class="row justify-content-center">
        <BotonContador class="btn btn-primary col-3"></BotonContador>
      </div>


      <h1>Contactar con: {{ contacto }} </h1>
      <div class="row justify-content-center">
        <CardsContacto v-for="post in personas" :key="post.id" :title="post.title" :email="post.email"
          :especialidad="post.especialidad" class="col-3 " @contacto="cambiarContacto" />
      </div>

      <hr>

      <LoadingSpinner v-if="loading"></LoadingSpinner>
      <div v-else>
        
        <h2>Mi post favorito: {{ miFavorito }}</h2>


        <PaginatePosts @anteriorPost="anteriorPost" @siguientePost="siguientePost" :inicio="inicio" :fin="fin"
          :tamanio="tam"></PaginatePosts>

        <BlogPost v-for="post in posts.slice(inicio, fin)" :key="post.id" :title="post.title" :body="post.body"
          :id="post.id" @cambiarFavorito="cambiarFavorito" />

      </div>


    </div>

  </div>

</template>

<style scoped></style>
