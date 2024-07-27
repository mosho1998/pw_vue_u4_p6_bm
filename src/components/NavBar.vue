<template>
  <div>
    <router-link to="/">Bienvenida</router-link>
    <router-link to="/guardar">Estudiante actualizar</router-link>
    <router-link to="/eliminar">Estudiante crear</router-link>
    <router-link
      :to="{
        name: 'prueba',
        params: { cedula: '1753054285' },
        query: { edad: 15, ciudad: 'quito' },
      }"
      >Estudiante eliminar</router-link
    >
  </div>
</template>

<script>
export default {};
</script>

<style scoped>
div {
  padding: 0px 30px;
}
div a {
  color: aqua;
  margin: 0px 10px;
}
</style>