<template>
  <div class="formulario">
    <h2>Formulario de Estudiante</h2>
    <form>
      <div class="form-group">
        <label for="id">ID:</label>
        <input type="text" id="id" />
      </div>
      <div class="form-group">
        <label for="nombre">Nombre:</label>
        <input type="text" id="nombre" />
      </div>
      <div class="form-group">
        <label for="apellido">Apellido:</label>
        <input type="text" id="apellido" />
      </div>
      <div class="form-group">
        <label for="fechaNacimiento">Fecha de Nacimiento:</label>
        <input type="date" id="fechaNacimiento" />
      </div>
      <div class="form-group">
        <label for="cedula">Cédula:</label>
        <input type="text" id="cedula" />
      </div>
      <div class="form-buttons">
        <button type="button">Consultar</button>
        <button type="button">Actualizar</button>
      </div>
    </form>
  </div>
</template>

<script>
export default {
  name: 'Estudiante'
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
