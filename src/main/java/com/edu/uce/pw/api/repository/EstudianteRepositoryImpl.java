package com.edu.uce.pw.api.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.edu.uce.pw.api.repository.modelo.Estudiante;
import com.edu.uce.pw.api.service.to.EstudianteTO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class EstudianteRepositoryImpl implements IEstudianteRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Estudiante seleccionar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Estudiante.class, id);
	}

	@Override
	public void actualizar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.entityManager.merge(estudiante);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.entityManager.remove(this.seleccionar(id));
	}

	@Override
	public void insertar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.entityManager.persist(estudiante);
	}

	@Override
	public List<Estudiante> seleccionarPorGenero(String genero) {
		TypedQuery<Estudiante> myQuery = this.entityManager
				.createQuery("SELECT e FROM Estudiante e WHERE e.genero = :genero", Estudiante.class);
		myQuery.setParameter("genero", genero);
		return myQuery.getResultList();
	}

	@Override
	public List<Estudiante> seleccionarTodosEstudiante() {
		TypedQuery<Estudiante> myQuery = this.entityManager.createQuery("SELECT e FROM Estudiante e", Estudiante.class);
		return myQuery.getResultList();
	}

	// CAPACIDADES PARA VUE

	@Override
	public Estudiante seleccionarPorCedula(Integer cedula) {
		TypedQuery<Estudiante> myQuery = this.entityManager
				.createQuery("SELECT e from Estudiante e WHERE e.cedula =: cedula", Estudiante.class);
		myQuery.setParameter("cedula", cedula);
		return myQuery.getSingleResult();
	}

	@Override
	public void actualizarPorCedula(Estudiante estudiante) {
		this.entityManager.merge(estudiante);

	}

	@Override
	public void eliminarPorCedula(Integer cedula) {
		// TODO Auto-generated method stub
		this.entityManager.remove(this.seleccionarPorCedula(cedula));
	}

}
