<script setup>
import { ref } from 'vue';


    // defineProps(['title','body','id','colorText'])
    const props = defineProps({

        title: String,
        id: String,
        body: {
            type: String,
            default: 'Sin descripción'
        }

    })

</script>

<template>

    <div class="card my-3">
        <div class="card-body">
            <h4 class="card-title">
                {{ title }}
            </h4>
            <p>
                {{ id }} - {{ body }}
            </p>
            <button @click="$emit('cambiarFavorito',title)" class="btn btn-outline-primary">Mi favorito</button>
        </div>
    </div>

</template>