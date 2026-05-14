<script setup>
import { ref } from 'vue';

const contador = ref(7342874479234237)
const incrementar = () => contador.value++


</script>

<template>
    <button @click="incrementar">Contador {{ contador }}</button>
</template>