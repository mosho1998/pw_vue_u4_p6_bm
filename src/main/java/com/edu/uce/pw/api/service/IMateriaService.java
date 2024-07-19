package com.edu.uce.pw.api.service;

import java.util.List;

import com.edu.uce.pw.api.repository.modelo.Materia;
import com.edu.uce.pw.api.service.to.MateriaTO;

public interface IMateriaService {
	public Materia buscar(Long long1);

	public void actualizar(Materia materia);

	public void borrar(Integer id);

	public void guardar(Materia materia);

	Materia buscar(Integer id);
	
	public List<MateriaTO> seleccionarPorIdEstudiante(Integer id);
}
