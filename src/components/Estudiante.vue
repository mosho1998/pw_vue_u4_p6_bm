<template>
  <div class="formulario">
    <h2>Formulario de Estudiante</h2>
    <form>
      <div class="form-group">
        <label for="id">ID:</label>
        <input v-model="id" type="text" id="id" />
      </div>
      <div class="form-group">
        <label for="nombre">Nombre:</label>
        <input v-model="nombre" type="text" id="nombre" />
      </div>
      <div class="form-group">
        <label for="apellido">Apellido:</label>
        <input v-model="apellido" type="text" id="apellido" />
      </div>

      <div class="form-group">
        <label for="genero">Genero:</label>
        <input v-model="genero" type="text" id="genero" />
      </div>

      <div class="form-group">
        <label for="fechaNacimiento">Fecha de Nacimiento:</label>
        <input v-model="fechaNacimiento" type="text" id="fechaNacimiento" />
      </div>
      <div class="form-group">
        <label for="cedula">Cédula:</label>
        <input v-model="cedula" type="text" id="cedula" />
      </div>
      <div class="form-buttons">
        <button @click="consultar" type="button">Consultar</button>
        <button @click="actualizar" type="button">Actualizar</button>
      </div>
    </form>
  </div>
</template>

<script>
import {
  obtenerPorCedulaAxiosFachada,
  actualizarFachada,
} from "../clients/clienteEstudiante.js";
export default {
  data() {
    return {
      cedula: null,
      genero: null,
      nombre: null,
      apellido: null,
      fechaNacimiento: null,
    };
  },
  methods: {
    async consultar() {
      console.log(this.cedula);
      const data = await obtenerPorCedulaAxiosFachada(this.cedula);
      console.log(data);
      console.log(data.nombre);
      console.log(data.apellido);
      this.genero = data.genero;
      this.nombre = data.nombre;
      this.apellido = data.apellido;
      this.fechaNacimiento = data.fechaNacimiento;
    },

    async actualizar() {
      //"1998-09-07T10:45:34"
      
      console.log(this.fechaNacimiento);

      let fechaFinal = this.fechaNacimiento + "T00:00:00";

      const bodyEstudiante = {
        nombre: this.nombre,
        apellido: this.apellido,
        fechaNacimiento: fechaFinal,
        genero: this.genero,
      };
      const data = await actualizarFachada(this.cedula, bodyEstudiante);
      console.log(data);
    },


    
  },
};
</script>

<style scoped>
.formulario {
  max-width: 400px;
  margin: 40px auto;
  padding: 20px;
  background: #f9f9f9;
  border: 1px solid #ddd;
  border-radius: 10px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
}
h2 {
  text-align: center;
  margin-bottom: 20px;
  color: #333;
}
.form-group {
  margin-bottom: 20px;
}
.form-group label {
  display: block;
  margin-bottom: 8px;
  font-weight: bold;
  color: #555;
}
.form-group input {
  width: 100%;
  padding: 10px;
  border: 1px solid #ccc;
  border-radius: 5px;
  box-sizing: border-box;
  transition: border-color 0.3s;
}
.form-group input:focus {
  border-color: #007bff;
  outline: none;
}
.form-buttons {
  display: flex;
  justify-content: space-between;
}
.form-buttons button {
  width: 48%;
  padding: 10px;
  background-color: #007bff;
  color: white;
  border: none;
  border-radius: 5px;
  cursor: pointer;
  transition: background-color 0.3s;
}
.form-buttons button:hover {
  background-color: #0056b3;
}
.redirect-button {
  display: block;
  width: 100%;
  padding: 10px;
  margin-top: 20px;
  background-color: #28a745;
  color: white;
  border: none;
  border-radius: 5px;
  text-align: center;
  cursor: pointer;
  transition: background-color 0.3s;
}
.redirect-button:hover {
  background-color: #218838;
}
</style>
