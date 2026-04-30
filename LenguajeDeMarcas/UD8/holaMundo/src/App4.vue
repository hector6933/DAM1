<script setup>

const estiloHr = "margin: 10px 0px; border-color: red; border-width: 2px"
const estiloHr2 = "margin: 10px 0px;"

const productos = [
    { id: 1, nombre: 'Portátil', precio: 999, stock: 12, categoria: 'Electrónica' },
    { id: 2, nombre: 'Teclado', precio: 49, stock: 34, categoria: 'Periféricos' },
    { id: 3, nombre: 'Monitor', precio: 320, stock: 8, categoria: 'Electrónica' },
    { id: 4, nombre: 'Ratón', precio: 25, stock: 60, categoria: 'Periféricos' },
    { id: 5, nombre: 'Auriculares', precio: 89, stock: 20, categoria: 'Audio' },
    { id: 6, nombre: 'Webcam', precio: 75, stock: 15, categoria: 'Periféricos' },
    { id: 7, nombre: 'SSD 1TB', precio: 110, stock: 27, categoria: 'Almacenamiento' },
    { id: 8, nombre: 'Hub USB', precio: 35, stock: 45, categoria: 'Periféricos' },
    { id: 9, nombre: 'Altavoces', precio: 130, stock: 9, categoria: 'Audio' },
    { id: 10, nombre: 'Alfombrilla', precio: 18, stock: 80, categoria: 'Periféricos' },
]


const estudiantes = [
    { id: 1, nombre: 'Dani Remón', nota: -0.3, aprobado: false, curso: 'DAW' },
    { id: 2, nombre: 'Luis Martín', nota: 4.9, aprobado: false, curso: 'DAM' },
    { id: 3, nombre: 'Sara López', nota: 7.5, aprobado: true, curso: 'ASIR' },
    { id: 4, nombre: 'Carlos Pérez', nota: 6.0, aprobado: true, curso: 'DAW' },
    { id: 5, nombre: 'Diego Quiles', nota: 3.1, aprobado: false, curso: 'DAM' },
    { id: 6, nombre: 'Pedro Sanz', nota: 8.8, aprobado: true, curso: 'ASIR' },
    { id: 7, nombre: 'Elena Vega', nota: 5.5, aprobado: true, curso: 'DAW' },
    { id: 8, nombre: 'Hector Enguita', nota: 5  , aprobado: true, curso: 'DAM' },
    { id: 9, nombre: 'Hector Lozano', nota: 9.7, aprobado: true, curso: 'ASIR' },
    { id: 10, nombre: 'Tomás Gil', nota: 7.0, aprobado: true, curso: 'DAW' },
]

</script>

<template>

    <div style="padding: 15px;">

        <h1>Ejercicios de repaso</h1>

        <hr :style="`${estiloHr}`">

        <h2>Productos: </h2>
        <ul>
            <li v-for="producto in productos">
                {{ producto.nombre }}
            </li>
        </ul>

        <hr :style="`${estiloHr2}`">

        <h2>Estudiantes: </h2>

        <ul>
            <li v-for="estudiante in estudiantes">
                {{ estudiante.nombre }}
            </li>
        </ul>

        <hr :style="`${estiloHr2}`">

        <h2>V-for con v-if: Productos con valor superior a 50</h2>
        <ul>

            <template v-for="producto in productos">

                <li v-if="producto.precio > 50">

                    {{ producto.nombre }} -- {{ producto.precio }}€

                </li>

            </template>

        </ul>

        <hr :style="`${estiloHr2}`">

        <h2>Estudiantes aprobados:</h2>

        <ul>

            <template v-for="estudiante in estudiantes">

                <li v-if="estudiante.aprobado">

                    {{ estudiante.nombre }}

                </li>

            </template>

        </ul>

    </div>


</template>


<style></style>