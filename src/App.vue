<template>
  <Estudiante/>
  <Eliminar/>
  <Guardar/>
</template>

<script>
import Estudiante from './components/Estudiante.vue'
import Eliminar from './components/Eliminar.vue'
import Guardar from './components/Guardar.vue'

export default {
  name: 'App',
  components: {
    Estudiante,
    Eliminar,
    Guardar,
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
