package com.edu.uce.pw.api.repository.modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "materia")
@JsonIgnoreProperties(value = "estudiante")
public class Materia {
	@Id
	@GeneratedValue(generator = "seq_materia", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "seq_materia", sequenceName = "seq_materia", allocationSize = 1)
	@Column(name = "materia_id")
	private Integer id;

	@Column(name = "materia_nombre")
	private String nombre;

	@Column(name = "materia_descripcion")
	private String descripcion;

	@Column(name = "materia_creditos")
	private int creditos;
	
	@ManyToOne
	@JoinColumn(name="mate_id_estudiante")
	private Estudiante estudiante;
	
	

	public Estudiante getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}

	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getCreditos() {
		return creditos;
	}

	public void setCreditos(int creditos) {
		this.creditos = creditos;
	}

	public Object getProfesor() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setProfesor(Object profesor) {
		// TODO Auto-generated method stub
		
	}

	public Object getCodigoUnico() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setCodigoUnico(Object codigoUnico) {
		// TODO Auto-generated method stub
		
	}

}
