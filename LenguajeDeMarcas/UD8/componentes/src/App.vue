<script setup>
import { ref } from 'vue';
import BlogPost from './components/BlogPost.vue';
import BotonContador from './components/BotonContador.vue';
import CardsContacto from './components/CardsContacto.vue';


const posts = ref([
  { id: 1, title: "Post 01", body: "Contenido del post 01" },
  { id: 2, title: "Post 02", body: "Contenido del post 02" },
  { id: 3, title: "Post 03", body: "Contenido del post 03" },
  { id: 4, title: "Post 04", body: "Contenido del post 04" },
  { id: 5, title: "Post 05", body: "Contenido del post 05" },
  { id: 6, title: "Post 06", body: "Contenido del post 06" },
  { id: 7, title: "Post 07", body: "Contenido del post 07" },
  { id: 8, title: "Post 08", body: "Contenido del post 08" }

])

const personas = ref([
  { id: 1, title: "Juan Pérez", email: "juan@example.com", especialidad: "Desarrollador" },
  { id: 2, title: "María García", email: "maria@example.com", especialidad: "Diseñadora" },
  { id: 3, title: "Carlos López", email: "carlos@example.com", especialidad: "Usuario" }
])

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

      <h1>Contactar con: {{ contacto }} </h1>
      <div class="row justify-content-start">
        <CardsContacto v-for="post in personas" :key="post.id" :title="post.title" :email="post.email"
          :especialidad="post.especialidad" class="col-3 " @contacto="cambiarContacto"/>
      </div>

      <hr>

      <h2>Mi post favorito: {{ miFavorito }}</h2>
      <BlogPost v-for="post in posts" :key="post.id" :title="post.title" :body="post.body" :id="post.id"
        @cambiarFavorito="cambiarFavorito" />

    </div>




  </div>

</template>

<style scoped></style>
