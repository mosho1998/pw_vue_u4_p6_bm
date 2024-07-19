package com.edu.uce.pw.api.service;

import java.util.List;

import com.edu.uce.pw.api.repository.modelo.Estudiante;
import com.edu.uce.pw.api.repository.modelo.Materia;
import com.edu.uce.pw.api.service.to.EstudianteTO;

public interface IEstudianteService {
	// CRUD
	public Estudiante buscar(Integer id);

	public EstudianteTO buscarPorId(Integer id);

	public void actualizar(Estudiante estudiante);

	public void borrar(Integer id);

	public void guardar(Estudiante estudiante);

	List<Estudiante> buscarPorGenero(String genero);

	List<EstudianteTO> bsucarTodosEstudiantes();
	
	//METODOS PARA VUE

		EstudianteTO buscarPorCedula(Integer cedula);

		void actualizarPorCedula(Estudiante estudiante);

		void borrarPorCedula(Integer cedula);

}
