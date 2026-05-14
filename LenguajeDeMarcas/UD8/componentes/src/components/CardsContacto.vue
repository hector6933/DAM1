<script setup>

    const props = defineProps({

        title: String,
        email: String,
        especialidad: String

    })

</script>

<template>

    <div class="card my-3 mx-3 bg-warning bg-opacity-25 ">
        <div class="card-body">
            <h4 class="card-title">
                <strong> {{ title }} </strong>
            </h4>
            <p>
                <strong>Email: </strong> {{ email }}
            </p>
            <p>
                <span class="badge rounded-pill text-bg-primary text-opacity-100 bg-opacity-100">{{ especialidad}}</span>
            </p>
            <button @click="$emit('contacto', title)" class="btn btn-outline-success">Contactar</button>
        </div>
    </div>

</template>