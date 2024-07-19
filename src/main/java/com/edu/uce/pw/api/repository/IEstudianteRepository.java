package com.edu.uce.pw.api.repository;

import java.util.List;

import com.edu.uce.pw.api.repository.modelo.Estudiante;

public interface IEstudianteRepository {
//CRUD
	Estudiante seleccionar(Integer id);

	void actualizar(Estudiante estudiante);

	void eliminar(Integer id);

	void insertar(Estudiante estudiante);

	List<Estudiante> seleccionarPorGenero(String genero);

	List<Estudiante> seleccionarTodosEstudiante();
	
	//METODOS PARA VUE

	Estudiante seleccionarPorCedula(Integer cedula);

	void actualizarPorCedula(Estudiante estudiante);

	void eliminarPorCedula(Integer cedula);
}
