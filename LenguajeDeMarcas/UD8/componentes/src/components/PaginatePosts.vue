<script setup>

    const props = defineProps(["inicio","fin","tamanio"])

</script>


<template>

    <div class="btn-group" role="group" aria-label="Basic example">
            <button  @click="$emit('anteriorPost')" type="button" class="btn btn-outline-primary" :disabled="inicio <= 0">Anterior</button>
        <button @click="$emit('siguientePost')" type="button" class="btn btn-outline-primary" :disabled="fin >= tamanio">Siguiente</button>
    </div>

</template>