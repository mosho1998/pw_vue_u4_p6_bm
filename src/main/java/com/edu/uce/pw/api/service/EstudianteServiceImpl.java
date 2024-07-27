package com.edu.uce.pw.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.uce.pw.api.repository.IEstudianteRepository;
import com.edu.uce.pw.api.repository.modelo.Estudiante;
import com.edu.uce.pw.api.repository.modelo.Materia;
import com.edu.uce.pw.api.service.to.EstudianteTO;
import com.edu.uce.pw.api.service.to.MateriaTO;

@Service
public class EstudianteServiceImpl implements IEstudianteService {

	@Autowired
	private IEstudianteRepository estudianteRepository;

	@Override
	public Estudiante buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.estudianteRepository.seleccionar(id);
	}

	@Override
	public void actualizar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.estudianteRepository.actualizar(estudiante);
	}

	@Override
	public void borrar(Integer id) {
		// TODO Auto-generated method stub
		this.estudianteRepository.eliminar(id);
	}

	@Override
	public void guardar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.estudianteRepository.insertar(estudiante);
	}

	@Override
	public List<Estudiante> buscarPorGenero(String genero) {
		// TODO Auto-generated method stub
		return this.estudianteRepository.seleccionarPorGenero(genero);
	}

	public EstudianteTO convertir(Estudiante estu) {
		EstudianteTO estTO = new EstudianteTO();
		estTO.setId(estu.getId());
		estTO.setNombre(estu.getNombre());
		estTO.setApellido(estu.getApellido());
		estTO.setGenero(estu.getGenero());
		estTO.setFechaNacimiento(estu.getFechaNacimiento());
		estTO.setCedula(estu.getCedula());
		return estTO;
	}
	
	public Estudiante convertirEstudiante(EstudianteTO estudianteTO) {
		Estudiante estu = new Estudiante();
		estu.setId(estudianteTO.getId());
		estu.setApellido(estudianteTO.getApellido());
		estu.setCedula(estudianteTO.getCedula());
		estu.setGenero(estudianteTO.getGenero());
		estu.setFechaNacimiento(estudianteTO.getFechaNacimiento());
		estu.setNombre(estudianteTO.getNombre());

		return estu;
	}

	@Override
	public EstudianteTO buscarPorId(Integer id) {
		Estudiante est = this.estudianteRepository.seleccionar(id);
		return this.convertir(est);
	}

	@Override
	public List<EstudianteTO> bsucarTodosEstudiantes() {
		List<Estudiante> lista = this.estudianteRepository.seleccionarTodosEstudiante();

		List<EstudianteTO> listaFinal = new ArrayList<>();

		for (Estudiante est : lista) {
			listaFinal.add(this.convertir(est));
		}
		return listaFinal;
	}

	
	//METODOS VUE

	@Override
	public void actualizarPorCedula(EstudianteTO estudiante) {
		// TODO Auto-generated method stub
		Estudiante e = this.convertirEstudiante(estudiante);
		this.estudianteRepository.actualizarPorCedula(e);
	}

	@Override
	public void borrarPorCedula(Integer cedula) {
		// TODO Auto-generated method stub
		
		this.estudianteRepository.eliminarPorCedula(cedula);
	}

	@Override
	public EstudianteTO buscarPorCedula(Integer cedula) {
		Estudiante est = this.estudianteRepository.seleccionarPorCedula(cedula);
		return this.convertir(est);
	}
}
